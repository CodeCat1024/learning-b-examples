package HelloSpringBoot.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@Slf4j
public class Logger_lombok {

    @RequestMapping("/logger_lombok")
    public void logger_lombok() {
        // 打印日志信息
        log.trace("我是 logger_lombok trace");
        log.debug("我是 logger_lombok debug");
        log.info("我是 logger_lombok info");
        log.warn("我是 logger_lombok warn");
        log.error("我是 logger_lombok error");
    }
}
