package com.chenmin.factory3.service.impl;

import com.chenmin.factory3.anno.AnimalAnno;
import com.chenmin.factory3.service.Animal;
import org.springframework.stereotype.Service;

@Service
@AnimalAnno("errorAnimal")
public class ErrorAnimal implements Animal {
    @Override
    public String sayHello() {
        return "没有这个动物";
    }
}
