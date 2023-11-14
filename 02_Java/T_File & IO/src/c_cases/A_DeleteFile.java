package c_cases;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 扫描指定目录，并找到名称中包含指定字符的所有普通文件（不包含目录）
 * 并且后续询问用户是否要删除该文件
 */
public class A_DeleteFile {
    public static void main(String[] args) {
        // 1.先输入要扫描的目录，以及要删除的文件名
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要扫描的路径：");

        String rootDirPath = scanner.next();
        File rootDir = new File(rootDirPath);
        if (!rootDir.isDirectory()) {
            System.out.println("输入的扫描路径有误！");
            return;
        }

        System.out.println("请输入要删除的文件名：");

        String toDeleteName = scanner.next();

        // 2.遍历目录，把指定目录中的所有文件和子目录都遍历一遍，找到文件
        //   通过这个方法来实现递归遍历并删除的操作
        scanDir(rootDir, toDeleteName);

    }

    private static void scanDir(File rootDir, String toDeleteName) {
        // 1.先列出 rootDir 中都有哪些内容
        File[] files = rootDir.listFiles();
        if (files == null) {
            // rootDir 是一个空目录
            return;
        }
        // 2.遍历当前列出的这些内容，如果是普通文件，就检测文件名
        //   如果是目录，就递归地进行遍历
        for (File f : files) {
            if(f.isFile()) {
                // 普通文件则删除
                if(f.getName().contains(toDeleteName)) {
                    // 不要求名字完全一样，只要文件名中包含关键字即可
                    deleteFile(f);
                }
            } else if (f.isDirectory()){
                // 目录则遍历
                scanDir(f, toDeleteName);
            }

        }
    }

    private static void deleteFile(File f) {
        try {
            System.out.println("确认要删除文件 " + f.getCanonicalPath() + " 吗？（Y / N）");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if (choice.equals("Y") || choice.equals("y")) {
                f.delete();
                System.out.println(f.getCanonicalPath() + " 文件删除成功！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}










