package com.example.commentsapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class CommentsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CommentsApiApplication.class, args);
	}
	@GetMapping("/")
	public String home(){
		return "Homepage of comments API";
	}
}
