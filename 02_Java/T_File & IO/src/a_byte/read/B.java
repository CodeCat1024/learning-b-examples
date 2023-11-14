package a_byte.read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自动关闭资源演示
 */
public class B {
    public static void main(String[] args) {

        try (InputStream inputStream = new FileInputStream("d:/textJavaIO.txtd")) {
            while (true) {
                int b = inputStream.read();
                if (b == -1) {
                    break;
                }
                System.out.println(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
