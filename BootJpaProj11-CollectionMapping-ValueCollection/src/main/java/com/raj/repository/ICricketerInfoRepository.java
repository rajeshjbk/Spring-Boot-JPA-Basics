package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.CricketerInfo;

public interface ICricketerInfoRepository extends JpaRepository<CricketerInfo, Integer> {

}
