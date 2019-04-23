package com.chenmin.factory1.service.impl;

import com.chenmin.factory1.service.People;
import org.springframework.stereotype.Service;

@Service("chenMin")
public class Chenmin implements People {
    @Override
    public String sayHello() {
        return "你好！我是chenmin。";
    }
}
