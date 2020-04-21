package com.itzjx.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1 implements HandlerInterceptor {
    /**
     * controller方法预处理器
     * @param request
     * @param response
     * @param handler
     * @return  true，执行下一个拦截器，如没有则执行controller中的方法；false，通过request和response跳转到提示页面
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1执行了.........前111");
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
        return true;
    }

    /**
     * controller方法后置处理器：controller方法执行之后，success.jsp执行之前
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1执行了.........后111");
//        //该方法会在success.jsp执行前被拦截并跳转到error.jsp,并执行error中的sout输出，
//        // 最后success.jsp中的sout输出也会执行，但页面不会跳转
//        request.getRequestDispatcher("/WEB-INF/pages/error.jsp").forward(request,response);
//        //注意该方法中getRequestDispatcher().forward语句后面的执行语句并不会执行
    }

    /**
     * success.jsp执行之后该方法执行,这里无法跳转页面，通常是进行资源的释放
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor1执行了.........最终111");
    }
}
