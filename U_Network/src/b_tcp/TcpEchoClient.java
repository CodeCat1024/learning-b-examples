package b_tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class TcpEchoClient {
    private Socket socket = null;

    public TcpEchoClient(String serverIP, int serverPort) throws IOException {
        // 这里写的是服务器的 IP，客户端是不需要绑定自己的IP和端口的
        socket = new Socket(serverIP, serverPort);
    }

    public void start() {
        System.out.println("和服务器连接成功！");
        Scanner scanner = new Scanner(System.in);
        try (InputStream inputStream = socket.getInputStream()) {
            try (OutputStream outputStream = socket.getOutputStream()) {
                while (true) {
                    // 1.从控制台读取字符串
                    System.out.println("请输入请求内容：->");
                    String request = scanner.next();
                    // 2.根据读取的字符串，构造请求，把请求发给服务器
                    PrintWriter printWriter = new PrintWriter(outputStream);
                    printWriter.println(request);
                    printWriter.flush(); // 如果不刷新，可能服务器无法及时看到数据
                    // 3.从服务器读取响应并解析
                    Scanner respScanner = new Scanner(inputStream);
                    String response =  respScanner.next();
                    // 4.把结果显示到控制台上
                    System.out.printf("req: %s, resp: %s\n", request, response);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws IOException {
        TcpEchoClient client = new TcpEchoClient("127.0.0.1", 9090);
        client.start();
    }
}
