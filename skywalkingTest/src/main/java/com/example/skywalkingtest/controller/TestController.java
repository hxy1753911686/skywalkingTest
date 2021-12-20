package com.example.skywalkingtest.controller;

import com.example.testdubbo.DubboTest;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



/**
 * @author hanxiangyu
 * @date 2021/12/14 10:26
 */
@Slf4j
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @DubboReference()
    private DubboTest dubboTest;

    @GetMapping("/logTest")
    public String logTest(){
        String traceId = TraceContext.traceId();
        log.info("[日志测试][入参] - 单纯想看下有没有trace-id : {}", traceId);
        String text = "这是日志出参哦";
        try{
            String test = dubboTest.test();
        }catch(Exception e){
            log.info("provider错误");
        }
        log.info("[日志测试][出参] - {}" , text);
        throw new RuntimeException("报错啦");
    }

}
