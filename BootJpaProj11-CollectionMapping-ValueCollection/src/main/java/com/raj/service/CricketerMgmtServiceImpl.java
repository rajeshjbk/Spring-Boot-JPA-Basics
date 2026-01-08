package com.raj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raj.entity.CricketerInfo;
import com.raj.repository.ICricketerInfoRepository;

@Service
public class CricketerMgmtServiceImpl implements ICricketerMgmtService {

	@Autowired
	private ICricketerInfoRepository cricketerRepo;
	
	@Override
	public String registerCricketer(CricketerInfo cricketerInfo) {
		
		//save the object
		Integer cid = cricketerRepo.save(cricketerInfo).getCid();
		return "Cricketer information is saved with id value : "+cid;
	}

	@Override
	public List<CricketerInfo> showAllCricketer() {
		
		return cricketerRepo.findAll();
	}

	@Override
	public CricketerInfo showCricketerById(int id) {
		
		return cricketerRepo.findById(id).orElseThrow(()-> new IllegalArgumentException("Invalid Id."));
	}

}
