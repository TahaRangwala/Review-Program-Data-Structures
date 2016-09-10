import BreezySwing.*;
import javax.swing.*;

import java.awt.Color;

public class GUI extends GBFrame{
	
	private Database Information;
	private JLabel nameLabel, idLabel, fixedSalaryLabel, salesLabel, hoursLabel;
	private JTextField nameField, idField;
	private DoubleField fixedSalaryField, salesField;
	private IntegerField hoursField;
	private JTextArea outputArea;
	private JButton salaryInput, commissionedInput, hourlyInput, partTimeInput, outputAll, clearData, saveAndClose;
	
	public GUI(){
		
		Information = new Database();
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
		
	}
	
	public void buttonClicked(JButton buttonObj){
		if(buttonObj == clearData){
			
		}
		else if(buttonObj == salaryInput){
			if(checkNumberValues()){
				try{
					SalaryEmployee.checkSalaryEmployee(nameField.getText(), idField.getText(), fixedSalaryField.getNumber());
					Information.addEmployee(new SalaryEmployee(nameField.getText(), idField.getText(), fixedSalaryField.getNumber()));
				}
				catch(Exception E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Make Sure All Number Values Are Valid Numbers!", "Error Message", JOptionPane.ERROR_MESSAGE);
			
		}
		else if(buttonObj == commissionedInput){
			if(checkNumberValues()){
				try{
					CommissionEmployee.checkCommissionEmployee(nameField.getText(), idField.getText(), fixedSalaryField.getNumber(), salesField.getNumber());
					Information.addEmployee(new CommissionEmployee(nameField.getText(), idField.getText(), fixedSalaryField.getNumber(),salesField.getNumber()));
				}
				catch(Exception E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Make Sure All Number Values Are Valid Numbers!", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		else if(buttonObj == hourlyInput){
			if(checkNumberValues()){
				try{
					HourlyEmployee.checkHourlyEmployee(nameField.getText(), idField.getText(), fixedSalaryField.getNumber(), hoursField.getNumber());
					Information.addEmployee(new HourlyEmployee(nameField.getText(), idField.getText(), fixedSalaryField.getNumber(), hoursField.getNumber()));
				}
				catch(Exception E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Make Sure All Number Values Are Valid Numbers!", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		else if(buttonObj == partTimeInput){
			if(checkNumberValues()){
				try{
					PartTimeEmployee.checkPartTimeEmployee(nameField.getText(), idField.getText(), fixedSalaryField.getNumber(), hoursField.getNumber());
					Information.addEmployee(new PartTimeEmployee(nameField.getText(), idField.getText(), fixedSalaryField.getNumber(), hoursField.getNumber()));
				}
				catch(Exception E){
					JOptionPane.showMessageDialog(new JFrame(),E.getLocalizedMessage(), "Error Message", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
				JOptionPane.showMessageDialog(new JFrame(),"Make Sure All Number Values Are Valid Numbers!", "Error Message", JOptionPane.ERROR_MESSAGE);
		}
		else if(buttonObj == outputAll){
			
		}
		else if(buttonObj == saveAndClose){
			
		}
	}
	
	private boolean checkNumberValues(){
		return hoursField.isValidNumber() && fixedSalaryField.isValidNumber() && salesField.isValidNumber();
	}
	
	
	
	public static void main (String [] args){
		GUI theMainGUI = new GUI();//GUI object
		theMainGUI.setSize(900,500);//size of the GUI interface
		theMainGUI.setTitle("Taha's Employee Data Program");//title of GUI interface
		theMainGUI.setVisible(true);//visibility of interface
		theMainGUI.setLocationRelativeTo(null);//Location is in center of screen
		theMainGUI.getContentPane().setBackground(new Color(169,229,255));//background of GUI is light blue
	}
	
}
