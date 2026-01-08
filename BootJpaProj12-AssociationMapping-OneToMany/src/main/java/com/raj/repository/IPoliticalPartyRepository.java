package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.PoliticalParty;

public interface IPoliticalPartyRepository extends JpaRepository<PoliticalParty, Integer> {

}
