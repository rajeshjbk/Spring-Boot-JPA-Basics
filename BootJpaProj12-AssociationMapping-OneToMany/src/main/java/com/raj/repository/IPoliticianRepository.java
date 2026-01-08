package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.Politician;

public interface IPoliticianRepository extends JpaRepository<Politician, Integer> {

}
