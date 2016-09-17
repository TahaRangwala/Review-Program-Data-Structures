/*Name: Taha Rangwala
 * Date: September 15, 2016
 * Purpose: The purpose of this class is to take all the information from all the other classes
 * and do some calculations and relay them back to the gui class for the user to see. This class essentially
 * holds all the information that the user wants to see.
 */

import java.io.*;//allows the user to implement serializable

import BreezySwing.Format;//allows the user to have more formatting options

//EmployDatabase class header
public class EmployDatabase implements Serializable{
	
	//Declaring private instance variables
	private Employee[] allEmployees;
	private int employCount;
	
	//Constructor method to initialize instance variables
	public EmployDatabase(){
		allEmployees = new Employee[25];
		employCount = 0;
	}
	
	/*Purpose: The purpose of this method is to add employees into the employee array
	 * @param newEmployee This is a new employee that the user has inputted into the program
	 */
	public void addEmployee(Employee newEmployee){
		if(employCount >= 25)
			throw new IllegalArgumentException("No More Employees Can Be Added!");
		allEmployees[employCount] = newEmployee;
		employCount++;
	}
	
	/*Purpose: This method outputs all of the employee information back to the user
	 * @return This method returns a string value of all of the employee information
	 */
	public String toString(){
		if(employCount > 0){
			allEmployees = (Employee[]) SortSearch.insertionSort(allEmployees, employCount);
			return getSalaryEmployees() + getCommissionEmployees() + getHourlyEmployees() + getPartTimeEmployees() +
			getTotalOfAll();
		}
		else return "There Is No Employee Information In The Employee Database!";
	}
	
	/*Purpose: This method outputs all of the salary employee information
	 * @return This method returns a string value of all of the salary employee information
	 */
	private String getSalaryEmployees(){
		double Total = 0;
		String Output = "Salary Employees\n" + Format.justify('c', "Name", 15) + 
		Format.justify('c', "ID Number", 15) + Format.justify('c', "Total Salary",15) + "\n";
		for(int i = 0; i < employCount; i++){
			if(allEmployees[i] instanceof SalaryEmployee){
				Output += allEmployees[i].toString();
				Total += allEmployees[i].getFinalSalary();
			}
		}
		if(Output.equals("Salary Employees\n" + Format.justify('c', "Name", 15) + 
		Format.justify('c', "ID Number", 15) + Format.justify('c', "Total Salary",15) + "\n"))
			return "";
		return Output + "\nSalary Employee Total: " + String.format("$%.2f", Total) + "\n";
	}
	
	/*Purpose: This method outputs all of the commission employee information
	 * @return This method returns a string value of all of the commission employee information
	 */
	private String getCommissionEmployees(){
		double Total = 0;
		String Output =  "\nCommission Employees\n" + Format.justify('c', "Name", 15) + 
		Format.justify('c', "ID Number", 15) + Format.justify('c', "Fixed Salary",15) + 
		Format.justify('c', "Sales Made", 15) + Format.justify('c', "Total Salary", 15) + "\n";
		for(int i = 0; i < employCount; i++){
			if(allEmployees[i] instanceof CommissionEmployee){
				Output += allEmployees[i].toString();
				Total += allEmployees[i].getFinalSalary();
			}
		}
		if(Output.equals("\nCommission Employees\n" + Format.justify('c', "Name", 15) + 
		Format.justify('c', "ID Number", 15) + Format.justify('c', "Fixed Salary",15) + 
		Format.justify('c', "Sales Made", 15) + Format.justify('c', "Total Salary", 15) + "\n"))
			return "";
		return Output + "\nCommission Employee Total: " + String.format("$%.2f", Total) + "\n";
	}
	
	/*Purpose: This method outputs all of the hourly employee information
	 * @return This method returns a string value of all of the hourly employee information
	 */
	private String getHourlyEmployees(){
		double Total = 0;
		String Output =  "\nHourly Employees\n" + Format.justify('c', "Name", 15) + Format.justify('c', "ID Number", 15) + 
		Format.justify('c', "Hourly Wage",15) + Format.justify('c', "Hours Worked", 15) +
		Format.justify('c', "Total Salary", 15) + "\n";
		for(int i = 0; i < employCount; i++){
			if(allEmployees[i] instanceof HourlyEmployee){
				Output += allEmployees[i].toString();
				Total += allEmployees[i].getFinalSalary();
			}
		}
		if(Output.equals( "\nHourly Employees\n" + Format.justify('c', "Name", 15) + Format.justify('c', "ID Number", 15) + 
		Format.justify('c', "Hourly Wage",15) + Format.justify('c', "Hours Worked", 15) +
		Format.justify('c', "Total Salary", 15) + "\n"))
			return "";
		return Output +  "\nHourly Employee Total: " + String.format("$%.2f", Total) + "\n";
	}
	
	/*Purpose: This method outputs all of the part time employee information
	 * @return This method returns a string value of all of the part time employee information
	 */
	private String getPartTimeEmployees(){
		double Total = 0;
		String Output =  "\nPart Time Employees\n" + Format.justify('c', "Name", 15) + Format.justify('c', "ID Number", 15) + 
		Format.justify('c', "Hourly Wage",15) + Format.justify('c', "Hours Worked", 15) +
		Format.justify('c', "Total Salary", 15) + "\n";
		for(int i = 0; i < employCount; i++){
			if(allEmployees[i] instanceof PartTimeEmployee){
				Output += allEmployees[i].toString();
				Total += allEmployees[i].getFinalSalary();
			}
		}
		if(Output.equals("\nPart Time Employees\n" + Format.justify('c', "Name", 15) + Format.justify('c', "ID Number", 15) + 
		Format.justify('c', "Hourly Wage",15) + Format.justify('c', "Hours Worked", 15) +
		Format.justify('c', "Total Salary", 15) + "\n"))
			return "";
		return Output + "\nPartTime Employee Total: " + String.format("$%.2f", Total) + "\n";
	}
	
	/*Purpose: This method gets the total salary of all of the employees combined
	 * @return This method returns a string value of the total salary of all employees combined
	 */
	private String getTotalOfAll(){
		double Total = 0;
		for(int i = 0; i < employCount; i++){
			Total += allEmployees[i].getFinalSalary();
		}
		return "\nThe Total Salary of All Employees Combined is " + String.format("$%.2f", Total);
	}
	
}
