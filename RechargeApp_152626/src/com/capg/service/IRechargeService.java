package com.capg.service;

import com.capg.bean.RechargeDetails;

public interface IRechargeService {
	 boolean addRechargeDetails(RechargeDetails recharge);
	public void displayDetails(int tid);
	
	public boolean updateDetails(int tid);
	public boolean removeDetails(int tid);
}
