import java.io.*;

import BreezySwing.Format;

public class Database implements Serializable{
	
	private Employee[] allEmployees;
	private int employCount;
	
	public Database(){
		allEmployees = new Employee[25];
		employCount = 0;
	}
	
	public void addEmployee(Employee newEmployee){
		if(employCount >= 25)
			throw new IllegalArgumentException("No More Employees Can Be Added!");
		allEmployees[employCount] = newEmployee;
		employCount++;
	}
	
	public String getAllEmployees(){
		if(employCount > 0){
			SortAllEmployees();
			return getSalaryEmployees() + getCommissionEmployees() + getHourlyEmployees() + getPartTimeEmployees() +
			getTotalOfAll();
		}
		else return "There Is No Employee Information In The Employee Database!";
	}
	
	private String getSalaryEmployees(){
		String Output = "Salary Employees\n" + Format.justify('l', "Name", 15) + 
		Format.justify('l', "ID Number", 15) + Format.justify('l', "Total Salary",15) + "\n";
		for(int i = 0; i < employCount; i++){
			if(allEmployees[i] instanceof SalaryEmployee)
				Output += allEmployees[i].Print();
		}
		if(Output.equals("Salary Employees\n" + Format.justify('l', "Name", 15) + 
		Format.justify('l', "ID Number", 15) + Format.justify('l', "Total Salary",15) + "\n"))
			return "";
		return Output + "\n";
	}
	
	private String getCommissionEmployees(){
		String Output =  "Commission Employees\n" + Format.justify('l', "Name", 15) + 
		Format.justify('l', "ID Number", 15) + Format.justify('l', "Fixed Salary",15) + 
		Format.justify('l', "Sales Made", 15) + Format.justify('l', "Total Salary", 15) + "\n";
		for(int i = 0; i < employCount; i++){
			if(allEmployees[i] instanceof CommissionEmployee)
				Output += allEmployees[i].Print();
		}
		if(Output.equals("Commission Employees\n" + Format.justify('l', "Name", 15) + 
		Format.justify('l', "ID Number", 15) + Format.justify('l', "Fixed Salary",15) + 
		Format.justify('l', "Sales Made", 15) + Format.justify('l', "Total Salary", 15) + "\n"))
			return "";
		return Output + "\n";
	}
	
	private String getHourlyEmployees(){
		String Output =  "Hourly Employees\n" + Format.justify('l', "Name", 15) + Format.justify('l', "ID Number", 15) + 
		Format.justify('l', "Hourly Wage",15) + Format.justify('l', "Hours Worked", 15) +
		Format.justify('l', "Total Salary", 15) + "\n";
		for(int i = 0; i < employCount; i++){
			if(allEmployees[i] instanceof HourlyEmployee && !(allEmployees[i] instanceof PartTimeEmployee))
				Output += allEmployees[i].Print();
		}
		if(Output.equals( "Hourly Employees\n" + Format.justify('l', "Name", 15) + Format.justify('l', "ID Number", 15) + 
		Format.justify('l', "Hourly Wage",15) + Format.justify('l', "Hours Worked", 15) +
		Format.justify('l', "Total Salary", 15) + "\n"))
			return "";
		return Output + "\n";
	}
	
	private String getPartTimeEmployees(){
		String Output =  "Part Time Employees\n" + Format.justify('l', "Name", 15) + Format.justify('l', "ID Number", 15) + 
		Format.justify('l', "Hourly Wage",15) + Format.justify('l', "Hours Worked", 15) +
		Format.justify('l', "Total Salary", 15) + "\n";
		for(int i = 0; i < employCount; i++){
			if(allEmployees[i] instanceof PartTimeEmployee)
				Output += allEmployees[i].Print();
		}
		if(Output.equals("Part Time Employees\n" + Format.justify('l', "Name", 15) + Format.justify('l', "ID Number", 15) + 
		Format.justify('l', "Hourly Wage",15) + Format.justify('l', "Hours Worked", 15) +
		Format.justify('l', "Total Salary", 15) + "\n"))
			return "";
		return Output + "\n";
	}
	
	private String getTotalOfAll(){
		double Total = 0;
		for(int i = 0; i < employCount; i++){
			Total += allEmployees[i].getFinalSalary();
		}
		return "\nThe Total Salary of All Employees Combined is " + String.format("$%.2f", Total);
	}
	
	private void SortAllEmployees(){
		Employee itemToInsert;
		int j = 0;
		boolean stillLooking;
		for(int k = 0; k < employCount; k++){
			itemToInsert = allEmployees[k];
			j = k-1;
			stillLooking = true;
			while(j>=0){
				if(itemToInsert.compareTo(allEmployees[j]) < 0){
					allEmployees[j+1] = allEmployees[j]; 
					j--;
				}
				else{
					stillLooking = false;
					allEmployees[j+1] = itemToInsert;
				}
			}
		}
	}
	
}
