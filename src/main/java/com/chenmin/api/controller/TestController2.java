package com.chenmin.api.controller;

import com.chenmin.factory2.FruitFactory;
import com.chenmin.factory2.anno.FruitAnno;
import com.chenmin.factory2.service.Fruit;
import com.chenmin.factory3.AnimalFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test2")
@Api(value = "TestController2", description = "测试的例子2")
public class TestController2 {

    @FruitAnno("apple")
    private Fruit fruit;

    @ApiOperation("测试工厂模式2：自定义注解实现")
    @RequestMapping(value = "/{className}/getFruitInfo",method = RequestMethod.GET)
    public String factory2Test( @ApiParam("需要的类名例如：apple,paer") @PathVariable String className) throws Exception {
        FruitFactory<TestController2> factory = new FruitFactory<>();
        return factory.sb(TestController2.class).fruit.sayHello();
    }

    @Autowired
    AnimalFactory animalFactory;
    @ApiOperation("测试工厂模式3：自定义注解实现")
    @RequestMapping(value = "/{className}/getAnimalInfo",method = RequestMethod.GET)
    public String factory3Test( @ApiParam("需要的类名例如：snake,monkey") @PathVariable String className) throws Exception {
        return AnimalFactory.getAnimalByType(className).sayHello();
    }
}
