package com.chenmin.factory2;

import com.chenmin.factory1.utils.ApplicationContextUtils;
import com.chenmin.factory2.anno.FruitAnno;
import com.chenmin.factory2.service.Fruit;

import java.lang.reflect.Field;

public  class FruitFactory<T> {

    public T sb(Class<T> clazz) throws Exception{
        T t = clazz.newInstance();
        Field[] feild=clazz.getDeclaredFields(); //获取需注入属性描述类对象
        for(int i =0 ; i < feild.length ; i ++){
            if(feild[i].isAnnotationPresent(FruitAnno.class)){ //判断是否加有注解
                FruitAnno fruitanno=feild[i].getAnnotation(FruitAnno.class); //获取注解对象
                String name=fruitanno.value(); //获取注解值（注解内容）
//                Class clazzClass=Class.forName(name);  //通过注解内容反射一个对象描述类
//                Fruit fruit=(Fruit) clazzClass.newInstance(); //通过反射得到一个实例
                Fruit fruit=(Fruit) ApplicationContextUtils.getBean(name); //通过上下文得到一个实例
                feild[i].setAccessible(true); //给私有的成员属性设置权限
                feild[i].set(t, fruit); //将值注入指定对象（作用仅限于此obj对象所有）*********
            }
        }
        return t;
    }
}
