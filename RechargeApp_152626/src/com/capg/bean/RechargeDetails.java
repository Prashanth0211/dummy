package com.capg.bean;

public class RechargeDetails {
private String dthOperator;
private int consumerNO;
private String rechargePlan;
private int amount;
private long tid;
public String getDthOperator() {
	return dthOperator;
}
public void setDthOperator(String dthOperator) {
	this.dthOperator = dthOperator;
}
public int getConsumerNO() {
	return consumerNO;
}
public void setConsumerNO(int consumerNO) {
	this.consumerNO = consumerNO;
}
public String getRechargePlan() {
	return rechargePlan;
}
public void setRechargePlan(String rechargePlan) {
	this.rechargePlan = rechargePlan;
}
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public long getTid() {
	return tid;
}
public void setTid(long tid) {
	this.tid = tid;
}
@Override
public String toString() {
	return "RechargeDetails [dthOperator=" + dthOperator + ", consumerNO=" + consumerNO + ", rechargePlan="
			+ rechargePlan + ", amount=" + amount + ", transaction=" +tid + "]";
}
}

