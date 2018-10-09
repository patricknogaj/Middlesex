package lab4d;

//Patrick Nogaj
//CSC-162-01
//LAB #4-D

public class SavingsDemo {
	
	public static void main(String[] args) {
		SavingsAccount savings = new SavingsAccount(100, 3, 2.50);
		System.out.println(savings);
		
		savings.deposit(25.00);
		savings.deposit(10.00);
		savings.deposit(35.00);
		
		System.out.println(savings);
		
		savings.withdraw(100.00);
		savings.withdraw(50.00);
		savings.withdraw(10.00);
		savings.withdraw(1.00);
		savings.withdraw(1.00);
		
		System.out.println(savings);
		
		savings.monthlyProcess();
		
		System.out.println(savings);
	}
}
