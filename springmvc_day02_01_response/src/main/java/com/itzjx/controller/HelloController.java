package com.itzjx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制器
 */
@Controller
@RequestMapping(path = "/user")
public class HelloController {
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello StringMVC");
        return "success";
    }

    /**
     *
     * @return
     */
    //method限制了该方法可以相应的请求方式；params限制了请求URL中的参数必须与配置中的key=value一模一样;headers限制请求头的信息
    @RequestMapping(path = "/testRequestMapping",method = {RequestMethod.POST},
            params = {"username=zjx"},headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("测试RequestMapping注解...");
        return "success";
    }
}
