package com.amarsoft.springcloud.controller;

import com.amarsoft.springcloud.entities.CommonResult;
import com.amarsoft.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author zxbian
 * @version 1.0
 * @date 2021/11/12 14:06
 */
@RestController
@Slf4j
public class OrderController {

    public static final String PaymentSrv_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create") //客户端用浏览器是get请求，但是底层实质发送post调用服务端8001
    public CommonResult<Payment> create(Payment payment){
        return restTemplate.postForObject(PaymentSrv_URL + "/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPayment(@PathVariable Long id)
    {
        return restTemplate.getForObject(PaymentSrv_URL + "/payment/get/"+id, CommonResult.class, id);
    }
    @GetMapping("/consumer/getForEntity/get/{id}")
    public CommonResult getPaymentEntity(@PathVariable Long id)
    {
        ResponseEntity<CommonResult> result = restTemplate.getForEntity(PaymentSrv_URL + "/payment/get/"+id,CommonResult.class);
        if(result.getStatusCode().is2xxSuccessful()){
            log.info(result.getHeaders().toString());
            return result.getBody();
        }else {
            return new CommonResult<>(444,"操作失败！");
        }
    }
}
