package com.raj.service;

import java.util.List;

import com.raj.entity.PoliticalParty;
import com.raj.entity.Politician;

public interface IPoliticalPartyMgmtService {

	String savePoliticalPartyAndPoliticians(PoliticalParty party);
	String savePoliticiansAndPoliticalParty(Politician pltcn1,Politician pltcn2);
	List<PoliticalParty> showAllPartyAndPoliticians();
	List<Politician> showAllPoliticiansAndTheirParties();
	String deletePartyAndItsPoliticiansByPartyId(int partyId);
	String deleteAllPoliticiansOfAParty(int partyId);
	String removePoliticianFromParty(int pltcnId);
	String addNewPoliticianToParty(int partyId, Politician politician);
	String changePoliticianFromOnePartyToAnotherParty(int plctnId, int partyId);
	String deleteAllChildsAndItsParent(int partyId);
	List<Object[]> showPartyAndPoliticiansDataUsingJoins();
}
