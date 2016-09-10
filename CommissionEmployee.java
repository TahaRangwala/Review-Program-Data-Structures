import BreezySwing.Format;

public class CommissionEmployee extends Employee{
	
	private double fixedSalary;
	private double salesMade;
	private double finalSalary;

	public CommissionEmployee(String Name, String idNumber, double fixedSalary, double salesMade) {
		super(Name, idNumber);
		this.fixedSalary = fixedSalary;
		this.salesMade = salesMade;
		finalSalary = fixedSalary + 0.05 * salesMade;
	}
	
	public double getFixedSalary(){
		return fixedSalary;
	}
	
	public double getSalesMade(){
		return salesMade;
	}
	
	public double getFinalSalary(){
		return finalSalary;
	}

	@Override
	public String Print() {
		String Output =  Format.justify('l', "Name", 15) + Format.justify('l', "ID Number", 15) + 
		Format.justify('l', "Fixed Salary",15) + Format.justify('l', "Sales Made", 15) +
		Format.justify('l', "Total Salary", 15) + "\n";
		Output +=  Format.justify('l', getName(), 15) + Format.justify('l', getIDNumber(), 15) + 
		Format.justify('l', "$" + String.format("$%.2f", fixedSalary),15) + 
		Format.justify('l', "$" + String.format("$%.2f", salesMade), 15) + 
		Format.justify('l', "$" + String.format("$%.2f", finalSalary), 15) + "\n";
		return Output;
	}

	public static void checkCommissionEmployee(String Name, String idNumber, double fixedSalary, double salesMade){
		if(Name == ""){
			throw new IllegalArgumentException("Please Input the Correct Name For A Commision Employee!");
		}
		else if(idNumber == "" || idNumber.length() != 6){
			throw new IllegalArgumentException("Please Input the Correct ID Number For A Commision Employee!");
		}
		else if(fixedSalary < 0){
			throw new IllegalArgumentException("Please Input the Correct HourlyWage For A Commission Employee!");
		}
		else if(salesMade < 0){
			throw new IllegalArgumentException("Please Input the Correct Sales Made For A Commission Employee!");
		}
	}
	
}
