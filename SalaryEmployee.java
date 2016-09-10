import BreezySwing.Format;

public class SalaryEmployee extends Employee{

	private double weeklySalary;
	
	public SalaryEmployee(String Name, String idNumber, double weeklySalary) {
		super(Name, idNumber);
		this.weeklySalary = weeklySalary;
	}
	
	public double getFinalSalary(){
		return weeklySalary;
	}

	@Override
	public String Print() {
		return Format.justify('l', getName(), 15) + Format.justify('l', getIDNumber(), 15) + 
		Format.justify('l', "$" + String.format("$%.2f", weeklySalary),15) + "\n";
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
