package com.chenmin.api.controller;

import com.chenmin.factory1.PeopleFactory;
import com.chenmin.factory1.service.People;
import com.chenmin.factory2.service.Fruit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
@Api(value = "TestController", description = "测试的例子")
public class TestController {

    @Autowired
    private PeopleFactory peopleFactory;

    @ApiOperation("测试工厂模式1")
    @RequestMapping(value = "/{className}/getPeopleInfo",method = RequestMethod.GET)
    public String factory1Test( @ApiParam("需要的类名例如：chenMin,dengShuHong")@PathVariable String className){
        People people = peopleFactory.getBean(className);
        return people.sayHello();
    }


    @Resource(name = "apple")
    private Fruit fruit;

    @ApiOperation("测试工厂模式2：注解实现注入")
    @RequestMapping(value = "/{className}/getFruitInfo",method = RequestMethod.GET)
    public String factory2Test(){
        return fruit.sayHello();
    }
}
