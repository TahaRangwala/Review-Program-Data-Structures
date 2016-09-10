import BreezySwing.Format;

public class SalaryEmployee extends Employee{

	private double weeklySalary;
	
	public SalaryEmployee(String Name, String idNumber, double weeklySalary) {
		super(Name, idNumber);
		this.weeklySalary = weeklySalary;
	}

	@Override
	public String Print() {
		String Output =  Format.justify('l', "Name", 15) + Format.justify('l', "ID Number", 15) + 
		Format.justify('l', "Total Salary",15) + "\n";
		Output +=  Format.justify('l', getName(), 15) + Format.justify('l', getIDNumber(), 15) + 
		Format.justify('l', "$" + String.format("$%.2f", weeklySalary),15) + "\n\n";
		return Output;
	}
	
	public static void checkSalaryEmployee(String Name, String idNumber, double weeklySalary){
		if(Name == ""){
			throw new IllegalArgumentException("Please Input the Correct Name For A Salary Employee!");
		}
		else if(idNumber == "" || idNumber.length() != 6){
			throw new IllegalArgumentException("Please Input the Correct ID Number For A Salary Employee!");
		}
		else if(weeklySalary < 0){
			throw new IllegalArgumentException("Please Input the Correct Weekly Salary For A Salary Employee!");
		}
	}
	

}
