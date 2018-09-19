package com.lucas.SystemSpringBoot.interceptors;


import com.lucas.base.constants.ReturnType;
import com.lucas.base.utils.ResponseMsg;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class TestAop {
    private static final Logger logger=LoggerFactory.getLogger(TestAop.class);
    /*
     * 定义一个切入点
     */
    @Pointcut("execution(* com.lucas.SystemSpringBoot.services..*(..))")
    public void myServices() {}

    @Before("myServices()")
    public void doBefore(JoinPoint joinPoint) {}

    @Around("myServices()")
    public Object aroundMyService(ProceedingJoinPoint jp){
        long startTime=System.currentTimeMillis();
        Object rvt =null;
        String methodName=jp.getSignature().getName();
        try{
            rvt = jp.proceed();
        }catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            long endTime=System.currentTimeMillis();
            DecimalFormat df = new DecimalFormat("0.0000");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            logger.info("{} 执行{}(),消耗{}分钟",sdf.format(new Date()),jp.getSignature().getDeclaringTypeName(),df.format((endTime-startTime)/60000.0));
        }
        return rvt;
    }
}
