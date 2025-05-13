package com.brihaspathee.sapphire;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.env.Environment;

@SpringBootApplication
// Open feign annotation to connect with other microservices
@EnableFeignClients
public class MemberManagementApplication {

	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(MemberManagementApplication.class, args);
	}

//	@PostConstruct
//	public void logConfig() {
//		System.out.println("Active profile: " + environment.getActiveProfiles()[0]);
//		System.out.println("Application properties loaded from: " + environment.getProperty("spring.config.location"));
//	}

}
