package com.lucas.SystemSpringBoot.extra;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations={"classpath:xml/application-bean.xml"})
public class ConfigClass {
    //配置无法扫描到的类
}
