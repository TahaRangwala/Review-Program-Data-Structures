import BreezySwing.Format;

public class PartTimeEmployee extends HourlyEmployee{

	private double Salary;
	
	public PartTimeEmployee(String Name, String idNumber, double hourlyWage, int hoursWorked) {
		super(Name, idNumber,hourlyWage,hoursWorked);
		Salary = hourlyWage * hoursWorked;
	}
	
	public double getSalary(){
		return Salary;
	}

	@Override
	public String Print() {
		String Output =  Format.justify('l', "Name", 15) + Format.justify('l', "ID Number", 15) + 
		Format.justify('l', "Hourly Wage",15) + Format.justify('l', "Hours Worked", 15) +
		Format.justify('l', "Total Salary", 15) + "\n";
		Output +=  Format.justify('l', getName(), 15) + Format.justify('l', getIDNumber(), 15) + 
		Format.justify('l', "$" + String.format("$%.2f", getHourlyWage()),15) + Format.justify('l', getHoursWorked(), 15) + 
		Format.justify('l', "$" + String.format("$%.2f", Salary), 15) + "\n";
		return Output;
	}
	
	public static void checkPartTimeEmployee(String Name, String idNumber, double hourlyWage, double hoursWorked){
		if(Name == ""){
			throw new IllegalArgumentException("Please Input the Correct Name For A Part Time Employee!");
		}
		else if(idNumber == "" || idNumber.length() != 6){
			throw new IllegalArgumentException("Please Input the Correct ID Number For A Part Time Employee!");
		}
		else if(hourlyWage < 0){
			throw new IllegalArgumentException("Please Input the Correct Hourly Wage For A Part Time Employee!");
		}
		else if(hoursWorked < 0 || hoursWorked > 25){
			throw new IllegalArgumentException("Please Input the Correct Hours Worked For A Part Time Employee!");
		}
	}

}
