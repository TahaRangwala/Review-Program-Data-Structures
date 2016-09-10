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
		return Format.justify('l', getName(), 15) + Format.justify('l', getIDNumber(), 15) + 
		Format.justify('l', "$" + String.format("$%.2f", fixedSalary),15) + 
		Format.justify('l', "$" + String.format("$%.2f", salesMade), 15) + 
		Format.justify('l', "$" + String.format("$%.2f", finalSalary), 15) + "\n";
	}

	public static void checkCommissionEmployee(String Name, String idNumber, double fixedSalary, double salesMade){
		if(Name == ""){
			throw new IllegalArgumentException("Please Input the Correct Name For A Commission Employee!");
		}
		else if(idNumber == "" || idNumber.length() != 6){
			throw new IllegalArgumentException("Please Input the Correct ID Number For A Commission Employee!");
		}
		else if(fixedSalary < 0){
			throw new IllegalArgumentException("Please Input the Correct Fixed Salary For A Commission Employee!");
		}
		else if(salesMade < 0){
			throw new IllegalArgumentException("Please Input the Correct Sales Made For A Commission Employee!");
		}
	}
	
}
