package com.example.start.serviceImpl;

import com.alibaba.fastjson.JSON;
import com.example.start.test.dataobject.TestMasterDO;
import com.example.start.test.service.TestMasterService;
import com.example.testdubbo.DubboTest;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.apache.skywalking.apm.toolkit.trace.TraceContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author hanxiangyu
 * @date 2021/12/14 13:59
 */
@Slf4j
@Service
@DubboService
public class DubboTestImpl implements DubboTest {

    @Resource
    private TestMasterService testMasterService;

    @Override
    public String test() {
//        RpcServiceContext serviceContext = RpcContext.getServiceContext();
//        CancellationContext cancellationContext = RpcContext.getCancellationContext();
//        RpcContextAttachment serverContext = RpcContext.getServerContext();
//        RpcContextAttachment clientAttachment = RpcContext.getClientAttachment();
//        RpcContextAttachment serverAttachment = RpcContext.getServerAttachment();
//        Map<String, String> attachments = RpcContext.getContext().getAttachments();
        String traceId = TraceContext.traceId();
        log.info("[测试1][dubbo测试] -- 入参, {}", traceId);
        TestMasterDO testMaster = testMasterService.getById(1L);
        String s = JSON.toJSONString(testMaster);
        log.info("[测试1][dubbo测试] -- 出参, {}", s);
        return s;
    }
}
