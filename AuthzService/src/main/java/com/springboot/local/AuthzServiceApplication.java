package com.springboot.local;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AuthzServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthzServiceApplication.class, args);
	}
}
/*
Dos command to kill springboot app.
C:\>netstat -ano|find "8889"
C:\Users\amraj7>taskkill /F /PID 30416


*/