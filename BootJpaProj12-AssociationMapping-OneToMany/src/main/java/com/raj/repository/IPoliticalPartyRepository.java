package com.raj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.raj.entity.PoliticalParty;

public interface IPoliticalPartyRepository extends JpaRepository<PoliticalParty, Integer> {

//	@Query("select p.partyId, p.partyName, p.symbol, pl.pid, pl.paddrs, pl.age from PoliticalParty p inner join p.politicians pl")
//	@Query("select p.partyId, p.partyName, p.symbol, pl.pid, pl.paddrs, pl.age from PoliticalParty p left join p.politicians pl")
//	@Query("select p.partyId, p.partyName, p.symbol, pl.pid, pl.paddrs, pl.age from PoliticalParty p full join p.politicians pl")
	@Query("select p.partyId, p.partyName, p.symbol, pl.pid, pl.paddrs, pl.age from PoliticalParty p right join p.politicians pl")
	List<Object[]> showDataUsingJoinsParentToChild();
}
