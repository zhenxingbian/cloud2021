package com.amarsoft.springcloud.controller;

import com.amarsoft.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zxbian
 * @version 1.0
 * @date 2021/11/22 16:56
 */
@RestController
public class SendMessageController {
    @Resource
    private IMessageProvider iMessageProvider;
    @GetMapping(value = "/sendMessage")
    public String send(){
        return iMessageProvider.send();
    }
}
