/*Name: Taha Rangwala
 * Date: September 15, 2016
 * Purpose: The purpose of the gui class is to allow the user to use the program. This class takes all of the information
 * from other classes and allows the user to see them through buttons and output and input fields. This allows shows a friendly 
 * interface that the user can use in order to complete tasks with this program.
 */

import BreezySwing.*;//allows the user to use window objects

import javax.swing.*;//allows the user to use window objects

import java.awt.Color;//allows the user to use colors

//GUI class header
public class GUI extends GBFrame{
	
	//Declaring private instance variables
	private EmployDatabase Information;
	//Window objects
	private JLabel nameLabel, idLabel, fixedSalaryLabel, salesLabel, hoursLabel;
	private JTextField nameField, idField;
	private DoubleField fixedSalaryField, salesField;
	private IntegerField hoursField;
	private JTextArea outputArea;
	private JButton salaryInput, commissionedInput, hourlyInput, partTimeInput, outputAll, clearData, saveAndClose;
	
	//Constructor method to initialize instance variables and window objects
	public GUI(){
	
		//Initializing window objects
		nameLabel = addLabel("Name",1,1,1,1);
		nameField = addTextField("",1,2,1,1);
		idLabel = addLabel("ID Number",1,3,1,1);
		idField = addTextField("",1,4,1,1);
		fixedSalaryLabel = addLabel("Weekly/Hourly Salary",2,1,1,1);
		fixedSalaryField = addDoubleField(0.01,2,2,1,1);
		salesLabel = addLabel("Sales Made",2,3,1,1);
		salesField = addDoubleField(0.01,2,4,1,1);
		hoursLabel = addLabel("Hours Worked",3,1,1,1);
		hoursField = addIntegerField(0,3,2,1,1);
		clearData = addButton("Clear All Data",3,4,1,1);
		salaryInput = addButton("Salary Employee Input",4,1,1,1);
		commissionedInput = addButton("Commissioned Employee Input",4,2,1,1);
		hourlyInput = addButton("Hourly Employee Input",4,3,1,1);
		partTimeInput = addButton("Part Time Employee Input",4,4,1,1);
		outputArea = addTextArea("",5,1,4,1);
		outputAll = addButton("Output All Information",6,2,1,1);
		saveAndClose = addButton("Save and Exit",6,3,1,1);
		outputArea.setEditable(false);
		
		//Checking for files that may exist
		try{
			Information = (EmployDatabase)FileInputOutput.getFile();
			outputArea.setText(Information.toString());
		}
		catch(Exception E){
			Information = new EmployDatabase();
			outputArea.setText("No Files Exist In The Database!");
		}
		
	}
	
