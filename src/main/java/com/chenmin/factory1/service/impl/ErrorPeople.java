package com.chenmin.factory1.service.impl;

import com.chenmin.factory1.service.People;
import org.springframework.stereotype.Service;

@Service("errorPeople")
public class ErrorPeople implements People {
    @Override
    public String sayHello() {
        return "对不起没有这个人";
    }
}
