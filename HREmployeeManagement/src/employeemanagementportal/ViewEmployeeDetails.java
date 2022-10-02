package employeemanagementportal;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.EmployeeDetails;
import model.EmployeeDirectory;

import javax.swing.JScrollPane;

public class ViewEmployeeDetails extends JPanel {
	private JTable tblEmployeeData;
	
	EmployeeDirectory employeeDirectory;

	/**
	 * Create the panel.
	 */
	public ViewEmployeeDetails(EmployeeDirectory employeeDirectory) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Employee Detail");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(186, 0, 212, 27);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 620, 238);
		add(scrollPane);
		
		tblEmployeeData = new JTable();
		tblEmployeeData.setBackground(new Color(255, 255, 255));
		tblEmployeeData.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Employee ID", "Email Address", "Phone Number", "Position", "Level", "Team Info", "Start Date", "Age"
			}
		));
		scrollPane.setViewportView(tblEmployeeData);
		
		 this.employeeDirectory = employeeDirectory;
		 
		 populateTabel();

	}

	private void populateTabel() {
		DefaultTableModel model = (DefaultTableModel) tblEmployeeData.getModel();
		
		for (EmployeeDetails ed: employeeDirectory.getEmployeeDirectory()) {
			Object[] row = new Object[9];
			
			row[0] = ed.getName();
			row[1] = ed.getEmployeeId();
			row[2] = ed.getContactInfo().getEmailId();
			row[3] = ed.getContactInfo().getCellPhoneNumber();
			row[4] = ed.getPositionTitle();
			row[5] = ed.getLevel();
			row[6] = ed.getTeamInfo();
			row[7] = ed.getStartDate();
			row[8] = ed.getAge();
			
			model.addRow(row);
			
		}
		
	}
}
