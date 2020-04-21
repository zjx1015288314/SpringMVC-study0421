package com.itzjx.controller;

import com.itzjx.domain.Account;
import com.itzjx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/param")
public class ParamController {
    /**
     * 请求参数示例方法
     * @param
     */
    @RequestMapping("/testParam")
    public String testParam(String username,String password){
        System.out.println("testParam方法执行" + username );
        System.out.println("用户: " + username);
        System.out.println("密码: " + password);
        return "success";
    }
    /**
     * 请求参数绑定到JavaBean中
     * @return
     */
    @RequestMapping("/saveAccount")
    public String saveAccount(Account account){
        System.out.println(account.toString());
        return "success";
    }
    /**
     * 自定义类型转换器
     * @param user
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println(user);
        return "success";
    }

    /**
     * 原生的ServletAPI
     */
    @RequestMapping("/testServlet")
    public String testServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了");
        System.out.println(request);

        HttpSession session = request.getSession();
        System.out.println(session);

        ServletContext context = session.getServletContext();
        System.out.println(context);

        System.out.println(response);
        return "success";
    }
}
