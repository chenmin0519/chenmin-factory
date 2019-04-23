package com.chenmin.factory2.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})  //设置注解添加权限
@Retention(RetentionPolicy.RUNTIME)  //设置注解生命周期
public @interface FruitAnno {
    public String  value() default ""; //给注解初始值
}
