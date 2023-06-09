package com.app.banking;

import java.lang.Exception;
import java.time.LocalDate;


public class BankAccount implements Comparable<BankAccount>{

	private int accountNumber;
	private String customerName;
	private double accountBalance;
	LocalDate accountOpeningDate;
	AccountType accType;
	
	public BankAccount(int accountNumber, String customerName, LocalDate accountOpeningDate, double accountBalance, AccountType a1) {
		super();
		this.accountNumber = accountNumber;
		this.customerName = customerName;
		this.accountOpeningDate = accountOpeningDate;
		this.accountBalance = accountBalance;
		this.accType = a1;
	}

	public BankAccount(int accountNumber) {
		super();
		this.accountNumber = accountNumber;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}


	public double getAccountBalance() {
		return accountBalance;
	}



	
	
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + this.accountNumber + ", customerName=" + this.customerName + ", accountBalance="
				+ this.accountBalance + ", accountOpeningDate=" + this.accountOpeningDate + ", accType=" + this.accType + "]";
	}

	public void deposit(double amount) {
		
		accountBalance += amount;
		
		
	}
	
	public void withdraw(double amount) throws BankingException{
		try {
			
			if((this.accountBalance < amount) || ((this.accountBalance-amount) < this.accType.getBalance())) {
				throw new BankingException("Balance too low to withdraw.... ");
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		this.accountBalance= this.accountBalance-amount;
		
	}
	
	public void fundTransfer(BankAccount reciver,double amount) throws BankingException {
		try {
			if(this.getAccountBalance()-amount<this.accType.getBalance()) {
				throw new BankingException("Balance too low for Fund Transfer.... ");
			}			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		this.accountBalance-=amount;
		reciver.accountBalance+=amount;

	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof BankAccount)
			return ((Integer)this.accountNumber).equals(((BankAccount) obj).accountNumber);
		return false;
	}

	@Override
	public int compareTo(BankAccount o) {
		return ((Integer)this.getAccountNumber()).compareTo(o.accountNumber);
			
	}
	
	
	public LocalDate getAccountOpeningDate() {
		return accountOpeningDate;
	}

	
	
	
	
	
}
