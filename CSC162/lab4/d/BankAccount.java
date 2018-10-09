package lab4d;

//Patrick Nogaj
//CSC-162-01
//LAB #4-D

import java.text.DecimalFormat;

public abstract class BankAccount {
	
	protected double balance, numDeposits, numWithdrawals, interestRate, monthlyServiceCharges;
	DecimalFormat df = new DecimalFormat("####.00");
	
	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
		numDeposits = 0;
		numWithdrawals = 0;
		monthlyServiceCharges = 0;
	}
	
	public void deposit(double deposit) {
		balance += deposit;
		numDeposits++;
	}
	
	public void withdraw(double withdraw) {
		balance -= withdraw;
		numWithdrawals++;
	}
	
	public void calcInterest() {
		double monthlyInterest = interestRate / 12;
		monthlyInterest = balance * monthlyInterest;
		balance = balance + monthlyInterest;
	}
	
	public void monthlyProcess() {
		balance -= monthlyServiceCharges;
		calcInterest();
		numDeposits = 0;
		numWithdrawals = 0;
		monthlyServiceCharges = 0;
	}
	
	public void setMonthlyServiceCharges(double monthlyServiceCharges) {
		this.monthlyServiceCharges = monthlyServiceCharges;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public double getNumDeposits() {
		return numDeposits;
	}
	
	public double getNumWithdrawals() {
		return numWithdrawals;
	}
	
	public double getInterestRate() {
		return interestRate;
	}
	
	public double getMonthlyServiceCharges() {
		return monthlyServiceCharges;
	}
	
	
	public String toString() {
		return "Balance: $" + df.format(getBalance()) + "\n" +
				"Number of deposits: " + getNumDeposits() + "\n" +
				"Number of withdrawals: " + getNumWithdrawals() + "\n";
	}

}
