package a_udp.b_dict;

import a_udp.a_echo.UdpEchoServer;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

public class UdpDictServer extends UdpEchoServer {

    private HashMap<String, String> dict = new HashMap<>();

    public UdpDictServer(int port) throws SocketException {
        super(port);
        dict.put("cat", "小猫");
        dict.put("dog", "小狗");
        dict.put("hello", "你好");
        dict.put("world", "世界");
    }

    @Override
    public String process(String request) {
        return dict.getOrDefault(request, "该次无法被查询！");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer udpDictServer = new UdpDictServer(9090);
        udpDictServer.start();
    }
}
