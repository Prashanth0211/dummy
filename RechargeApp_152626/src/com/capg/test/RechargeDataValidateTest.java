package com.capg.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.capg.service.RechargeDataValidate;

public class RechargeDataValidateTest {
	RechargeDataValidate validate=new RechargeDataValidate();

	@Test
	public void testValidatedthOperator() {
		//fail("Not yet implemented");
		assertEquals("Result",true,validate.validatedthOperator("Airtel"));
	}

	@Test
	public void testValidateConsumerNO() {
		//fail("Not yet implemented");
		assertEquals("Result",true,validate.validateConsumerNO("1234567890"));
	}

	@Test
	public void testValidatePlan() {
		//fail("Not yet implemented");
		assertEquals("Result",true,validate.validatePlan("Annual"));
	}

	@Test
	public void testValidateAmount() {
		//fail("Not yet implemented");
		assertEquals("Result",true,validate.validateAmount("234"));
	}

}
