package com.cg.PaymentWalletJpa.dao;

import java.util.List;



import com.cg.PaymentWalletJpa.dto.Wallet;

public interface IWalletApplicationDAO {
	public void beginTransaction();

	public void commitTransaction();

	public int createAccount(Wallet details);

	public Wallet login(String username, String password);

	public double showBalance(String username);

	public int deposit(String username,double amount);

	public int withdraw(String username,double amount);

	public int fundTransfer(String senderaccNo,String recieveraccNo, double amount);

	public List printTrans();

}
