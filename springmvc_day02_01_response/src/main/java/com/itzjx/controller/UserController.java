package com.itzjx.controller;

import com.itzjx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    /**
     * 返回值String类型的Controller方法，默认是请求转发
     * @param model
     * @return
     */
    @RequestMapping(path = "/testString")
    public String testString(Model model){
        System.out.println("testString执行了");
        //模拟从数据库查询出User对象
        User user = new User();
        user.setUsername("赵杰雄");
        user.setPassword("123");
        user.setAge(26);
        //model对象存储User对象到Request域
        model.addAttribute("iuser",user);
        return "success";
    }

    /**
     * 返回值类型是void，默认会去找/springmvc_day02_01_response_war/WEB-INF/pages/user/testVoid.jsp
     * 如果不想在pages下创建该jsp文件时,可以转发请求
     * 请求转发是一次请求，请求路径不用编写项目名称,但不能使用视图解析器，需要加/WEB-INF/pages/
     * 而重定向是两次请求，请求路径需要写项目名称
     *
     * @param
     */
    @RequestMapping(path = "/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("testVoid执行了");
        //请求转发
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);

        //重定向
        System.out.println("contextPath: " + request.getContextPath()); //springmvc_day02_01_response_war
        System.out.println("servletPath: " + request.getServletPath()); //user/testVoid
//        response.sendRedirect(request.getContextPath() + "/index.jsp");

        //直接进行响应并解决中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;character=UTG-8");
        response.getWriter().print("你好");

        return;
    }

    /**
     * 返回ModelAndView
     * @return
     */
    @RequestMapping(path = "/testModelAndView")
    public ModelAndView testModelAndView(){
        //创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        System.out.println("testModelAndView执行了");
        //模拟从数据库查询出User对象
        User user = new User();
        user.setUsername("哈哈");
        user.setPassword("456");
        user.setAge(26);

        //把user对象存储到mv对象，也会把user对象存入到request对象
        mv.addObject("user",user);
        //跳转到哪个页面,利用视图解析器
        mv.setViewName("success");
        return mv;
    }

    /**
     * 使用关键字的方法进行转发或重定向
     * @param
     * @return
     */
    @RequestMapping(path = "/testForwardOrRedirect")
    public String testForwardOrRedirect(){
        System.out.println("testForwardOrRedirect执行了");

        //请求转发
//        return "forward:/WEB-INF/pages/success.jsp";
        //重定向, 不用像response.sendRedirect(request.getContextPath() + "/index.jsp")一样加上contextPath
        return "redirect:/index.jsp";
    }

    /**
     * 模拟异步请求
     * 在导入了jar包后，@RequestBody可以将客户端传来的json数据封装为User对象
     *                 @ResponseBody可以将User对象封装为json数据
     * @return
     */
    @RequestMapping(path = "/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax执行了");
        //客户端发送ajax请求，使用的json数据，后端已经把json字符串封装到user对象中
        System.out.println(user);
        //模拟查询数据库
        user.setUsername("haha");
        user.setAge(26);
        //响应给客户端
        return user;
    }
}
