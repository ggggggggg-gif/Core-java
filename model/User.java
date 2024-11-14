package model;

import java.io.Serializable;

public class User implements Serializable {
	private String name;
	private String pwd;
	private String email;
	private long phone;	
	private int accountNumber;
	private double balance;
	
	
	
	public User(String name, String pwd, String email, long phone, int accountNumber, double balance) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.email = email;
		this.phone = phone;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public User() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}
