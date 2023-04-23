package c_cases;

import java.io.*;
import java.util.Scanner;

/**
 * 让用户指定两个文件路径：1.被复制的文件 2.目标路径
 */
public class B_CopyFile {
    public static void main(String[] args) {
        // 1.输入两个路径
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要拷贝的源路径：");
        String src = scanner.next();
        System.out.println("请输入的拷贝的目标路径");
        String dest = scanner.next();

        File srcFile = new File(src);
        if (!srcFile.isFile()) {
            System.out.println("抱歉，输入的源路径不正确！");
            return;
        }
        File destFile = new File(dest);
        if (!destFile.isFile()) {
            System.out.println("抱歉，输入的拷贝路径不正确！");
            return;
        }
        // 此处不太需要检查目标文件是否存在， OutputStream 写文件的时候能够自动创建不存在的文件

        // 2.读取源文件，拷贝到目标文件中
        try (InputStream inputStream = new FileInputStream(src)) {
            try (OutputStream outputStream = new FileOutputStream(dest)) {
                // 把inputStream 中的数据读出来写入到 outputStream 中
                byte[] buffer = new byte[1024];
                while (true) {
                    int len = inputStream.read(buffer);
                    if (len == -1) {
                        break;
                    }
                    // 写入的时候，不能把整个 buffer 都写进去，毕竟 buffer 可能只有一部分才是有效数据
                    outputStream.write(buffer, 0, len);
                    System.out.println("恭喜，拷贝成功！");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
