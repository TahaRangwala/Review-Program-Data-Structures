/*Name: Taha Rangwala
 * Date: September 15, 2016
 * Purpose: The purpose of this class is the store all of the information for the part time employee, including instance variables and
 * methods that are unique to the part time employee. It also calculates the final total salary of a part time employee
 */

import BreezySwing.Format;//allows for more formatting options

//PartTimeEmployee class header
public class PartTimeEmployee extends Employee{

	//Declaring private instance variables
	private int hoursWorked;
	
	//Constructor method to initialize instance variables
	public PartTimeEmployee(String Name, String idNumber, double hourlyWage, int hoursWorked) {
		super(Name,idNumber,hourlyWage);
		this.hoursWorked = hoursWorked;
		calculateFinalSalary();
	}
	
	/*Purpose: This methods returns the number of hours a part time employee worked
	 * @return This method returns an integer value of the number of hours a part time employee worked
	 */
	public int getHoursWorked(){
		return hoursWorked;
	}

	/*Purpose: This method returns all of the information for a part time employee
	 * @return This method returns a string value of the information for a part time employee
	 */
	public String toString() {
		return Format.justify('c', getName(), 15) + Format.justify('c', getIDNumber(), 15) + 
		Format.justify('c', String.format("$%.2f", getFixedSalary()),15) + Format.justify('c', hoursWorked, 15) + 
		Format.justify('c', String.format("$%.2f", getFinalSalary()), 15) + "\n";
	}
	
	//Purpose: This is a method that calculates the final total salary of each employee 
	public void calculateFinalSalary(){
		setFinalSalary(getFixedSalary() * hoursWorked);
	}
	
	/*Purpose: This method error checks the number of hours worked for the part time employee
	 * @param hoursWorked This is the number of hours the part time employee worked
	 */
	public static void checkPartTimeEmployee(int hoursWorked){
		if(hoursWorked < 0 || hoursWorked > 25){
			throw new SecurityException("Please Input the Correct Hours Worked For A Part Time Employee!");
		}
	}

}
