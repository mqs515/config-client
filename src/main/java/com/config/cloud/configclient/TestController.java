package com.config.cloud.configclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author ：miaoqs
 * @date ：2019-07-09 17:22
 * @description：测试读取配置中心的内容
 */

@RefreshScope
@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

    @Value("${from}")
    private String from;

    @Autowired
    private Environment environment;


    /**
     * 通过@value方法获取配置文件中的内容
     * @return
     */
    @GetMapping("/from")
    public String from(){
//        log.info("===================from: {}", this.from()); TODO 这里打印日志回出现空指针问题
        return this.from;
    }

    /**
     * 通过配置获取
     * @return
     */
    @GetMapping("/from/env")
    public String fromEnv(){
        log.info("===================from-env: {}", environment.getProperty("from", "undefined"));
        return environment.getProperty("from", "undefined");
    }

}
