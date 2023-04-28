package b_arraylist.c_cases;

import java.util.ArrayList;

/**
 *  删除s1中的字符，这些字符都是s2中出现的
 *  要求结果为："wl t bit"
 */
public class D_DeleteCharacter {
    public static void main(String[] args) {
        ArrayList<Character> list = new ArrayList<>();
        String s1 = "welcome to bit";
        String s2 = "come";

        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (!s2.contains(ch + "")) {
                list.add(ch);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
        }
    }
}
