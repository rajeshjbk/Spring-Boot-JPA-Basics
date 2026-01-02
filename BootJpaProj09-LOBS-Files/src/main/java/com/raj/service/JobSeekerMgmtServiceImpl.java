package com.raj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.JobSeeker;
import com.raj.repository.IJobSeekerRepository;

@Service
public class JobSeekerMgmtServiceImpl implements IJobSeekerMgmtService {

	@Autowired
	private IJobSeekerRepository jobSeekerRepo;
	
	@Override
	public String registerJobSeeker(JobSeeker js) {
		
		Integer jsid = jobSeekerRepo.save(js).getJsid();
		
		return "New JobSeeker is registered with ID: "+jsid;
	}

	@Override
	public JobSeeker findJobSeekerById(int id) {
		
		return jobSeekerRepo.findById(id).orElseThrow(()->new IllegalArgumentException("Invalid id"));
	}

	@Override
	public List<JobSeeker> showAllJobSeekers() {
		
		return jobSeekerRepo.findAll();
	}
}
