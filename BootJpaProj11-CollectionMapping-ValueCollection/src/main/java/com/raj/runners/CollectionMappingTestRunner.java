package com.raj.runners;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.CricketerInfo;
import com.raj.service.ICricketerMgmtService;
@Component
public class CollectionMappingTestRunner implements CommandLineRunner {

	@Autowired
	private ICricketerMgmtService cricketerService;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*try {
			
			CricketerInfo info = new CricketerInfo("Rohit", "Mumbai",
					List.of("Shikar","Surya","Bumrah") , 
					Set.of(8898884568L,4567876869L,5678921678L), 
					Map.of("Aadhar","345473","Voterid","56856"));
			
			String registerCricketer = cricketerService.registerCricketer(info);
		    System.out.println(registerCricketer);
		    
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		*/
		
		/*try {
			
			cricketerService.showAllCricketer().forEach(System.out::println);
		}catch (Exception e) {
			
			e.printStackTrace();
		}*/
		
		try {
			
			CricketerInfo showCricketerById = cricketerService.showCricketerById(1001);
		    System.out.println(showCricketerById);
		    
		}catch (Exception e) {
			
		   e.printStackTrace();
		}
	}

}
