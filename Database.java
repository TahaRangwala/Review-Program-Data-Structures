
public class Database {
	
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
	
}
