package com.lucas.SystemSpringBoot.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;


/**
 * @Package org.jon.lv.interceptors.AppInterceptors
 * @Description: AppInterceptors
 * Author lv bin
 * @date 2017/5/16 13:12
 * version V1.0.0
 */
@Configuration
public class ResourceInterceptors extends WebMvcConfigurationSupport {
    @Autowired
    ControllerInterceptor controllerInterceptor;
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        System.out.println("Web mvcConfig");
        registry.addInterceptor(controllerInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

        super.configureMessageConverters(converters);
        converters.add(responseBodyConverter());
    }

    @Bean
    public HttpMessageConverter responseBodyConverter() {
        StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return converter;
    }
}
