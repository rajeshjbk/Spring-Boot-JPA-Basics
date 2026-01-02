package com.raj.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ReceiverApp {

	@JmsListener(destination = "testmq1")
	public void readMessage(String message) {
		
		System.out.println("Received Message is :: "+message);
	}
}
