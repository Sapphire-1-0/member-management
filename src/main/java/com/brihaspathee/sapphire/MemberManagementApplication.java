package com.brihaspathee.sapphire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
// Open feign annotation to connect with other microservices
@EnableFeignClients
public class MemberManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MemberManagementApplication.class, args);
	}

}
