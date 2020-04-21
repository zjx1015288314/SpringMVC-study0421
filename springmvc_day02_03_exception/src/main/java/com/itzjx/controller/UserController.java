package com.itzjx.controller;


import com.itzjx.exception.SystemException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(path = "/user")
public class UserController {
    @RequestMapping(path = "/testException")
    public String testException() throws SystemException {
        System.out.println("testException执行了....");

        try {
            //模拟service层异常
            int i=1/0;
        } catch (Exception e) {
            //打印异常信息
            e.printStackTrace();
            //抛出自定义异常信息
            throw new SystemException("查询所有用户出现错误...");
        }

        return "success";
    }
}
