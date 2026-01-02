package com.raj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootJmsProj03SenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJmsProj03SenderApplication.class, args);
	}

}
