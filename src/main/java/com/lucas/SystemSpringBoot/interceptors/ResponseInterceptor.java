package com.lucas.SystemSpringBoot.interceptors;

import com.lucas.base.constants.ResponseCode;
import com.lucas.base.constants.ReturnType;
import com.lucas.base.utils.BaseUtil;
import com.lucas.base.utils.ResponseMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ResponseInterceptor implements ResponseBodyAdvice {

    private Logger logger= LoggerFactory.getLogger(ResponseInterceptor.class);
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        System.out.println("zhang");
//        if(mediaType != null && o != null){
//            if(mediaType.includes(MediaType.APPLICATION_JSON )){
//                return BaseUtil.isResponseMsg(o);
//            }else if(mediaType.includes(MediaType.TEXT_PLAIN)){
//                serverHttpRequest.getHeaders().setContentType(MediaType.APPLICATION_JSON);
//                ResponseMsg rm=new ResponseMsg();
//                rm.setCode(ResponseCode.SUCCESS_CODE);
//                rm.setHintInformation("返回视图");
//                rm.setReturnType(ReturnType.VIEWS);
//                rm.addData("url","index");
//                return rm;
//            }
//        }
        return o;
    }
}
