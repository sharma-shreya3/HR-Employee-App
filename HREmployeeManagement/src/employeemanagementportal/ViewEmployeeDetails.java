package employeemanagementportal;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.EmployeeDetails;
import model.EmployeeDirectory;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;

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
		scrollPane.setBounds(10, 37, 631, 224);
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
		 
		 JButton btnNewButton = new JButton("Delete Record");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		int selectedRowIndex = tblEmployeeData.getSelectedRow();
		 		
		 		if (selectedRowIndex < 0) {
		 			JOptionPane.showMessageDialog(null,"Please Select a row to perform delete operation");
		 			return;
		 		}
		 		
		 		DefaultTableModel model = (DefaultTableModel)tblEmployeeData.getModel();
		 		EmployeeDetails selectedEmployee = (EmployeeDetails) model.getValueAt(selectedRowIndex, 0);
		 		
		 		employeeDirectory.deleteEmployeeData(selectedEmployee);
		 		System.out.print(employeeDirectory.getEmployeeDirectory());
		 		JOptionPane.showMessageDialog(null,"Details of " + selectedEmployee.getName() + " is deleted successfully");
		 		populateTable();
		 	}
		 });
		 btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 btnNewButton.setBounds(504, 271, 137, 21);
		 add(btnNewButton);
		 
		 JButton btnNewButton_1 = new JButton("Update Record");
		 btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 btnNewButton_1.setBounds(363, 271, 137, 21);
		 add(btnNewButton_1);
		 
		 JLabel lblUpdate = new JLabel("Update Employee Details");
		 lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		 lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		 lblUpdate.setBounds(228, 311, 228, 27);
		 add(lblUpdate);
		 
		 JPanel panel = new JPanel();
		 panel.setBounds(10, 347, 631, 273);
		 add(panel);
		 panel.setLayout(new FormLayout(new ColumnSpec[] {
		 		FormSpecs.RELATED_GAP_COLSPEC,
		 		FormSpecs.DEFAULT_COLSPEC,
		 		FormSpecs.RELATED_GAP_COLSPEC,
		 		FormSpecs.DEFAULT_COLSPEC,
		 		FormSpecs.RELATED_GAP_COLSPEC,
		 		FormSpecs.DEFAULT_COLSPEC,
		 		FormSpecs.RELATED_GAP_COLSPEC,
		 		FormSpecs.DEFAULT_COLSPEC,
		 		FormSpecs.RELATED_GAP_COLSPEC,
		 		FormSpecs.DEFAULT_COLSPEC,
		 		FormSpecs.RELATED_GAP_COLSPEC,
		 		FormSpecs.DEFAULT_COLSPEC,
		 		FormSpecs.RELATED_GAP_COLSPEC,
		 		FormSpecs.DEFAULT_COLSPEC,
		 		FormSpecs.RELATED_GAP_COLSPEC,
		 		ColumnSpec.decode("default:grow"),
		 		FormSpecs.RELATED_GAP_COLSPEC,
		 		FormSpecs.DEFAULT_COLSPEC,
		 		FormSpecs.RELATED_GAP_COLSPEC,
		 		FormSpecs.DEFAULT_COLSPEC,
		 		FormSpecs.RELATED_GAP_COLSPEC,
		 		FormSpecs.DEFAULT_COLSPEC,
		 		FormSpecs.RELATED_GAP_COLSPEC,
		 		FormSpecs.DEFAULT_COLSPEC,
		 		FormSpecs.RELATED_GAP_COLSPEC,
		 		FormSpecs.DEFAULT_COLSPEC,},
		 	new RowSpec[] {
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,}));
		 
		 JLabel lblNewLabel_2 = new JLabel("New label");
		 panel.add(lblNewLabel_2, "6, 2, 10, 7");
		 
		 populateTable();

	}

	private void populateTable() {
		DefaultTableModel model = (DefaultTableModel) tblEmployeeData.getModel();
		model.setRowCount(0);
		
		for (EmployeeDetails ed: employeeDirectory.getEmployeeDirectory()) {
			Object[] row = new Object[9];
			
			row[0] = ed;
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
