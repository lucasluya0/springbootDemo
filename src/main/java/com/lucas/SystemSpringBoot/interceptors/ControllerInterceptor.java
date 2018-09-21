package com.lucas.SystemSpringBoot.interceptors;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ControllerInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
            throws Exception {
        // TODO Auto-generated method stub
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /*String uriStr=request.getRequestURI();
        StringBuffer urlStr=request.getRequestURL();
        String userDir = System.getProperty("user.dir");
        String [] userDirArray = userDir.split("\\\\");
        String projectName=userDirArray[userDirArray.length-1];
        if(uriStr.matches(projectName)){
            return true;
        }else{
            uriStr="/"+projectName+uriStr;
        }*/
        return true;
    }

}
