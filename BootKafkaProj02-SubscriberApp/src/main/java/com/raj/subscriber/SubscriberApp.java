package com.raj.subscriber;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.raj.model.Employee;

@Component
public class SubscriberApp {

   @KafkaListener(topics="${app.tpc.name}",groupId="grp1 ")	
   public void readMessage(Employee emp) {
	   
	   System.out.println(emp);
   }
} 
