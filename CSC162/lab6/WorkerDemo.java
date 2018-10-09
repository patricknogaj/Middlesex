package lab6;

//Patrick Nogaj
//CSC-162-01
//LAB 6D

public class WorkerDemo {

	public static void main(String[] args) throws InvalidShift, InvalidPayRate, InvalidEmployeeNumber {
			createWorker("John Smith", "123-L", "11-15-2009", "day shift", 16.50);
			createWorker("John Smith", "10001", "11-15-2009", "day shift", 16.50);
			createWorker("John Smith", "123-L", "11-15-2009", "66", 16.50);
			createWorker("John Smith", "123-L", "11-15-2009", "day shift", -99.00);
	}
	
	public static void createWorker(String name, String ID, String date, String shift, double payRate) throws InvalidShift, InvalidPayRate, InvalidEmployeeNumber {
		ProductionWorker object = new ProductionWorker();
		object.setName(name);
		String msg = " ";
		try {
			object.setEmployeeNumber(ID);
			object.setShift(shift);
			object.setPayRate(payRate);
		} catch (InvalidEmployeeNumber e) {
			msg = e.getMessage();
		} catch (InvalidShift e) {
			msg = e.getMessage();
		} catch (InvalidPayRate e) {
			msg = e.getMessage();
		} finally {
			object.setHireDate(date);
		}
		System.out.println(object + " \n" + msg + "\n");
	}
}

