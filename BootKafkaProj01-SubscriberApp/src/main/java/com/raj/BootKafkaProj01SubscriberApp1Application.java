package com.raj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BootKafkaProj01SubscriberApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootKafkaProj01SubscriberApp1Application.class, args);
	}

}
