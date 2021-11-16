package com.amarsoft.springcloud.controller;

import com.amarsoft.springcloud.entities.CommonResult;
import com.amarsoft.springcloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zxbian
 * @version 1.0
 * @date 2021/11/15 15:38
 */
@RestController
public class OrderFeignController {
    @Resource
    PaymentFeignService paymentFeignService;
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
            return paymentFeignService.getPaymentById(id);
    }
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        //测试feign超时
        return paymentFeignService.paymentFeignTimeOut();
    }
}
