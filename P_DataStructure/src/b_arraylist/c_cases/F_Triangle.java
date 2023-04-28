package b_arraylist.c_cases;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负整数 numRows，生成杨辉三角
 */
public class F_Triangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<>();

        List<Integer> row = new ArrayList<>();
        row.add(1);
        ret.add(row);

        for (int i = 1; i < numRows; i++) {
            List<Integer> prevRow = ret.get(i - 1); //前一行

            List<Integer> curRow = new ArrayList<>();
            curRow.add(1); // 第一个1

            // 中间 curRow list的赋值
            for (int j = i; j < i; j++) {
                int x = prevRow.get(j) + prevRow.get(j - 1);
                curRow.add(x);
            }

            curRow.add(1); // 最后一个1
            ret.add(curRow);
        }
        return ret;
    }


    public static void main(String[] args) {
        
    }
}
