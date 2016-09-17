/*Name: Taha Rangwala
 * Date: September 15, 2016
 * Purpose: The purpose of this abstract class is to store all of the information for the employees, since all
 * of the employees in this program are similar in many ways, but unique because of salary. This class also has an
 * abstract method that each subclass uses, and it is unique to that subclass.
 */

import java.io.Serializable;//imports elements needed for serializable

//Employee class header
public abstract class Employee implements Comparable, Serializable{

	//Declare private instance variables
	private String Name;
	private String idNumber;
	private double fixedSalary;
	private double finalSalary;
	
	//Constructor method that initializes private instance variables
	public Employee(String Name, String idNumber, double fixedSalary){
		this.Name = Name;
		this.idNumber = idNumber;
		this.fixedSalary = fixedSalary;
	}
	
	/*Purpose: This method returns the name of an individual employee
	 * @return This method returns a string value of the name of an employee
	 */
	public String getName(){
		return Name;
	}
	
	/*Purpose: This method returns the id number of an individual employee
	 * @return This method returns a string value of the id number of an employee
	 */
	public String getIDNumber(){
		return idNumber;
	}
	
	/*Purpose: This method returns the fixed salary of an individual employee
	 * @return This method returns a double value of the fixed salary of an employee
	 */
	public double getFixedSalary(){
		return fixedSalary;
	}
	
	/*Purpose: This method sets the final total salary of an employee
	 * @param finalSalary This is the final total salary of an employee that is sent from the sub classes
	 */
	public void setFinalSalary(double finalSalary){
		this.finalSalary = finalSalary;
	}
	
	/*Purpose: This method returns the final total salary of an individual employee
	 * @return This method returns a double value of the final total salary of an employee
	 */
	public double getFinalSalary(){
		return finalSalary;
	}

	/*Purpose: This method compares two names of employees in order to determine which one comes first alphabetically
	 * @param O This is the object that is passed in which is an employee
	 * @return This method returns an integer value which tells which employee comes first alphabetically
	 */
	public int compareTo(Object O) {
		return getName().compareTo(((Employee) O).getName());
	}
	
	//Purpose: This is an abstract method that calculates the final total salary of each employee 
	public abstract void calculateFinalSalary();
	
	/*Purpose: this method error checks the name, id number, and fixed salary for each employee
	 * @param Name This is the name of the employee
	 * @param idNumber This is the id number of the employee
	 * @param fixedSalary This is the fixed salary of the employee
	 */
	public static void checkEmployees(String Name, String idNumber, double fixedSalary){
		if(Name.equals("")){
			throw new IllegalArgumentException("Please Input the Correct Name For An Employee!");
		}
		else if(idNumber.equals("")|| idNumber.length() != 6){
			throw new IllegalStateException("Please Input the Correct ID Number For An Employee!");
		}
		else if(fixedSalary < 0){
			throw new ArithmeticException("Please Input the Correct Weekly Salary For An Employee!");
		}
	}
	
}
