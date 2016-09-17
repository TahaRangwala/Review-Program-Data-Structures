/*Name: Taha Rangwala
 * Date: September 15, 2016
 * Purpose: The purpose of this class is the store all of the information for the hourly employee, including instance variables and
 * methods that are unique to the hourly employee. It also calculates the final total salary of a hourly employee
 */

import BreezySwing.Format;//allows for more formatting options

//HourlyEmployee class header
public class HourlyEmployee extends Employee{
	
	//Declaring private instance variables
	private int hoursWorked;

	//Constructor method that initializes private instance variables
	public HourlyEmployee(String Name, String idNumber, double hourlyWage, int hoursWorked) {
		super(Name, idNumber, hourlyWage);
		this.hoursWorked = hoursWorked;
		calculateFinalSalary();
	}
	
	/*Purpose: This methods returns the number of hours a hourly employee worked
	 * @return This method returns an integer value of the number of hours a hourly employee worked
	 */
	public int getHoursWorked(){
		return hoursWorked;
	}

	/*Purpose: This method returns all of the information for a hourly employee
	 * @return This method returns a string value of the information for a hourly employee
	 */
	public String toString() {
		return Format.justify('c', getName(), 15) + Format.justify('c', getIDNumber(), 15) + 
		Format.justify('c', String.format("$%.2f", getFixedSalary()),15) + Format.justify('c', hoursWorked, 15) + 
		Format.justify('c', String.format("$%.2f", getFinalSalary()), 15) + "\n";
	}
	
	//Purpose: This is a method that calculates the final total salary of each employee 
	public void calculateFinalSalary(){
		if(hoursWorked > 40)
			setFinalSalary((getFixedSalary() * hoursWorked) + ((getFixedSalary() * 1.5) * (hoursWorked - 40)));
		else setFinalSalary(getFixedSalary() * hoursWorked);
	}
	
	/*Purpose: The purpose of this method is to error check the hours an hourly employee worked
	 * @param hoursWorked This is the number of hours the hourly employee worked
	 */
	public static void checkHourlyEmployee(double hoursWorked){
		if(hoursWorked < 0){
			throw new SecurityException("Please Input the Correct Hours Worked For A Hourly Employee!");
		}
	}


}
