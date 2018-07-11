package com.capg.service;

import com.capg.bean.RechargeDetails;
import com.capg.dao.RechargeDAO;

public class RechargeService implements IRechargeService{
	RechargeDAO dao=new RechargeDAO();
	
public boolean addRechargeDetails(RechargeDetails recharge) {
	

	return dao.addRechargeDetails(recharge);
	
}
public void displayDetails(int tid) {
	dao.displayDetails(tid);
}
public boolean updateDetails(int tid) {
	return dao.updateDetails(tid);
}
public boolean removeDetails(int tid) {
	return dao.removeDetails(tid);
}

}
