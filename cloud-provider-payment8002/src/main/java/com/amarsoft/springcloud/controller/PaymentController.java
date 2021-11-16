package com.amarsoft.springcloud.controller;

import com.amarsoft.springcloud.entities.CommonResult;
import com.amarsoft.springcloud.entities.Payment;
import com.amarsoft.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @auther zxbian
 * @create 09点59分
 */
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;
    @Resource
    private PaymentService paymentService;
    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
           int result = paymentService.create(payment);
           log.info("****插入结果是***"+result);
           if(result > 0){
               return new CommonResult(200,"插入成功了,服务端口："+serverPort,result);
           }else{
               return new CommonResult(444,"插入失败了,服务端口："+serverPort,null);
           }

    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("****查询结果是***"+payment);
        if(payment != null){
            return new CommonResult(200,"查询成功了,服务端口："+serverPort,payment);
        }else{
            return new CommonResult(444,"查询无记录,服务端口："+serverPort+"查询ID为："+id,null);
        }

    }
}
