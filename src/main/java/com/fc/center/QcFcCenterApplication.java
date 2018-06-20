package com.fc.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})  
public class QcFcCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(QcFcCenterApplication.class, args);
	}
}
