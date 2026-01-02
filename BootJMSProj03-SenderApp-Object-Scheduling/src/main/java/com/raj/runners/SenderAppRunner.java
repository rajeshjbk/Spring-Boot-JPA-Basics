package com.raj.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.raj.model.Actor;

@Component
public class SenderAppRunner {

	@Autowired
	private JmsTemplate template;
	
	@Scheduled(cron = "0 * * * * *")
	public void send() throws Exception {
		
		Actor actor = new Actor(1001, "Raj", "Hyd");
		template.convertAndSend("testmq2",actor);
		System.out.println("Object is sent as message.");
		
	}
}
