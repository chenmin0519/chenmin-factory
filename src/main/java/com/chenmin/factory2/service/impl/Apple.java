package com.chenmin.factory2.service.impl;

import com.chenmin.factory2.service.Fruit;
import org.springframework.stereotype.Service;

@Service
public class Apple implements Fruit {
    @Override
    public String sayHello() {
        return "我是苹果！";
    }
}
