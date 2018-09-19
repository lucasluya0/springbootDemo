package com.lucas.SystemSpringBoot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.lucas.SystemSpringBoot.mapper")
public class SystemSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemSpringBootApplication.class, args);
	}
}
