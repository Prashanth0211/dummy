package com.cg.PaymentWalletJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.cg.PaymentWalletJpa.dto.Wallet;

public class WalletApplicationDAOImpl implements IWalletApplicationDAO {

	private EntityManager manager;

	public WalletApplicationDAOImpl() {
		manager = JPAUtil.getEntityManager();
	}

	public void beginTransaction() {
		manager.getTransaction().begin();

	}

	public void commitTransaction() {
		manager.getTransaction().commit();

	}

	public int createAccount(Wallet details) {
		manager.persist(details);
		return 1;
	}

	public Wallet login(String username, String password) {

		String password1 = null;
		Wallet customer = manager.find(Wallet.class, username);
		password1 = customer.getPassword();
		if (password1.equals(password)) {
			return customer;
		} else
			return null;
	}

	public double showBalance(String username) {
		double balance = manager.find(Wallet.class, username).getAmount();
		return balance;
	}

	public int deposit(String username, double amount) {
		Wallet wallet = manager.find(Wallet.class, username);
		wallet.setAmount(wallet.getAmount() + amount);
		manager.merge(wallet);
		return 1;
	}

	public int withdraw(String username, double amount) {
		Wallet wallet = manager.find(Wallet.class, username);
		wallet.setAmount(wallet.getAmount() - amount);
		manager.merge(wallet);
		return 1;
	}

	public int fundTransfer(String senderaccNo, String recieveraccNo, double amount) {
		Wallet wallet = manager.find(Wallet.class, senderaccNo);
		wallet.setAmount(wallet.getAmount() + amount);
		manager.merge(wallet);

		Wallet wallet1 = manager.find(Wallet.class, recieveraccNo);
		wallet1.setAmount(wallet1.getAmount() - amount);
		manager.merge(wallet1);
		return 1;
	}

	public List printTrans() {
		// TODO Auto-generated method stub
		return null;
	}

}
