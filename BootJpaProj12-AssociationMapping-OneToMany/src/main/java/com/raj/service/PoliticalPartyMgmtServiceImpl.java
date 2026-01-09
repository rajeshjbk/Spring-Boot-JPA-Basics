package com.raj.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.raj.BootJpaProj12AssociationMappingOneToManyApplication;
import com.raj.entity.PoliticalParty;
import com.raj.entity.Politician;
import com.raj.repository.IPoliticalPartyRepository;
import com.raj.repository.IPoliticianRepository;

import jakarta.transaction.Transactional;

@Service
public class PoliticalPartyMgmtServiceImpl implements IPoliticalPartyMgmtService {

	private final BootJpaProj12AssociationMappingOneToManyApplication bootJpaProj12AssociationMappingOneToManyApplication;

	@Autowired
	private IPoliticalPartyRepository partyRepo;
	@Autowired
	private IPoliticianRepository politicianRepo;

	PoliticalPartyMgmtServiceImpl(BootJpaProj12AssociationMappingOneToManyApplication bootJpaProj12AssociationMappingOneToManyApplication) {
		this.bootJpaProj12AssociationMappingOneToManyApplication = bootJpaProj12AssociationMappingOneToManyApplication;
	}

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

	@Override
	public String deletePartyAndItsPoliticiansByPartyId(int partyId) {

		//Load the party object
		Optional<PoliticalParty> opt = partyRepo.findById(partyId);

		if(opt.isPresent()) {

			//Delete party and its politicians
			PoliticalParty party = opt.get();
			partyRepo.delete(party);

			return partyId+" Political Party and its Politicians are deleted.";

		}else {

			return "Political Party is not found.";
		}
	}

	@Override
	public String deleteAllPoliticiansOfAParty(int partyId) {

		//Load the party object
		Optional<PoliticalParty> opt = partyRepo.findById(partyId);

		if(opt.isPresent()) {

			PoliticalParty politicalParty = opt.get();

			//get All Politicians of a party
			Set<Politician> politicians = politicalParty.getPoliticians();

			//remove party for these politicians 

			politicians.forEach(plctn->{

				plctn.setParty(null);
			});

			politicianRepo.deleteAll(politicians);

			return partyId+" Party's all Politicians are Deleted";

		}else {

			return "Party is not found.";
		}
	}

	@Override
	@Transactional
	public String removePoliticianFromParty(int pltcnId) {

		//Load the Politician object
		Optional<Politician> byId = politicianRepo.findById(pltcnId);
		if(byId.isPresent()) {

			Politician politician = byId.get();
			politician.setParty(null);

			politicianRepo.save(politician);
			politicianRepo.delete(politician);

			return pltcnId+" Politician is removed from the party";

		}else {

			return pltcnId+" Politician is not found";
		}

	}

	@Override
	public String addNewPoliticianToParty(int partyId, Politician politician) {

		//Load the party object
		Optional<PoliticalParty> opt = partyRepo.findById(partyId);
		
		if(opt.isPresent()) {
			
			PoliticalParty party = opt.get();
			
			//get all existing Politicians
			Set<Politician> politicians = party.getPoliticians();
			
			//all new Politician
			politicians.add(politician);
			
			// set Party to Politician
			politician.setParty(party);
			
			//save the party
			partyRepo.save(party);
			
			return "New Politician is added to existing Party ID:: "+partyId;
		}
		return "Party is not found to add the new Politician.";
	}

	@Override
	public String changePoliticianFromOnePartyToAnotherParty(int plctnId, int partyId) {
		
		//Load Party object
		PoliticalParty party = partyRepo.findById(partyId).orElseThrow(()-> new IllegalArgumentException("Invalid Party Id."));
		
		//Load Politician object
		Politician politician = politicianRepo.findById(plctnId).orElseThrow(()-> new IllegalArgumentException("Invalid Politician Id."));
		
		//change party
		politician.setParty(party);
		
		//update the Politician object
		politicianRepo.save(politician);
		
		return plctnId+" Politician's Party is changed";
		
	}

	@Override
	public String deleteAllChildsAndItsParent(int partyId) {
		
		//Load Party object
		//Load the Party(parent) object
		Optional<PoliticalParty> opt = partyRepo.findById(partyId);
		
		if(opt.isPresent()) {
			
			PoliticalParty party = opt.get();
			
			//get all Politicians(childs) of a party
			Set<Politician> politicians = party.getPoliticians();
			
			//remove party from Politicians(childs)
			politicians.forEach(pltcn->{
				
				politicianRepo.delete(pltcn);
				
			});
			
			return "All Politicians and its party is Deleted";
		}
		
		return "Party is not found";
	}

	@Override
	public List<Object[]> showPartyAndPoliticiansDataUsingJoins() {
		
		return partyRepo.showDataUsingJoinsParentToChild();
	}
}
