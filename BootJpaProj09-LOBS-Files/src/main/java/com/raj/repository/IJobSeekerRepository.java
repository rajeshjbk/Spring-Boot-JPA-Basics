package com.raj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.JobSeeker;

public interface IJobSeekerRepository extends JpaRepository<JobSeeker, Integer> {

}
