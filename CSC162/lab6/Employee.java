package lab6;

//Patrick Nogaj
//CSC-162-01
//LAB 6D

public class Employee {

	private String name;
	private String employeeNumber;
	private String hireDate;
	private boolean validEmployeeNum;
	
	public Employee() {
		name = "";
		hireDate = "";
		employeeNumber = "";
	}
	
	public Employee(String name, String employeeNumber, String hireDate) {
		this.name = name;
		this.employeeNumber = employeeNumber;
		this.hireDate = hireDate;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	
	public String getHireDate() {
		return hireDate;
	}
	
	public boolean isValidEmpNum() {
		if(validEmployeeNum) 
			return true;
		else 
			return false;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmployeeNumber(String employeeNumber) throws InvalidEmployeeNumber {
		this.employeeNumber = employeeNumber;
		
		if((!Character.isDigit(employeeNumber.charAt(0))) || (!Character.isDigit(employeeNumber.charAt(1))) || 
				(!Character.isDigit(employeeNumber.charAt(2))) || (employeeNumber.charAt(3) != '-') || 
				(!Character.isLetter(employeeNumber.charAt(4)))  || 
				(!(employeeNumber.charAt(4)>= 'A' && employeeNumber.charAt(4)<= 'M'))) {
            		throw new InvalidEmployeeNumber();
         	}
	}
	
	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
	
	public String toString() {
		return "Name: " + getName()
		+ " \nEmployee ID: " + getEmployeeNumber()
		+ " \nHire date: " + getHireDate();
	}
	
}
