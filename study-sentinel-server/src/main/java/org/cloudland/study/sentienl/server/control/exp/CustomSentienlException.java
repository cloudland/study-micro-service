package org.cloudland.study.sentienl.server.control.exp;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomSentienlException {

    public static String handler(BlockException e) {
        return "统一流控异常处理";
    }

}
