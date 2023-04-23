package a_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UdpEchoClient {
    private DatagramSocket socket = null;
    private String serverIP;
    private int serverPort;

    // 不需要指定端口号，只需要系统自己分配一个空闲的端口号即可
    public UdpEchoClient(String serverIP, int serverPort) throws SocketException {
        this.socket = new DatagramSocket();
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    public void start() throws IOException {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // 1.先从控制台读取用户输入的字符串
            System.out.println("-> ");
            String request = scanner.next();
            // 2.把这个用户输入的内容，构造成一个UDP请求，并发送
            //   2.1 数据的内容，request字符串
            //   2.2 数据要发送给谁 -- 服务器的IP + 端口号
            DatagramPacket requestPacket = new DatagramPacket(request.getBytes(), request.getBytes().length,
                    InetAddress.getByName(serverIP), serverPort);
            socket.send(requestPacket);

            // 3.从服务器读取响应数据，并解析
            DatagramPacket responsePacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(responsePacket);
            String response = new String(responsePacket.getData(), 0, responsePacket.getLength(), "UTF-8");

            System.out.println(response);

            // 4.把响应结果显示到控制台上
            System.out.printf("req: %s, resp: %s\n", request, response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient client = new UdpEchoClient("127.0.0.1", 9090);
        client.start();

    }
}
