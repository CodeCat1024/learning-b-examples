import common.DocInfo;
import index.Index;

import java.io.IOException;
import java.util.List;

public class TestIndex{
    // 这个方法辅助进行索引测试
    public static void main(String[] args) throws IOException {
        Index index = new Index();
        index.build("D:/raw_data.txt");

        // 由于索引中的key都是小写的，查找的时候，词也得是全小写的
        List<Index.Weight> invertedList = index.getInverted("arraylist");

        for (Index.Weight weight : invertedList) {
            System.out.println(weight.docId);
            System.out.println(weight.word);
            System.out.println(weight.weight);

            DocInfo docInfo = index.getDocInfo(weight.docId);
            System.out.println(docInfo.getTitle());
            System.out.println("------------------------");
        }
    }
}
