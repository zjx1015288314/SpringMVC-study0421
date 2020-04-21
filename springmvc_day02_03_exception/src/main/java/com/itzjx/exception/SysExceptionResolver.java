package com.itzjx.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SysExceptionResolver implements HandlerExceptionResolver {
    /**
     * 处理异常逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e 要处理的异常
     * @return
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取异常对象
        SystemException systemException = null;
        if (e instanceof SystemException){
            systemException = (SystemException) e;
        }else{
            e = new SystemException("系统正在维护...");
        }
        //创建ModelAndView对象
        ModelAndView mav = new ModelAndView();
        mav.addObject("errorMsg",systemException.getMsg());
        mav.setViewName("error");
        return mav;
    }
}
