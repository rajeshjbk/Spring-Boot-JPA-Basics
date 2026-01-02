package com.raj.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.raj.model.Actor;

@Component
public class ReceiverApp {

	@JmsListener(destination = "testmq2")
	public void readMessage(Actor actor) {
		
		System.out.println("Received Object Message is :: "+actor);
	}
}
