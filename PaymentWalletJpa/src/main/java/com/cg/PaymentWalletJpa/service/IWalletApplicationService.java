package com.cg.PaymentWalletJpa.service;

import java.util.List;

import com.cg.PaymentWalletJpa.dto.Wallet;
import com.cg.PaymentWalletJpa.exception.WalletException;

public interface IWalletApplicationService {

	public int createAccount(Wallet details);

	public Wallet login(String username, String password) throws WalletException;

	public double showBalance(String username);

	public int deposit(String username, double amount);

	public int withdraw(String username, double amount);

	public int fundTransfer(String senderaccNo, String recieveraccNo, double amount);

	public List<String> printTrans();

	public boolean validationDetails(Wallet customer) throws WalletException;

}
