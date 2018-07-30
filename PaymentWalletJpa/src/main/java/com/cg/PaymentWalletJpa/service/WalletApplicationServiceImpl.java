package com.cg.PaymentWalletJpa.service;

import java.util.List;

import com.cg.PaymentWalletJpa.dao.IWalletApplicationDAO;
import com.cg.PaymentWalletJpa.dao.WalletApplicationDAOImpl;
import com.cg.PaymentWalletJpa.dto.Wallet;
import com.cg.PaymentWalletJpa.exception.IWalletException;
import com.cg.PaymentWalletJpa.exception.WalletException;

public class WalletApplicationServiceImpl implements IWalletApplicationService {

	IWalletApplicationDAO dao = new WalletApplicationDAOImpl();

	public int createAccount(Wallet details) {
		dao.beginTransaction();
		dao.createAccount(details);
		dao.commitTransaction();
		return 1;
	}

	public Wallet login(String username, String password) throws WalletException {
		Wallet customer = new Wallet();
		if (dao.login(username, password) != null) {
			customer = dao.login(username, password);
		} else
			throw new WalletException(IWalletException.ERROR4);
		return customer;
	}

	public double showBalance(String username) {
		double balance = 0;
		dao.beginTransaction();
		balance = dao.showBalance(username);
		dao.commitTransaction();
		return balance;
	}

	public int deposit(String username, double amount) {
		int result = 0;
		if (amount > 0) {
			dao.beginTransaction();
			dao.deposit(username, amount);
			dao.commitTransaction();
			result = 1;
		}
		return result;
	}

	public int withdraw(String username, double amount) {
		int result = 0;
		if (dao.showBalance(username) >= amount) {
			dao.beginTransaction();
			dao.withdraw(username, amount);
			dao.commitTransaction();
			result = 1;
		}
		return result;
	}

	public int fundTransfer(String senderaccNo, String recieveraccNo, double amount) {
		int result = 0;
		if (dao.showBalance(senderaccNo) >= amount) {
			dao.beginTransaction();
			dao.fundTransfer(senderaccNo, recieveraccNo, amount);
			dao.commitTransaction();
			result = 1;
		}
		return result;
	}

	public List<String> printTrans() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validationDetails(Wallet customer) throws WalletException {
		boolean result = false;

		if (customer.getName().matches("[A-Z]{1}[a-z]+")) {
			if (customer.getMobileNo().matches("[0-9]{10}")) {
				if (customer.getEmail().matches("[a-zA-Z0-9_]*@gmail.com")) {
					if (!(customer.getUsername().equals(customer.getPassword()))) {
						if (customer.getUsername().matches("[A-Za-z0-9]{4,}")) {
							if (customer.getPassword().length() >= 8) {
								result = true;
							} else
								throw new WalletException(IWalletException.ERROR7);
						} else
							throw new WalletException(IWalletException.ERROR6);
					} else
						throw new WalletException(IWalletException.ERROR5);
				} else
					throw new WalletException(IWalletException.ERROR3);
			} else
				throw new WalletException(IWalletException.ERROR2);
		} else
			throw new WalletException(IWalletException.ERROR1);

		return result;
	}
}
