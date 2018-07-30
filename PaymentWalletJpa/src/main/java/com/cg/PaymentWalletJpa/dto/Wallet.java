package com.cg.PaymentWalletJpa.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="wallet3")
public class Wallet {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String accNo;
	private LocalDate date;
	private double amount;
	
	private String Name;
	private String gender;
	private String mobileNo;
	private int age;
	private String email;
	private String username;
	private String password;

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAccNo() {
		return accNo;
	}

	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	

	@Override
	public String toString() {
		return "Wallet [accNo=" + accNo + ", date=" + date + ", amount=" + amount + ", , Name="
				+ Name + ", gender=" + gender + ", mobileNo=" + mobileNo + ", age=" + age + ", email=" + email
				+ ", username=" + username + ", password=" + password + "]";
	}

	

}
