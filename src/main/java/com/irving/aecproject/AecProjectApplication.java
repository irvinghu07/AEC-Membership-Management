package com.irving.aecproject;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.irving.aecproject.web.dao")
@SpringBootApplication
public class AecProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AecProjectApplication.class, args);
	}
}
