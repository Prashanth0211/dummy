package com.cg.PaymentWalletJpa.exception;

public class WalletException extends Exception {

	public WalletException() {
		super();
	}
	 public WalletException(String msg) {
		 System.out.println(msg);
	 }
}
