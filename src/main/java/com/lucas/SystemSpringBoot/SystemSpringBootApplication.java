package com.lucas.SystemSpringBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.Filter;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "com.lucas.SystemSpringBoot")
@MapperScan("com.lucas.SystemSpringBoot.mapper")
public class SystemSpringBootApplication {

//	// 用于处理编码问题
//	@Bean
//	public Filter characterEncodingFilter() {
//		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
//		characterEncodingFilter.setEncoding("UTF-8");
//		characterEncodingFilter.setForceEncoding(true);
//		return characterEncodingFilter;
//	}
	public static void main(String[] args) {
		SpringApplication.run(SystemSpringBootApplication.class, args);
	}
}
