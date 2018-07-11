package com.capg.dao;

import com.capg.bean.RechargeDetails;

public interface IRechargeDAO {
	boolean addRechargeDetails(RechargeDetails recharge);
	void displayDetails(int tid);
	boolean removeDetails(int tid);

}
