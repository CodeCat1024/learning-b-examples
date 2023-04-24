package b_tcp.c_dict;

import b_tcp.b_concurrent.TcpThreadPoolEchoServer;

import java.io.IOException;
import java.util.HashMap;

public class TcpDictServer extends TcpThreadPoolEchoServer {

    private HashMap<String, String> dict = new HashMap<>();

    public TcpDictServer(int port) throws IOException {
        super(port);
        dict.put("cat", "猫");
        dict.put("dog", "狗");
        dict.put("bird", "鸟");
        dict.put("duck", "鸭");
    }

    @Override
    protected String process(String request) {
        return dict.getOrDefault(request, "当前的词无法翻译！");
    }

    public static void main(String[] args) throws IOException {
        TcpDictServer server = new TcpDictServer(9090);
        server.start();
    }
}
