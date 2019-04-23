package com.chenmin.factory3.service.impl;

import com.chenmin.factory3.anno.AnimalAnno;
import com.chenmin.factory3.service.Animal;
import org.springframework.stereotype.Service;

@Service
@AnimalAnno("monkey")
public class Monkey implements Animal {

    @Override
    public String sayHello() {
        return "你好!我是猴子。";
    }
}
