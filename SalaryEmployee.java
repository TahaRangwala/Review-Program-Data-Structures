/*Name: Taha Rangwala
 * Date: September 15, 2016
 * Purpose: The purpose of this subclass of the employee class is to carry all of the information for the salaried 
 * employees, and it also calculates the final total salary of salaried employee and has a toString method to output
 * all of the information for salaried employees
 */

import BreezySwing.Format;//allows for more formatting options

//SalaryEmployee class header
public class SalaryEmployee extends Employee{

	//Constructor method that initializes private instance variables
	public SalaryEmployee(String Name, String idNumber, double weeklySalary) {
		super(Name, idNumber, weeklySalary);
		calculateFinalSalary();
	}
	
	/*Purpose: This method returns all of the information for a salaried employee
	 * @return This method returns a string value of the information for an individual salary employee
	 */
	public String toString() {
		return Format.justify('c', getName(), 15) + Format.justify('c', getIDNumber(), 15) + 
		Format.justify('c', String.format("$%.2f", getFinalSalary()),15) + "\n";
	}
	
	//Purpose: This is a method that calculates the final total salary of each employee 
	public void calculateFinalSalary(){
		setFinalSalary(getFixedSalary());
	}
	
}

