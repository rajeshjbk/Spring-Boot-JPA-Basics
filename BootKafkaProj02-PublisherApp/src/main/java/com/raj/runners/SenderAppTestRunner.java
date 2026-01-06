package com.raj.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.raj.model.Employee;

@Component
public class SenderAppTestRunner implements CommandLineRunner {

	@Autowired
	private KafkaTemplate<String,Employee> template;

	@Value("${app.tpc.name}")
	private String topicName;

	@Override
	public void run(String... args) throws Exception {

      Employee emp = new Employee();
      emp.setEno(1001);
      emp.setEname("Raj");
      emp.setEaddres("Hyd");
      emp.setSalary(9000.0);
      
	  template.send(topicName,emp);
	  
	  System.out.println("Message Sent.");

	}
}
