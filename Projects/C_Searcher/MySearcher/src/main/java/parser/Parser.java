package parser;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

// 遍历文档目录，读取所有的html文档内容，把结果解析成行文本文件
// 每一行都对应一个文档，每一行中都包含标题，文档的url，文档的正文（去掉标签的内容）
// Parser是一个单独的可执行的类（带有main方法）
public class Parser {
    private static final String INPUT_PATH = "C:\\Users\\27208\\Desktop\\ComputerScience\\Java\\docs\\api";
    private static final String OUTPUT_PATH = "D:\\raw_data.txt";

    public static void main(String[] args) throws IOException {
        // 通过main方法完成整个预处理的过程
        // 1.枚举出所有的HTML文件（递归）
        // 2.针对枚举出来的HTML文件进行遍历，依次打开文件并读取内容
        //   把内容转换为需要的结构化的数据（DocInfo对象）
        // 3.把DocInfo对象写入到最终的输出文件中（OUTPUT_PATH），写成行文本的形式

        FileWriter resultFileWriter = new FileWriter(new File(OUTPUT_PATH));

        ArrayList<File> fileList = new ArrayList<>();
        enumFile(INPUT_PATH, fileList);
        // System.out.println(fileList);
        // System.out.println(fileList.size());

        for (File f : fileList) {
            System.out.println("converting " + f.getAbsolutePath() + "...");
            // 最终输出的raw_data.txt 文件是一个行文本文件，每一行对应一个html文件
            // line这个对象就对应一个文件
            String line = convertLine(f);
            resultFileWriter.write(line);
        }
        resultFileWriter.close();
    }


    // 这里使用json或者xml来存储也是可以的
    private static String convertLine(File f) throws IOException {


        // 根据f转换出标题
        String title = convertTitle(f);

        // 根据f转换出url
        String url = convertUrl(f);

        // 根据f转换成正文（去掉html标签，去掉换行符）
        String content = convertContent(f);
        // 把这三个部分拼成一行文本
        // \3起到分割三个部分的效果，\3 ASCII值为3的字符
        // 在html这样的文本文件中是不会存在 \3 这种不可见字符的
        // 类似的，使用 \1 \2 \4 \5...来分割效果也是一样
        return title + "\3" + url + "\3" + content + "\n";
    }

    private static String convertTitle(File f) {
        // 将文件名作为标题（去掉.html后缀）
        String name = f.getName();
        return name.substring(0, name.length() - ".html".length());
    }
    private static String convertUrl(File f) {
        // URL线上文档对应的URL
        // 对于浏览器来说，/ 或者 \ 都能识别
        String part1 = "https://docs.oracle.com/javase/8/docs/api";
        String part2 = f.getAbsolutePath().substring(INPUT_PATH.length());
        return part1 + part2;
    }
    private static String convertContent(File f) throws IOException {
        // 去掉标签和\n
        // 二进制文件就用字节流，文本文件就用字符流
        // 一个一个字符地进行读取并判定
        FileReader fileReader = new FileReader(f);
        boolean isContent = true;
        StringBuilder output = new StringBuilder();
        while (true) {
            int ret = fileReader.read();
            if(ret == -1) {
                // 读取完毕了
                break;
            }
            char c = (char)ret;
            if (isContent) {
                // 当前这部分内容是正文
                if (c == '<'){
                    isContent = false;
                    continue;
                }
                // 去除换行
                // \n换行，另起一行，光标放到行首
                // \r回车，不另起新行，光标直接放到行首
                if (c == '\n' || c == '\r') {
                    c = ' ';
                }
                output.append(c);
            } else {
                // 当前这个部分是标签
                if (c == '>') {
                    isContent = true;
                }
            }
        }
        fileReader.close();
        return output.toString();
    }
    // 递归完毕后，当前inputPath中的所有html路径就全都被收集到fileList这个List中了
    private static void enumFile(String inputPath, ArrayList<File> fileList){

        File root = new File(inputPath);

        // listFiles 罗列出当前目录下的所有文件和目录， 相当于 Linux 上的ls命令
        File[] files = root.listFiles();
        // System.out.println(Arrays.toString(files));

        // 遍历当前这些目录和文件路径，分别处理
        for (File f : files){
            if (f.isDirectory()) {
                // 如果是目录，就递归调用
                enumFile(f.getAbsolutePath(), fileList);
            } else if(f.getAbsolutePath().endsWith(".html")){
                // 如果f不是目录，就看文件后缀是不是 .html
                // 如果是就加入到fileList这个List中
                fileList.add(f);
            }
        }
    }
}