	/*Purpose: The purpose of this method is to allow the user to use buttons. When a user presses a button, a specific
	 * task is performed, whether it is inputting or outputting something in any output box, each button performs something
	 * important for the function of the program.
	 * @param buttonObj This button object allows the program to determine which button has been clicked
	 * and determine which task must be completed
	 */
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == clearData){//deletes file
			FileInputOutput.Delete("EmployeeData.dat");
			outputArea.setText("All Data Has Been Cleared!");
			Information = new EmployDatabase();
		}
		else if(buttonObj == salaryInput){//inputs salary employee
			if(checkNumberValues()){
				try{
					Employee.checkEmployees(nameField.getText(), idField.getText(), fixedSalaryField.getNumber());
					Information.addEmployee(new SalaryEmployee(nameField.getText(), idField.getText(), fixedSalaryField.getNumber()));
					nameField.setText("");
					idField.setText("");
					fixedSalaryField.setNumber(0.01);
					salesField.setNumber(0.01);
					hoursField.setNumber(0);
					nameField.grabFocus();
				}
				catch(IllegalArgumentException E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
					nameField.setText("");
					nameField.grabFocus();
				}
				catch(IllegalStateException E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
					idField.setText("");
					idField.grabFocus();
				}
				catch(ArithmeticException E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
					fixedSalaryField.setNumber(0.01);
					fixedSalaryField.selectAll();
					fixedSalaryField.grabFocus();
				}
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Make Sure All Number Values Are Valid Numbers!", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		else if(buttonObj == commissionedInput){//inputs commission employee
			if(checkNumberValues()){
				try{
					Employee.checkEmployees(nameField.getText(), idField.getText(), fixedSalaryField.getNumber());
					CommissionEmployee.checkCommissionEmployee(salesField.getNumber());
					Information.addEmployee(new CommissionEmployee(nameField.getText(), idField.getText(), fixedSalaryField.getNumber(),salesField.getNumber()));
					nameField.setText("");
					idField.setText("");
					fixedSalaryField.setNumber(0.01);
					salesField.setNumber(0.01);
					hoursField.setNumber(0);
					nameField.grabFocus();
				}
				catch(IllegalArgumentException E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
					nameField.setText("");
					nameField.grabFocus();
				}
				catch(IllegalStateException E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
					idField.setText("");
					idField.grabFocus();
				}
				catch(ArithmeticException E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
					fixedSalaryField.setNumber(0.01);
					fixedSalaryField.selectAll();
					fixedSalaryField.grabFocus();
				}
				catch(SecurityException E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
					salesField.setNumber(0.01);
					salesField.selectAll();
					salesField.grabFocus();
				}
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Make Sure All Number Values Are Valid Numbers!", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		else if(buttonObj == hourlyInput){//inputs hourly employee
			if(checkNumberValues()){
				try{
					Employee.checkEmployees(nameField.getText(), idField.getText(), fixedSalaryField.getNumber());
					HourlyEmployee.checkHourlyEmployee(hoursField.getNumber());
					Information.addEmployee(new HourlyEmployee(nameField.getText(), idField.getText(), fixedSalaryField.getNumber(), hoursField.getNumber()));
					nameField.setText("");
					idField.setText("");
					fixedSalaryField.setNumber(0.01);
					salesField.setNumber(0.01);
					hoursField.setNumber(0);
					nameField.grabFocus();
				}
				catch(IllegalArgumentException E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
					nameField.setText("");
					nameField.grabFocus();
				}
				catch(IllegalStateException E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
					idField.setText("");
					idField.grabFocus();
				}
				catch(ArithmeticException E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
					fixedSalaryField.setNumber(0.01);
					fixedSalaryField.selectAll();
					fixedSalaryField.grabFocus();
				}
				catch(SecurityException E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
					hoursField.setNumber(0);
					hoursField.selectAll();
					hoursField.grabFocus();
				}
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Make Sure All Number Values Are Valid Numbers!", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		else if(buttonObj == partTimeInput){//inputs part time employee
			if(checkNumberValues()){
				try{
					Employee.checkEmployees(nameField.getText(), idField.getText(), fixedSalaryField.getNumber());
					PartTimeEmployee.checkPartTimeEmployee(hoursField.getNumber());
					Information.addEmployee(new PartTimeEmployee(nameField.getText(), idField.getText(), fixedSalaryField.getNumber(), hoursField.getNumber()));
					nameField.setText("");
					idField.setText("");
					fixedSalaryField.setNumber(0.01);
					salesField.setNumber(0.01);
					hoursField.setNumber(0);
					nameField.grabFocus();
				}
				catch(IllegalArgumentException E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
					nameField.setText("");
					nameField.grabFocus();
				}
				catch(IllegalStateException E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
					idField.setText("");
					idField.grabFocus();
				}
				catch(ArithmeticException E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
					fixedSalaryField.setNumber(0.01);
					fixedSalaryField.selectAll();
					fixedSalaryField.grabFocus();
				}
				catch(SecurityException E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
					hoursField.setNumber(0);
					hoursField.selectAll();
					hoursField.grabFocus();
				}
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Make Sure All Number Values Are Valid Numbers!", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		else if(buttonObj == outputAll){//outputs all employee information
			outputArea.setText(Information.toString());
		}
		else if(buttonObj == saveAndClose){//saves a file and closes the program
			FileInputOutput.write(Information);
			this.dispose();
		}
	}
	
	/*Purpose: This method makes sure that each double field or integer field has a correct number value in order for
	 * the program to function correctly.
	 * @return This returns a boolean value of true if all the number values are valid, otherwise it returns false if
	 * something is incorrect
	 */
	private boolean checkNumberValues(){
		if(!hoursField.isValidNumber()){
			hoursField.setNumber(0);
			hoursField.selectAll();
			hoursField.grabFocus();
			return false;
		}
		else if(!salesField.isValidNumber()){
			salesField.setNumber(0.01);
			salesField.selectAll();
			salesField.grabFocus();
			return false;
		}
		else if(!fixedSalaryField.isValidNumber()){
			fixedSalaryField.setNumber(0.01);
			fixedSalaryField.selectAll();
			fixedSalaryField.grabFocus();
			return false;
		}
		return true;
	}
	
	//Main method to set up the GUI
	public static void main (String [] args){
		GUI theMainGUI = new GUI();//GUI object
		theMainGUI.setSize(900,900);//size of the GUI interface
		theMainGUI.setTitle("Taha's Employee Data Program");//title of GUI interface
		theMainGUI.setVisible(true);//visibility of interface
		theMainGUI.setLocationRelativeTo(null);//Location is in center of screen
		theMainGUI.getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
	}
	
}
