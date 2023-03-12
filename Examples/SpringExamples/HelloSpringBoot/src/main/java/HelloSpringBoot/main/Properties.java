package HelloSpringBoot.main;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody // 返回一个非静态页面的数据
@RequestMapping("/user") // 类上面的RequestMapping可以省略
public class Properties {

    @Value("${server.port}")
    private String port;

    @Value("${my.properties}")
    private String properties;

    @RequestMapping("/sayhi") // 设置路由地址，全部使用小写
    public String sayHi() {
        return "Hello World + server.port = " + port + " my.properties" + properties;
    }
}
