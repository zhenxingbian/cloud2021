package com.amarsoft.springcloud.service;

import com.amarsoft.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
/**
 * @auther zxbian
 * @create 09点59分
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
