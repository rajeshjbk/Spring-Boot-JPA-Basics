package com.raj.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.PoliticalParty;
import com.raj.entity.Politician;
import com.raj.repository.IPoliticalPartyRepository;
import com.raj.repository.IPoliticianRepository;
@Service
public class PoliticalPartyMgmtServiceImpl implements IPoliticalPartyMgmtService {

	@Autowired
	private IPoliticalPartyRepository partyRepo;
	@Autowired
	private IPoliticianRepository politicianRepo;
	
	@Override
	public String savePoliticalPartyAndPoliticians(PoliticalParty party) {
		
		//use repo
		Integer partyId = partyRepo.save(party).getPartyId();
		
		return "PoliticalParty and Politicians are saved with id values: "+partyId;
	}

	@Override
	public String savePoliticiansAndPoliticalParty(Politician pltcn1, Politician pltcn2) {
		
		//Prepare List having bunch of Politicians
		List<Politician> list = List.of(pltcn1,pltcn2);
		
		//save the object
		List<Politician> saveAll = politicianRepo.saveAll(list);
		
		//get id values
		List<Integer> ids = saveAll.stream().map(Politician::getPid).collect(Collectors.toList());
		
		return ids.size()+" no.of Politician are saved having id values:: "+ids;
	}

	@Override
	public List<PoliticalParty> showAllPartyAndPoliticians() {
		
		return partyRepo.findAll();
	}

	@Override
	public List<Politician> showAllPoliticiansAndTheirParties() {
		
		return politicianRepo.findAll();
	}

}
