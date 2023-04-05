package searcher;

import common.DocInfo;
import index.Index;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

// 通过这个类来完成核心的搜索过程
public class Searcher {
    private Index index = new Index();

    public Searcher() throws IOException {
        index. build("D:/raw_data.txt");
    }

    public List<Result> search(String query) {
        // 分词：根据查询词进行分词
        List<Term> terms =  ToAnalysis.parse(query).getTerms();
        // 触发：针对查询词的分词结果依次查找倒排索引，得到一大堆相关的docId
        // 这个ArrayList中就保存了每个分词结果，得到的倒排拉链的整体结果
        ArrayList<Index.Weight> allTokenResult = new ArrayList<>();
        for (Term term : terms) {
            // 此处得到的 word 就已经是全小写的内容了， 索引中的内容也是全小写的
            String word = term.getName();
            List<Index.Weight> invertedList =  index.getInverted(word);
            if (invertedList == null) {
                // 这个词在文档中不存在
                continue;
            }
            allTokenResult.addAll(invertedList);
        }
        // 排序：按照权重进行降序排序
        // 匿名内部类，让这个类实现了Comparator接口
        allTokenResult.sort(new Comparator<Index.Weight>() {
            @Override
            public int compare(Index.Weight o1, Index.Weight o2) {
                // 如果 o1 < o2 返回一个 < 0
                // 如果 o1 > o2 返回一个 > 0
                // 如果 o1 == o2 返回0
                return o2.weight - o1.weight;
            }
        });
        // 包装结果：根据刚才查找到的docId在正排中查找DocInfo，包装秤 Result 对象
        ArrayList<Result> results = new ArrayList<>();
        for (Index.Weight weight : allTokenResult) {
            // 根据 weight 中包含的docId找到对应的DocInfo对象
            DocInfo docInfo = index.getDocInfo(weight.docId);
            Result result = new Result();
            result.setTitle(docInfo.getTitle());
            result.setShowUrl(docInfo.getUrl());
            result.setClickUrl(docInfo.getUrl());
            // 从正文中摘取一段摘要信息，根据当前的词找到在正文中的文字，然后获取周围的片段
            result.setDesc(GenDesc(docInfo.getContent(), weight.word));
            results.add(result);
        }
        return results;
    }

    private String GenDesc(String content, String word) {
        // 查找word在content中出现的位置
        // word里面内容已经是全小写了，content里面还是大小写都有
        int firstPos =  content.toLowerCase().indexOf(word);
        if (firstPos == -1 ) {
            // 极端情况下，某个词只在标题中出现，没有在正文中出现
            // 这种情况非常少见，暂时不考虑
            return "";
        }
        // 从firstPos开始往前找60个字符，作为描述开始，如果前面不足60个，就从正文头部开始
        int descBeg = firstPos < 60 ? 0 : firstPos - 60;
        // 从描述开始往后找160个字符作为描述内容，如果后面不足160个，就把剩下的都算上
        if (descBeg + 160 > content.length()) {
            return content.substring(descBeg);
        }
        return content.substring(descBeg, descBeg + 160) + "...";
    }
}
