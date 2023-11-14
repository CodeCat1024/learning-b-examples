package a_byte.read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 每次读取多个字节
 */
public class C {
    public static void main(String[] args) {
        try (InputStream inputStream = new FileInputStream("d:/testJavaIO.txt")) {
            while (true) {
                // 一次读取若干个字节
                byte[] buffer = new byte[1024];
                int len = inputStream.read(buffer);
                if (len == -1) {
                    // 如果返回-1，说明读取完毕
                    break;
                }
                for (int i = 0; i < len; i++) {
                    System.out.println(buffer[i]);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
