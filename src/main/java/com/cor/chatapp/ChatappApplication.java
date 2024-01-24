package com.cor.chatapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@EnableAutoConfiguration
@SpringBootApplication()
public class ChatappApplication {
	public static void main(String[] args) {
		SpringApplication.run(ChatappApplication.class, args);
	}

}
