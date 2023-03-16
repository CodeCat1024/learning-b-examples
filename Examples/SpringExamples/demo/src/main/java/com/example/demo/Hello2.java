package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello2 {
    private static Logger logger = LoggerFactory.getLogger(Hello2.class);

    @ResponseBody
    @RequestMapping("/sayHi2")
    public void sayHi() {
        logger.trace("I am trace in Hello2");
        logger.debug("I am debug in Hello2");
        logger.info("I am info in Hello2");
        logger.warn("I am warn in Hello2");
        logger.error("I am error in Hello2");
    }
}