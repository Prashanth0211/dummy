package com.capg.service;

public class RechargeDataValidate {
	public boolean validatedthOperator(String dthOperator) {
		if (dthOperator.equals("Airtel") || dthOperator.equals("DishTV") || dthOperator.equals("Reliance")
				|| dthOperator.equals("TATASky"))
			return true;
		else
			return false;

	}

	public boolean validateConsumerNO(String consumerNO) {
		if (consumerNO.length() == 10)
			return true;
		else
			return false;
	}

	public boolean validatePlan(String rechargePlan) {
		if (rechargePlan.equals("Monthly") || rechargePlan.equals("Quaterly") || rechargePlan.equals("Halfyearly")
				|| rechargePlan.equals("annual"))

			return true;
		else
			return false;
	}

	public boolean validateAmount(String amount) {
		if (amount.length() >= 3 || amount.length() <= 4)
			return true;
		else
			return false;
	}
}
