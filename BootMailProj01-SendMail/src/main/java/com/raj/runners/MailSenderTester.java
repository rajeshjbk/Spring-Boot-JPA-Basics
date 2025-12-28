package com.raj.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.service.IShoppingService;
@Component
public class MailSenderTester implements CommandLineRunner {

	@Autowired
	private IShoppingService service;
	
	@Override
	public void run(String... args) throws Exception {
		
		try {
			
			String shopping = service.shopping(new String[] {"Shirt","Trouser","Watch"},
					new double[] {1000.0,2000.0,5000.0},
					new String[] {"mahtorajeshkumar8920@gmail.com","rajesh.mahto.ds.2021@mitmeerut.ac.in"});
		
			System.out.println(shopping);
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
