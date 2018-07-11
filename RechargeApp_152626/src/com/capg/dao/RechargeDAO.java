package com.capg.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.capg.bean.RechargeDetails;
import com.capg.service.RechargeDataValidate;

public class RechargeDAO implements IRechargeDAO {

	boolean flag = false;
	List<RechargeDetails> list = new ArrayList<RechargeDetails>();

	public boolean addRechargeDetails(RechargeDetails recharge) {
		flag = list.add(recharge);

		return flag;

	}

	public void displayDetails(int tid) {
		for (RechargeDetails recharge : list) {
			if (recharge.getTid() == tid) {
				System.out.println(recharge);
			} else
				System.out.println();
		}
	}

	public boolean updateDetails(int tid) {
		RechargeDataValidate validate = new RechargeDataValidate();
		
		for (RechargeDetails recharge : list) {
			if ((int) recharge.getTid() == tid) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				try {
					
					System.out.println("Enter dth operator:");
					String dthOperator = br.readLine();
					System.out.println("Enter consumerNO:");
					String consumerNO = br.readLine();
					System.out.println("Enter the plan:");
					String rechargePlan= br.readLine();

					
					boolean isValidOperator = validate.validatedthOperator(dthOperator);
					
					boolean isValidConsumerNo = validate.validateConsumerNO(consumerNO);
					
					boolean isValidPlan = validate.validatePlan(rechargePlan);

					if (isValidOperator && isValidConsumerNo && isValidPlan) {

						recharge.setDthOperator(dthOperator);

						recharge.setConsumerNO(Integer.parseInt(consumerNO));
						recharge.setRechargePlan(rechargePlan);
					} else
						System.out.println("Provide valid information");

				} catch (Exception e) {
					e.printStackTrace();
				}
			} else
				System.out.println("wrong transaction ID");
		}
		return flag;
	}

	public boolean removeDetails(int tid) {
		for(RechargeDetails recharge:list) {
		if(recharge.getTid()==tid)
			list.remove(recharge);
		else
		{
			System.out.println("Wrong transaction id");
		}
		}
	return flag;
}}
