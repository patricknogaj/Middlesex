package lab4d;

//Patrick Nogaj
//CSC-162-01
//LAB #4-D

public class SavingsAccount extends BankAccount {
	
	private boolean status;

	public SavingsAccount(double balance, double interestRate, double monthlyServiceCharges) {
		super(balance, interestRate);
		this.monthlyServiceCharges = monthlyServiceCharges;
		
		if(balance >= 25)
			status = true;
		else 
			status = false;
	}
	
	public void withdraw(double withdraw) {
		if(balance >= 25)
			super.withdraw(withdraw);
		else
			System.out.println("You are not allowed to make a deposit. Please have at least $25.00 in your account");
	}
	
	public void deposit(double deposit) {
		if (balance < 25 && (deposit + balance) > 25) {
			super.deposit(deposit);
			status = true;
		} else {
			super.deposit(deposit);
			status = false;
		}
	}
	
	public void monthlyProcess() {
		if(numWithdrawals < 4)
			monthlyServiceCharges += (numWithdrawals - 4) * 1.00;
		super.monthlyProcess();
	}
	
}
