
public abstract class Employee implements Comparable{

	private String Name;
	private String idNumber;
	
	public Employee(String Name, String idNumber){
		this.Name = Name;
		this.idNumber = idNumber;
	}
	
	public String getName(){
		return Name;
	}
	
	public String getIDNumber(){
		return idNumber;
	}
	
	public abstract String Print();
	
	public abstract int compareTo(Object O);
	
}
