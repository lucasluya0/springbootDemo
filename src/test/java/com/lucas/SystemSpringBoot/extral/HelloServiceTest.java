package com.lucas.SystemSpringBoot.extral;

import com.lucas.SystemSpringBoot.SystemSpringBootApplication;
import com.lucas.SystemSpringBoot.extra.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SystemSpringBootApplication.class)
public class HelloServiceTest {
    private static final Logger logger = LoggerFactory.getLogger(com.lucas.SystemSpringBoot.controller.Test.class);
    @Autowired
    HelloService helloService;
    @Test
    public void getHello(){
        String str=helloService.getHello();
        logger.info("this is extral class test is : "+ str);
    }
}
