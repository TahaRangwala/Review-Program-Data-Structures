import BreezySwing.Format;

public class SalaryEmployee extends Employee{

	private double weeklySalary;
	
	public SalaryEmployee(String Name, String idNumber, double weeklySalary) {
		super(Name, idNumber);
		this.weeklySalary = weeklySalary;
	}

	@Override
	public int compareTo(Object O) {
		return getName().compareTo(((Employee) O).getName());
	}

	@Override
	public String Print() {
		String Output =  Format.justify('l', "Name", 15) + Format.justify('l', "ID Number", 15) + 
		Format.justify('l', "Total Salary",15) + "\n";
		Output +=  Format.justify('l', getName(), 15) + Format.justify('l', getIDNumber(), 15) + 
		Format.justify('l', "Total Salary",15) + "\n\n";
		return Output;
	}
	

}
