package model;

import java.util.ArrayList;

public class EmployeeDirectory {
	
	private ArrayList<EmployeeDetails> employeeDirectory;
	
	public EmployeeDirectory() {
		this.employeeDirectory = new ArrayList<EmployeeDetails>();
	}

	public ArrayList<EmployeeDetails> getEmployeeDirectory() {
		return employeeDirectory;
	}

	public void setEmployeeDirectory(ArrayList<EmployeeDetails> employeeDirectory) {
		this.employeeDirectory = employeeDirectory;
	}
	
	

}
