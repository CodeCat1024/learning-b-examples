package a_byte.write;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 一次写入多个字节
 */
public class B_ {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("d:/testJavaIO.txt")) {
            byte[] buffer = new byte[] {97, 98, 99, 100, 101};
            outputStream.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
