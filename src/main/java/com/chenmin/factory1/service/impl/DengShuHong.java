package com.chenmin.factory1.service.impl;

import com.chenmin.factory1.service.People;
import org.springframework.stereotype.Service;

@Service("dengShuHong")
public class DengShuHong implements People {
    @Override
    public String sayHello() {
        return "你好！我是dengshuhong。";
    }
}
