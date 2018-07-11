package com.capg.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

import com.capg.bean.RechargeDetails;
import com.capg.exception.NoTransactionFoundException;
import com.capg.service.RechargeDataValidate;
import com.capg.service.RechargeService;


public class RechargeClient {
	static boolean b;


	public static void main(String[] args) {
		Random rand=new Random();

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		RechargeDataValidate validate=new RechargeDataValidate();
		RechargeService service=new RechargeService();
		
		
		
		boolean isValidOperator;
		boolean isValidConsumerNo;
		boolean isValidPlan;
		boolean isValidAmount;
		int tid=0;
		int choice = 0;
		do {
	
		System.out.println("Welcome to DTH service");
		System.out.println("1.Make Recharge");
		System.out.println("2.Display Details");
		System.out.println("3.Update");
		System.out.println("4.remove");
		System.out.println("5.exit");
		System.out.println("Enter the choice");
		 
  try {
	try {
		choice=Integer.parseInt(br.readLine());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
} catch (NumberFormatException e2) {
	
	e2.printStackTrace();
} 

		switch(choice) {
		case 1:{
		
		try {
			System.out.println("Enter operator (Airtel/DishTV/Reliance/TATASky)");
			String dthOperator=br.readLine();
			
			System.out.println("enter consumer NO");
			String consumerNO=br.readLine();
			
			System.out.println("Enter Recharge plan (Monthly/Quaterly/Halfyearly/annual)");
			String rechargePlan=br.readLine();
			
			System.out.println("Enter Amount (100 to 9999)");
			String amount=br.readLine();
			
			 tid=rand.nextInt(9000000)+10000000;
			System.out.println(tid);
			
			RechargeDetails recharge=new RechargeDetails();
			
			recharge.setDthOperator(dthOperator);
			
			recharge.setConsumerNO(Integer.parseInt(consumerNO));
			
			recharge.setAmount(Integer.parseInt(amount));
			
			recharge.setRechargePlan(rechargePlan);
			
			recharge.setTid(tid);
			
			
			
			  isValidOperator=validate.validatedthOperator(dthOperator);
			 isValidConsumerNo=validate.validateConsumerNO(consumerNO);
			 isValidPlan=validate.validatePlan(rechargePlan);
			 isValidAmount=validate.validateAmount(amount);
			
			
			if(isValidOperator && isValidConsumerNo && isValidPlan && isValidAmount) {
				b=service.addRechargeDetails(recharge);
			}
			
		
				else System.out.println("enter valid values");
					
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		if(b) {
			System.out.println("Recharge successful Tid"+tid);
		}
		
		else {
			try {
				throw new NoTransactionFoundException();
				
			} catch (NoTransactionFoundException e) {
			System.err.println("Transaction failure");
			}
		}
		break;
		}
		
		case 2:{
			System.out.println("Enter transaction id");
			
			try {
				int tid1=Integer.parseInt(br.readLine());
				service.displayDetails(tid1);
			} catch (NumberFormatException | IOException e1) {
				
				e1.printStackTrace();
			}
			break;
		}
			
			case 3:
			{
				RechargeDetails recharge=new RechargeDetails();
				System.out.println("Update");
				
				System.out.println("Enter your transID");
				
				try {
					int tid2=Integer.parseInt(br.readLine());
					service.updateDetails(tid2);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				break;
			}
			case 4:
			{
				RechargeDetails recharge=new RechargeDetails();
				System.out.println("remove");
				System.out.println("Enter transaction ID");
				
				try {
					int tid3= Integer.parseInt(br.readLine());
					service.removeDetails(tid3);
					System.out.println(recharge);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
				break;
			}
			case 5:
			{
				System.out.println("exit");
				System.exit(0);
			}
		}
		
		
	
		
	
		
			
		
			
		} while(choice!=5);
	}
}
		
	

		


	
