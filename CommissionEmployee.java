/*Name: Taha Rangwala
 * Date: September 15, 2016
 * Purpose: The purpose of this class is to store all of the information for commission employees, including
 * private instance variables and methods that return things unique to the commission employee. It also calculates the
 * final total salary of a commission employee
 */

import BreezySwing.Format;//allows more formatting options

//CommissionEmployee class header
public class CommissionEmployee extends Employee{
	
	//Declaring private instance variables
	private double salesMade;

	//Constructor method that initializes private instance variables
	public CommissionEmployee(String Name, String idNumber, double fixedSalary, double salesMade) {
		super(Name, idNumber, fixedSalary);
		this.salesMade = salesMade;
		calculateFinalSalary();
	}
	
	/*Purpose: This method returns the sales the commission employee made
	 * @return This method returns a double value of the sales the commission employee made
	 */
	public double getSalesMade(){
		return salesMade;
	}
	
	/*Purpose: This method returns all of the information for a commission employee
	 * @return This method returns a string value of the information for an individual commission employee
	 */
	public String toString() {
		return Format.justify('c', getName(), 15) + Format.justify('c', getIDNumber(), 15) + 
		Format.justify('c', String.format("$%.2f", getFixedSalary()),15) + 
		Format.justify('c', String.format("$%.2f", salesMade), 15) + 
		Format.justify('c', String.format("$%.2f", getFinalSalary()), 15) + "\n";
	}
	
	//Purpose: This is a method that calculates the final total salary of each employee 
	public void calculateFinalSalary(){
		setFinalSalary(getFixedSalary() + (0.05 * salesMade));
	}
	
	/*Purpose: This error checks the sales made for the commission employee
	 * @param salesMade This is the sales that the commission employee made
	 */
	public static void checkCommissionEmployee(double salesMade){
		if(salesMade < 0){
			throw new SecurityException("Please Input the Correct Sales Made For A Commission Employee!");
		}
	}
	
}
