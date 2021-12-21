package com.example.skywalkingtest.advice;

import com.example.skywalkingtest.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hanxiangyu
 * @date 2021/12/21 18:12
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = RuntimeException.class)
    public Result defaultErrorHandler(HttpServletRequest request, Exception ex) {
        String traceId = TraceContext.traceId();
        return new Result(400, "失败", ex.getMessage(), traceId);
    }
}
