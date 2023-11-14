package a_byte.read;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 每次读取一个字节
 */
public class A {
    public static void main(String[] args) {
        // 此处的打开的路径可以是绝对路径也可以是相对路径，还可以是 File 对象
        InputStream inputStream = null;
        try {
            // 1.创建对象，同时也是在打开文件
            inputStream = new FileInputStream("d:/textJavaIO.txt");
            // 2.尝试一个一个字节地读，把整个文件读完
            while (true) {
                int b = inputStream.read();
                if (b == -1) {
                    // 读到了文件末尾
                    break;
                }
                System.out.println(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 3.关闭文件，释放资源
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
