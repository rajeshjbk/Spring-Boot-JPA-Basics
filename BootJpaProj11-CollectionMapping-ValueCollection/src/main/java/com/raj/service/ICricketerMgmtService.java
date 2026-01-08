package com.raj.service;

import java.util.List;

import com.raj.entity.CricketerInfo;

public interface ICricketerMgmtService {

	String registerCricketer(CricketerInfo cricketerInfo);
	List<CricketerInfo> showAllCricketer();
	CricketerInfo showCricketerById(int id);
}
