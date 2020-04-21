package com.itzjx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 常用注解
 */
@Controller
@RequestMapping(path = "/anno")
public class AnnoController {
    /**
     * RequestParam注解:name指定传过来的参数名称，required默认为true表示必须要有
     * @param username
     * @return
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "name") String username){
        System.out.println("执行了");
        System.out.println(username);
        return "success";
    }

    /**
     * RequestBody注解:required默认为true表示必须要有.此注解不适用于GET方法
     * @param body
     * @return
     */
    @RequestMapping(value = "/testRequestBody",method = RequestMethod.POST)
    public String testRequestBody(@RequestBody String body){
        System.out.println("执行了");
        System.out.println(body);
        return "success";
    }

    /**
     * PathVariable注解:required默认为true表示必须要有.
     * @param id
     * @return
     */
    @RequestMapping(value = "/testPathVariable/{sid}",method = RequestMethod.POST)
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("执行了");
        System.out.println(id);
        return "success";
    }

}
