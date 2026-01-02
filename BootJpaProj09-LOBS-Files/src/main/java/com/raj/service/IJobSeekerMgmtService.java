package com.raj.service;

import java.util.List;

import com.raj.entity.JobSeeker;

public interface IJobSeekerMgmtService {

	String registerJobSeeker(JobSeeker js);
	JobSeeker findJobSeekerById(int id);
	List<JobSeeker> showAllJobSeekers();
}
