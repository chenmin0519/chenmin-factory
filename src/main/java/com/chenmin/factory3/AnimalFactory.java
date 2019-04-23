package com.chenmin.factory3;

import com.chenmin.factory1.utils.ApplicationContextUtils;
import com.chenmin.factory3.anno.AnimalAnno;
import com.chenmin.factory3.service.Animal;
import com.chenmin.factory3.service.impl.ErrorAnimal;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class AnimalFactory {

    @Autowired
    private ApplicationContext context;

    private static Map<String,Animal> animalMap = new HashMap<>();

    /**
     * 加载加注解的animal实现类
     */
    @PostConstruct
    public void lodeAnnotationAnimal(){
        String[] classNames = context.getBeanDefinitionNames();
        for(String className : classNames){
            Class<?> clazz = AopUtils.getTargetClass(context.getBean(className));
            AnimalAnno animalAnno = clazz.getAnnotation(AnimalAnno.class);
            if(animalAnno != null && context.getBean(className) instanceof Animal){
                animalMap.put(className,(Animal) context.getBean(className));
            }
        }
    }

    public static Animal getAnimalByType(String type){
        if(animalMap == null || type.isEmpty() || !animalMap.containsKey(type) || animalMap.get(type) == null){
            return new ErrorAnimal();
        }
        return animalMap.get(type);
    }
}
