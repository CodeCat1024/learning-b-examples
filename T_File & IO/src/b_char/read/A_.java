package b_char.read;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * 按照字符读取
 */
public class A_ {
    public static void main(String[] args) {
        try (Reader reader = new FileReader("d:/testJavaIO.txt")) {
            while (true) {
                char[] buffer = new char[1024];
                int len = reader.read(buffer);
                if (len == -1) {
                    break;
                }
//                for (int i = 0; i < len; i++) {
//                    System.out.println(buffer[i]);
//                }
                // 如果传入的是 byte 数组，还可以手动指定一下 utf8 字符集编码乱码
                String s = new String(buffer, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
