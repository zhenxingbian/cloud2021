package com.amarsoft.springcloud.service.impl;

import com.amarsoft.springcloud.dao.PaymentDao;
import com.amarsoft.springcloud.entities.Payment;
import com.amarsoft.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther zxbian
 * @create 09点59分
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentDao paymentDao;

    public int create(Payment payment){
        return paymentDao.create(payment);
    };

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    };
}
