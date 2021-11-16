package com.amarsoft.springcloud.service.Impl;

import com.amarsoft.springcloud.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author zxbian
 * @version 1.0
 * @date 2021/11/16 9:28
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "服务调用失败！paymentInfo_OK，来自OrderHystrixMain80客户端";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "服务调用失败！paymentInfo_TimeOut，来自OrderHystrixMain80客户端";
    }
}
