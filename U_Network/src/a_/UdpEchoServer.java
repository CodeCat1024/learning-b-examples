package a_;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpEchoServer {
    private DatagramSocket socket = null;

    // 需要处理 socket 构造失败的异常
    public UdpEchoServer(int port) throws SocketException {
        socket = new DatagramSocket(port);
    }

    // 启动服务器
    public void start() throws IOException {
        System.out.println("启动服务器！");
        // UDP 不需要建立连接，直接接收从客户端来的数据即可
        while (true) {
            // 1.读取客户端发来的请求（会阻塞，一直等待客户端发送请求）
            // 为了接收数据，需要先准备好一个空的 DatagramPacket对象，让 receive() 方法进行填充
            DatagramPacket requestPacket = new DatagramPacket(new byte[1024], 1024);
            socket.receive(requestPacket); // 输出型参数
            // 把 DatagramPacket 解析成一个 String
            String request = new String(requestPacket.getData(), 0, requestPacket.getLength(), "UTF-8");

            // 2.根据请求计算响应（因为是回显服务器， 所以直接省略）
            String response = process(request);

            // 3.把响应写回客户端
            // 根据响应字符串构造出一个 DatagramPacket （并且要指定 IP 和端口）
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length,
                    requestPacket.getSocketAddress());
            socket.send(responsePacket);
            System.out.printf("[%s:%d] req: %s, resp: %s\n",
                    requestPacket.getAddress().toString(), requestPacket.getPort(), request, response);
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server = new UdpEchoServer(9090);
        server.start();
    }
}
