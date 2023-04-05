import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.util.List;

public class TestAnsj {
    public static void main(String[] args) {
        String str = "小明同学毕业于清华大学计算机专业，后来去蓝翔技校和新东方进行深造" +
                "擅长使用计算机控制挖掘机炒菜";

        // 通过刚才这个parse方法就直接分完，再通过getTerms就可以得到分词结果
        // 如果是英文会转换成小写
        List<Term> terms =  ToAnalysis.parse(str).getTerms();
        for (Term term : terms) {
            System.out.println(term.getName());
        }

    }
}
