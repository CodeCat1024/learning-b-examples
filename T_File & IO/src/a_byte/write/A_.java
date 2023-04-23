package a_byte.write;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * 一次写入一个字节
 */
public class A_ {
    public static void main(String[] args) {
        try (OutputStream outputStream = new FileOutputStream("d:/testJavaIO.txt")) {
            outputStream.write(97);
            outputStream.write(98);
            outputStream.write(99);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
