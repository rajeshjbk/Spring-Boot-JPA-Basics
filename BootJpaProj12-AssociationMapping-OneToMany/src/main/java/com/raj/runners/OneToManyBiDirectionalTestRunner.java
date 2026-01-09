package com.raj.runners;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.raj.entity.PoliticalParty;
import com.raj.entity.Politician;
import com.raj.service.IPoliticalPartyMgmtService;
@Component
public class OneToManyBiDirectionalTestRunner implements CommandLineRunner {

	@Autowired
	private IPoliticalPartyMgmtService partyService;

	@Override
	public void run(String... args) throws Exception {

		/*try {
			//parent object 
			PoliticalParty party1 = new PoliticalParty("BJP", "Lotus");

			//child objects
			Politician plctn1 = new Politician("Modi", "Gujarat", 75);
			Politician plctn2 = new Politician("AmitSha", "Gujarat", 65);
			Politician plctn3 = new Politician("Yogi", "UP", 50);

			//link Child objects to parent object
			party1.setPoliticians(Set.of(plctn1,plctn2,plctn3));

			//set parent to child
			plctn1.setParty(party1);
			plctn2.setParty(party1);
			plctn3.setParty(party1);

			//invoke the method
			String savePoliticalPartyAndPoliticians = partyService.savePoliticalPartyAndPoliticians(party1);
			System.out.println(savePoliticalPartyAndPoliticians);

		}catch (Exception e) {

			e.printStackTrace();
		}
		 */

		/*try {

			//parent object 
			PoliticalParty party2 = new PoliticalParty("INC", "Hand");

			//child objects
			Politician plctn1 = new Politician("Rahul", "Dehli", 50);
			Politician plctn2 = new Politician("Priyanka", "Dehli", 45);

			//link Child objects to parent object
			Set<Politician> setsOfPoliticians = new HashSet<>();
			setsOfPoliticians.add(plctn1);
			setsOfPoliticians.add(plctn2);

			party2.setPoliticians(setsOfPoliticians);

			//set parent to child
			plctn1.setParty(party2);
			plctn2.setParty(party2);


			//invoke the method
			String savePoliticiansAndPoliticalParty = partyService.savePoliticiansAndPoliticalParty(plctn1, plctn2);
		    System.out.println(savePoliticiansAndPoliticalParty);

		}catch (Exception e) {

			e.printStackTrace();
		}*/

		/*try {

			partyService.showAllPartyAndPoliticians().forEach(party->{

				System.out.println("Parent(Party):: "+party);

				Set<Politician> politicians = party.getPoliticians();
				politicians.forEach(pltcn->{
					System.out.println("Child(Politician):: "+pltcn);
				});
			});

		}catch (Exception e) {

			e.printStackTrace();
		}*/

		/*try {

			partyService.showAllPoliticiansAndTheirParties().forEach(pltcn -> {

				System.out.println("Child(Politician):: "+pltcn);
				PoliticalParty party = pltcn.getParty();
				System.out.println("Parent(PoliticalParty):: "+party);

				System.out.println("===========================================");
			});

		}catch (Exception e) {

			e.printStackTrace();
		}*/

		/*try {

			String deletePartyAndItsPoliticiansByPartyId = partyService.deletePartyAndItsPoliticiansByPartyId(1008);
		    System.out.println(deletePartyAndItsPoliticiansByPartyId);

		}catch (Exception e) {

			e.printStackTrace();
		}*/

		/*try {

			String deleteAllPoliticiansOfAParty = partyService.deleteAllPoliticiansOfAParty(1006);
			System.out.println(deleteAllPoliticiansOfAParty);

		}catch (Exception e) {

			e.printStackTrace();
		}*/

		/*try {

			String removePoliticianFromParty = partyService.removePoliticianFromParty(1019);
		     System.out.println(removePoliticianFromParty);

		}catch (Exception e) {

			e.printStackTrace();
		}*/

		/*try {

			Politician pltcn = new Politician("Sanjay", "Hyd", 28);
			String newPoliticianToParty = partyService.addNewPoliticianToParty(1009, pltcn);

			System.out.println(newPoliticianToParty);

		}catch (Exception e) {

			e.printStackTrace();
		}*/

		/*try {

			String changePoliticianFromOnePartyToAnotherParty = partyService.changePoliticianFromOnePartyToAnotherParty(1027, 1010);
		    System.out.println(changePoliticianFromOnePartyToAnotherParty);
		}catch (Exception e) {

			e.printStackTrace();
		}*/

		/*try {

			String deleteAllChildsAndItsParent = partyService.deleteAllChildsAndItsParent(1010);
		    System.out.println(deleteAllChildsAndItsParent);

		}catch (Exception e) {

			e.printStackTrace();
		}*/

		try {

			partyService.showPartyAndPoliticiansDataUsingJoins().forEach(row->{

				System.out.println(Arrays.toString(row));

			});

		}catch (Exception e) {

			e.printStackTrace();
		}
	}
}
