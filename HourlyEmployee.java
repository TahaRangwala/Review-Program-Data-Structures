import BreezySwing.Format;

public class HourlyEmployee extends Employee{
	
	private double hourlyWage;
	private int hoursWorked;
	private double finalSalary;

	public HourlyEmployee(String Name, String idNumber, double hourlyWage, int hoursWorked) {
		super(Name, idNumber);
		this.hourlyWage = hourlyWage;
		this.hoursWorked = hoursWorked;
		if(hoursWorked > 40)
			finalSalary = (hourlyWage * hoursWorked) + ((hourlyWage * 1.5) * (hoursWorked - 40));
		else finalSalary = (hourlyWage * hoursWorked);
	}
	
	public double getHourlyWage(){
		return hourlyWage;
	}
	
	public int getHoursWorked(){
		return hoursWorked;
	}
	
	public double getFinalSalary(){
		return finalSalary;
	}

	public String Print() {
		return Format.justify('l', getName(), 15) + Format.justify('l', getIDNumber(), 15) + 
		Format.justify('l', String.format("$%.2f", hourlyWage),15) + Format.justify('l', hoursWorked, 15) + 
		Format.justify('l', String.format("$%.2f", finalSalary), 15) + "\n";
	}
	
	public static void checkHourlyEmployee(String Name, String idNumber, double hourlyWage, double hoursWorked){
		if(Name.equals("")){
			throw new IllegalArgumentException("Please Input the Correct Name For A Hourly Employee!");
		}
		else if(idNumber.equals("")|| idNumber.length() != 6){
			throw new IllegalArgumentException("Please Input the Correct ID Number For A Hourly Employee!");
		}
		else if(hourlyWage < 0){
			throw new IllegalArgumentException("Please Input the Correct Hourly Wage For A Hourly Employee!");
		}
		else if(hoursWorked < 0){
			throw new IllegalArgumentException("Please Input the Correct Hours Worked For A Hourly Employee!");
		}
	}

}
