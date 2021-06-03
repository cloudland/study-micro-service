package org.cloudland.study.sentienl.server.control;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.cloudland.study.sentienl.server.control.exp.CustomSentienlException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StudySentienlControl {

    @GetMapping(value = "/hello")
    @SentinelResource(value = "hello", blockHandler = "dealException")
    public String hello() {
        log.info("进来咯");
        return "hello sentinel";
    }
    public String dealException(BlockException e) {
        // 使用 @SentinelResource 自定热点规则错误
        return "这里是自定返回错误信息";
    }

    @GetMapping(value = "/fallback")
    @SentinelResource(value = "fallback", fallback = "fallback")
    public String fallback() {
        log.info("进来咯");
        return "hello sentinel";
    }
    public String handlerFallback(Throwable e) {
        // 使用 @SentinelResource 自定热点规则错误
        return "这里是自定兜底异常";
    }

    /**
     * 全局Seata异常处理
     *
     * @return
     */
    @GetMapping(value = "/globa")
    @SentinelResource(value = "globa", blockHandlerClass = CustomSentienlException.class, blockHandler = "handler")
    public String globa() {
        log.info("进来咯");
        return "hello sentinel";
    }

}
