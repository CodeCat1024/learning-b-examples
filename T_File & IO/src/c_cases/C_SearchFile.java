package c_cases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

/**
 * 扫描指定目录，并找到名称或者内容中包含指定字符的所有普通文件（不包含目录）
 */
public class C_SearchFile {
    public static void main(String[] args) throws IOException {
        // 1.输入要扫描的文件路径
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的路径：");
        String rootDirPath = scanner.next();

        System.out.println("请输入要查询的关键词");
        String word = scanner.next();
        File rootDir = new File(rootDirPath);
        if (!rootDir.isDirectory()) {
            System.out.println("抱歉，输入的路径非法！");
            return;
        }

        // 2.递归地进行遍历
        scanDir(rootDir, word);
    }

    private static void scanDir(File rootDir, String word) throws IOException {
        // 1.现列出 rootDir 中都有哪些内容
        File[] files = rootDir.listFiles();
        if (files == null) {
            return;
        }
        // 2.遍历每个元素，针对普通文件和目录分别进行处理
        for (File f : files) {
            if (f.isFile()) {
                // 针对文件进行内容查找
                if (containsWord(f, word)) {
                    System.out.println(f.getCanonicalPath());
                }
            } else if (f.isDirectory()) {
                scanDir(f, word);
            }
        }
    }

    private static boolean containsWord(File f, String word) {
        StringBuilder stringBuilder = new StringBuilder();

        // 把 f 中的内容都读出来，放到 StringBuilder 中
        try (Reader reader = new FileReader(f)) {
            char[] buffer = new char[1024];
            while (true) {
                int len = reader.read(buffer);
                if (len == -1) {
                    break;
                }
                // 把这一段读到的结果，放到 StringBuilder 中
                stringBuilder.append(buffer, 0, len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // indexOf 返回的是子串的下标，如果 word 在 stringBuilder 中存在，则返回下标为     -1
        return stringBuilder.indexOf(word) != -1;
    }
}
