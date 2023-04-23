package b_char.write;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 按照字符写
 */
public class A_ {
    public static void main(String[] args) {
        try (Writer writer = new FileWriter("d:/testJavaIO.txt")) {
            writer.write("lyx");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
