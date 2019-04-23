package com.chenmin.factory3.service.impl;

import com.chenmin.factory3.anno.AnimalAnno;
import com.chenmin.factory3.service.Animal;
import org.springframework.stereotype.Service;

@Service
@AnimalAnno("snake")
public class Snake implements Animal {

    @Override
    public String sayHello() {
        return "你好我是蛇";
    }

}
