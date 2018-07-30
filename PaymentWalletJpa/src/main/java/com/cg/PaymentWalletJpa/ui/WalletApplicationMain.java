package com.cg.PaymentWalletJpa.ui;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.cg.PaymentWalletJpa.dto.Wallet;
import com.cg.PaymentWalletJpa.exception.IWalletException;
import com.cg.PaymentWalletJpa.exception.WalletException;
import com.cg.PaymentWalletJpa.service.IWalletApplicationService;
import com.cg.PaymentWalletJpa.service.WalletApplicationServiceImpl;

public class WalletApplicationMain {

	public static void main(String[] args) {
		IWalletApplicationService service = new WalletApplicationServiceImpl();
		Scanner scr = new Scanner(System.in);
		List<String> trans = new ArrayList<String>();
		int key = 0;
		System.out.println("***Welcome to Payment Wallet Application***");
		do {
			System.out.println("1.CreateAccount\n2.Login\n3.Exit");
			System.out.println("Enter choice");
			try {
				key = scr.nextInt();
				switch (key) {
				case 1:
					try {
						System.out.println("Enter Name: ");
						String name = scr.next();
						System.out.println("Enter  gender(Male/Female): ");
						String gender = scr.next();
						System.out.println("Enter Mobile Number: ");
						String mobileNo = scr.next();
						System.out.println("Enter age: ");
						int age = scr.nextInt();
						System.out.println("Enter email: ");
						String email = scr.next();
						System.out.println("Enter UserName: ");
						String username = scr.next();
						System.out.println("Enter password of minimum length 8");
						String password = scr.next();
						System.out.println("Enter minimum amount");
						double amount = scr.nextDouble();
						LocalDate date = LocalDate.now();
		
						Wallet details = new Wallet();
						details.setName(name);
						details.setGender(gender);
						details.setMobileNo(mobileNo);
						details.setAge(age);
						details.setEmail(email);
						details.setUsername(username);
						details.setPassword(password);
						details.setAmount(amount);

						details.setDate(date);

						boolean result = false;
						try {
							result = service.validationDetails(details);
						} catch (WalletException stException) {
							System.out.println(stException.getMessage());
						}
						if (result) {
							service.createAccount(details);
							System.out.println("Your Account has been created");
							System.out.println("Account No is :" + details.getAccNo());
						} else {
							System.out.println("Enter Valid Details");
						}

					} catch (Exception e) {
						System.out.println(e.getMessage());
					}

					break;
				case 2:
					int choice = 0;
					Scanner scr1 = new Scanner(System.in);

					try {
						System.out.println("Enter username");
						String username = scr.next();
						System.out.println("Enter password");
						String password = scr.next();

						if (service.login(username, password) != null) {
							System.out.println("LoggedIn succesfully");
							do {
								System.out.println(
										"1.ShowBalance\n2.Deposit\n3.Withdraw\n4.FundTransfer\n5.PrintTransactions\n6.Exit the Application");
								System.out.println("Enter your choice");
								choice = scr.nextInt();
								switch (choice) {
								case 1:
									System.out.println("Your Account Balance is :" + service.showBalance(username));
									break;
								case 2:
									System.out.println("Enter the amount to deposite");
									double amount = scr.nextDouble();
									service.deposit(username, amount);
									break;
								case 3:
									System.out.println("Enter the amount to withdraw");
									double with_amt = scr.nextDouble();
									service.withdraw(username, with_amt);

									break;
								case 4:
									System.out.println("Enter user id of sender");
									String sender = scr.next();
									System.out.println("Enter user id of reciever");
									String reciever = scr.next();
									System.out.println("Enter amount to transfer");
									double tran_amt = scr.nextDouble();
									service.fundTransfer(sender, reciever, tran_amt);
									break;
								case 5:
									System.out.println(service.printTrans());
									break;
								case 6:
									System.exit(0);
									break;
								default:

									System.out.println("Enter valid choice");
									break;
								}
							} while (choice != 6);
						} else {
							try {
								throw new WalletException(IWalletException.ERROR4);
							} catch (Exception e) {
								System.out.println(e.getMessage());
							}
						}

					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 3:
					System.exit(0);
					break;

				default:
					System.out.println("Enter correct choice");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} while (key != 3);

	}

}
