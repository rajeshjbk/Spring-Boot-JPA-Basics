package com.raj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class BootKafkaProj01PublisherApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootKafkaProj01PublisherApp1Application.class, args);
	}

}
