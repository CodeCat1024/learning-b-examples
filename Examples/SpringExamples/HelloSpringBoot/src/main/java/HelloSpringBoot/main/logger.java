package HelloSpringBoot.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class logger {
    //获取日志对象（来自slf4j）
    private final static Logger log =
            LoggerFactory.getLogger(logger.class);

    @RequestMapping("/logger")
    public void sayHi() {
        // 打印日志信息
        log.trace("我是 trace");
        log.debug("我是 debug");
        log.info("我是 info");
        log.warn("我是 warn");
        log.error("我是 error");
    }
}
