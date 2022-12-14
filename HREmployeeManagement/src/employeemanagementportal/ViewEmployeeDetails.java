package employeemanagementportal;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.EmployeeDetails;
import model.EmployeeDirectory;

import javax.swing.JScrollPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.FlowLayout;

public class ViewEmployeeDetails extends JPanel {
	private JTable tblEmployeeData;
	
	EmployeeDirectory employeeDirectory;
	EmployeeDirectory viewEmployeeDirectory;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textEmpID;
	private JTextField textStartDate;
	private JTextField textLevel;
	private JTextField textTitle;
	private JTextField textPhoneNumber;
	private JTextField textEmail;
	private JTextField textTreamInfo;
	private ButtonGroup btnGroup;
	private JTextField searchEmpID;
	private JTextField searchEmail;
	private JTextField searchPhoneNumber;
	private JTextField searchName;
	private JRadioButton rdbtnFemale;
	private JTextField searchPosition;
	private JRadioButton rdbtnMale;
	private JButton btnUpdate;
	private String updateEmpID = null;
	private JLabel lblIcon;
	private boolean uniqueSearchFlag;
	private boolean generalSearchFlag;

	/**
	 * Create the panel.
	 */
	public ViewEmployeeDetails(EmployeeDirectory employeeDirectory) {
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Employee Detail");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(209, 0, 212, 27);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 176, 646, 160);
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
		 btnNewButton.setForeground(new Color(255, 255, 255));
		 btnNewButton.setBackground(new Color(116, 14, 41));
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
		 		JOptionPane.showMessageDialog(null,"Details of " + selectedEmployee.getName() + " is deleted successfully");
		 		populateTable(employeeDirectory.getEmployeeDirectory());
		 	}
		 });
		 btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 btnNewButton.setBounds(530, 346, 137, 21);
		 add(btnNewButton);
		 
		 JButton btnViewRecord = new JButton("View Record");
		 btnViewRecord.setForeground(new Color(255, 255, 255));
		 btnViewRecord.setBackground(new Color(172, 21, 63));
		 btnViewRecord.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		int selectedRowIndex = tblEmployeeData.getSelectedRow();
		 		if (selectedRowIndex < 0) {
		 			JOptionPane.showMessageDialog(null,"Please Select a row to View Employee Record");
		 			return;
		 		}
		 		
		 		DefaultTableModel model = (DefaultTableModel)tblEmployeeData.getModel();
		 		EmployeeDetails selectedEmployee = (EmployeeDetails) model.getValueAt(selectedRowIndex, 0);
		 		
		 		textName.setText(selectedEmployee.getName());
		 		textAge.setText(selectedEmployee.getAge());
		 		textEmail.setText(selectedEmployee.getContactInfo().getEmailId());
		 		textLevel.setText(selectedEmployee.getLevel());
		 		textPhoneNumber.setText(selectedEmployee.getContactInfo().getCellPhoneNumber());
		 		textStartDate.setText(selectedEmployee.getStartDate());
		 		textTitle.setText(selectedEmployee.getPositionTitle());
		 		textTreamInfo.setText(selectedEmployee.getTeamInfo());
		 		
		 		ImageIcon ii = new ImageIcon(selectedEmployee.getPhotosLink());
	            Image image = ii.getImage().getScaledInstance(lblIcon.getWidth(), lblIcon.getHeight(), Image.SCALE_SMOOTH);
	             
	            lblIcon.setIcon(new ImageIcon(image));
		 		
		 		if (selectedEmployee.getGender().equals("Female")) {
		 			rdbtnFemale.setSelected(true);
		 		} else {
		 			rdbtnMale.setSelected(true);;
		 		}
		 		
		 		btnUpdate.setEnabled(true);
		 		updateEmpID = selectedEmployee.getEmployeeId();
		 		
		 		
		 	}
		 });
		 btnViewRecord.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 btnViewRecord.setBounds(383, 346, 137, 21);
		 add(btnViewRecord);
		 
		 JLabel lblUpdate = new JLabel("Update Employee Details");
		 lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 15));
		 lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		 lblUpdate.setBounds(219, 376, 228, 27);
		 add(lblUpdate);
		 
		 JPanel updatePanel = new JPanel();
		 updatePanel.setBackground(new Color(232, 228, 233));
		 updatePanel.setBounds(21, 398, 646, 336);
		 add(updatePanel);
		 updatePanel.setLayout(new FormLayout(new ColumnSpec[] {
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
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,
		 		FormSpecs.RELATED_GAP_ROWSPEC,
		 		FormSpecs.DEFAULT_ROWSPEC,}));
		 
		 lblIcon = new JLabel("");
		 lblIcon.setBackground(new Color(228, 220, 228));
		 lblIcon.setFont(new Font("Tahoma", Font.PLAIN, 19));
		 updatePanel.add(lblIcon, "6, 2, 8, 8");
		 
		 JLabel lblName = new JLabel("Name");
		 lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 updatePanel.add(lblName, "14, 4, right, default");
		 
		 textName = new JTextField();
		 textName.setColumns(20);
		 updatePanel.add(textName, "16, 4, left, default");
		 
		 JLabel lblAge = new JLabel("Age");
		 lblAge.setHorizontalAlignment(SwingConstants.TRAILING);
		 lblAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 updatePanel.add(lblAge, "14, 6, right, default");
		 
		 textAge = new JTextField();
		 updatePanel.add(textAge, "16, 6, left, default");
		 textAge.setColumns(20);
		 
		 JLabel lblNewLabel_1 = new JLabel("Employee ID");
		 lblNewLabel_1.setHorizontalAlignment(SwingConstants.TRAILING);
		 lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 updatePanel.add(lblNewLabel_1, "14, 8, right, default");
		 
		 textEmpID = new JTextField();
		 updatePanel.add(textEmpID, "16, 8, left, default");
		 textEmpID.setColumns(20);
		 
		 JLabel lblNewLabel_3 = new JLabel("Gender");
		 lblNewLabel_3.setHorizontalAlignment(SwingConstants.TRAILING);
		 lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 updatePanel.add(lblNewLabel_3, "14, 10, right, default");
		 
		 rdbtnMale = new JRadioButton("Male");
		 rdbtnMale.setBackground(new Color(232, 228, 233));
		 updatePanel.add(rdbtnMale, "16, 10, left, default");
		 
		 rdbtnFemale  = new JRadioButton("Female");
		 rdbtnFemale.setBackground(new Color(232, 228, 233));
		 updatePanel.add(rdbtnFemale, "18, 10");
		 
		 btnGroup = new ButtonGroup();
		 btnGroup.add(rdbtnMale);
		 btnGroup.add(rdbtnFemale);
		 
		 JLabel lblNewLabel_4 = new JLabel("Start Date");
		 lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_4.setHorizontalAlignment(SwingConstants.TRAILING);
		 updatePanel.add(lblNewLabel_4, "14, 12, right, default");
		 
		 textStartDate = new JTextField();
		 updatePanel.add(textStartDate, "16, 12, left, default");
		 textStartDate.setColumns(20);
		 
		 JLabel lblNewLabel_5 = new JLabel("Level");
		 lblNewLabel_5.setHorizontalAlignment(SwingConstants.TRAILING);
		 lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 updatePanel.add(lblNewLabel_5, "14, 14, right, default");
		 
		 textLevel = new JTextField();
		 updatePanel.add(textLevel, "16, 14, left, default");
		 textLevel.setColumns(20);
		 
		 JLabel lblNewLabel_6 = new JLabel("Title");
		 lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_6.setHorizontalAlignment(SwingConstants.TRAILING);
		 updatePanel.add(lblNewLabel_6, "14, 16, right, top");
		 
		 textTitle = new JTextField();
		 updatePanel.add(textTitle, "16, 16, left, default");
		 textTitle.setColumns(20);
		 
		 JLabel lblNewLabel_7 = new JLabel("Phone Number");
		 lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 updatePanel.add(lblNewLabel_7, "14, 18, right, default");
		 
		 textPhoneNumber = new JTextField();
		 updatePanel.add(textPhoneNumber, "16, 18, left, default");
		 textPhoneNumber.setColumns(20);
		 
		 JLabel lblNewLabel_8 = new JLabel("Email");
		 lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 lblNewLabel_8.setHorizontalAlignment(SwingConstants.TRAILING);
		 updatePanel.add(lblNewLabel_8, "14, 20, right, default");
		 
		 textEmail = new JTextField();
		 updatePanel.add(textEmail, "16, 20, left, default");
		 textEmail.setColumns(20);
		 
		 JLabel lblNewLabel_9 = new JLabel("Team Info");
		 lblNewLabel_9.setHorizontalAlignment(SwingConstants.TRAILING);
		 lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 updatePanel.add(lblNewLabel_9, "14, 22, right, default");
		 
		 textTreamInfo = new JTextField();
		 updatePanel.add(textTreamInfo, "16, 22, left, default");
		 textTreamInfo.setColumns(20);
		 
		 JButton btnCancel = new JButton("Cancel");
		 btnCancel.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		btnUpdate.setEnabled(false);
		 		updateEmpID = null;
		 		clearUpdateTextFields();
		 	}
		 });
		 btnCancel.setBackground(new Color(192, 192, 192));
		 btnCancel.setForeground(new Color(64, 0, 64));
		 btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 updatePanel.add(btnCancel, "20, 22");
		 
		 btnUpdate = new JButton("Update Details");
		 btnUpdate.setEnabled(false);
		 btnUpdate.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		EmployeeDetails updateDetails = getEmployeeDetailByEmail(updateEmpID);
		 		
		 		String name = textName.getText();
				String age = textAge.getText();
				String gender = null;
				String startDate = textStartDate.getText();
				String level = textLevel.getText();
				String teamInfo = textTreamInfo.getText();
				String positionTitle = textTitle.getText();
				String phoneNumber = textPhoneNumber.getText();
				String email = textEmail.getText();
				
				if (rdbtnFemale.isSelected()) {
					gender = "Female";
				} else if (rdbtnMale.isSelected()) {
					gender = "Male";
				}
				
				String validateMsg = "";
				
				if (validateName(name)) {
					validateMsg = validateMsg + "Name field is invalid.";
				}
				if (age.isEmpty() || Integer.parseInt(age) < 18) {
					if (validateMsg.isEmpty()) {
						validateMsg = "Age field is invalid.";
					} else {
						validateMsg = validateMsg + " , " +"Age field is invalid";
					}
				}
				
				if (gender.isEmpty()) {
					if (validateMsg.isEmpty()) {
						validateMsg = "Gender field is empty.";
					} else {
						validateMsg = validateMsg + " , " +"Gender field is empty";
					}
				}
				
				if (validateEmail(email)) {
					if (validateMsg.isEmpty()) {
						validateMsg = "Email field is invalid.";
					} else {
						validateMsg = validateMsg + " , " +"Email field is invalid";
					}
				}
				
				if (validatePhoneNumber(phoneNumber)) {
					if (validateMsg.isEmpty()) {
						validateMsg = "Phone number field is invalid.";
					} else {
						validateMsg = validateMsg + " , " +"Phone number field is invalid";
					}
				}
				
				if (!validateMsg.trim().equals("")) {
					JOptionPane.showMessageDialog(null,validateMsg);
					return;
				}
				
				if (emailIdExist(email)) {
					JOptionPane.showMessageDialog(null,"Cannot add details as employee with same email id exist.");
					return;
				}
				
				btnUpdate.setEnabled(false);
		 		updateEmpID = null;
		 		clearUpdateTextFields();
				
		 		updateDetails.setName(name);
		 		updateDetails.setAge(age);
		 		updateDetails.setGender(gender);
		 		updateDetails.setStartDate(startDate);
		 		updateDetails.setLevel(level);
		 		updateDetails.setTeamInfo(teamInfo);
		 		updateDetails.setPositionTitle(positionTitle);
		 		updateDetails.getContactInfo().setCellPhoneNumber(phoneNumber);
		 		updateDetails.getContactInfo().setEmailId(email);
		 		
		 		JOptionPane.showMessageDialog(null,"Details updated successfully");
		 		populateTable(employeeDirectory.getEmployeeDirectory());
				
		 		
		 	}
		 });
		 btnUpdate.setBackground(new Color(0, 0, 160));
		 btnUpdate.setForeground(new Color(255, 255, 255));
		 btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		 updatePanel.add(btnUpdate, "22, 22");
		 
		 JPanel panel = new JPanel();
		 panel.setBackground(new Color(226, 220, 228));
		 panel.setBounds(21, 37, 646, 129);
		 add(panel);
		 panel.setLayout(new FormLayout(new ColumnSpec[] {
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
		 		ColumnSpec.decode("default:grow"),
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
		 		ColumnSpec.decode("default:grow"),
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
		 
		 JLabel lblNewLabel_2 = new JLabel("Employee ID");
		 lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 panel.add(lblNewLabel_2, "4, 2, right, default");
		 
		 searchEmpID = new JTextField();
		 panel.add(searchEmpID, "6, 2, left, default");
		 searchEmpID.setColumns(10);
		 
		 JLabel lblNewLabel_10 = new JLabel("Email");
		 lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 panel.add(lblNewLabel_10, "10, 2, right, default");
		 
		 searchEmail = new JTextField();
		 panel.add(searchEmail, "12, 2, 7, 1, left, default");
		 searchEmail.setColumns(10);
		 
		 JLabel lblNewLabel_11 = new JLabel("Phone Number");
		 lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 panel.add(lblNewLabel_11, "28, 2, right, default");
		 
		 searchPhoneNumber = new JTextField();
		 panel.add(searchPhoneNumber, "32, 2, 4, 1, left, default");
		 searchPhoneNumber.setColumns(10);
		 
		 JButton uniqueSearch = new JButton("Unique Search");
		 uniqueSearch.setBackground(new Color(125, 189, 83));
		 uniqueSearch.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {

		 		String email = searchEmail.getText();
		 		String phoneNumber = searchPhoneNumber.getText();
		 		String empId = searchEmpID.getText();  
				uniqueSearch(email,phoneNumber,empId);
				// uniqueSearchFlag = true;
		 		
		 	}
		 });
		 panel.add(uniqueSearch, "36, 4");
		 
		 JLabel lblNewLabel_12 = new JLabel("Name");
		 lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		 panel.add(lblNewLabel_12, "4, 6, right, default");
		 
		 searchName = new JTextField();
		 panel.add(searchName, "6, 6, left, default");
		 searchName.setColumns(10);
		 
		 JLabel lblNewLabel_14 = new JLabel("Position");
		 lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 11));
		 panel.add(lblNewLabel_14, "10, 6, right, default");
		 
		 JButton generalSearch = new JButton("General Search");
		 generalSearch.setBackground(new Color(125, 189, 83));
		 generalSearch.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {	
		 		String name = searchName.getText();
		 		String position = searchPosition.getText();  
		 		
		 		generalSearch(name,position);
		 	}
		 });
		 
		 searchPosition = new JTextField();
		 panel.add(searchPosition, "14, 6, 7, 1, left, default");
		 searchPosition.setColumns(10);
		 panel.add(generalSearch, "36, 8");
		 
		 uniqueSearchFlag = false;
		 generalSearchFlag = false;
	
		 populateTable(employeeDirectory.getEmployeeDirectory());

	}

	private void populateTable(ArrayList<EmployeeDetails> filterEmployeeDirectory) {
		DefaultTableModel model = (DefaultTableModel) tblEmployeeData.getModel();
		model.setRowCount(0);
		
		for (EmployeeDetails ed: filterEmployeeDirectory) {
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
	
	private void clearUpdateTextFields() {
		
		textName.setText("");
		textAge.setText("");
		textStartDate.setText("");
		textLevel.setText("");
		textTreamInfo.setText("");
		textTitle.setText("");
		textPhoneNumber.setText("");
		textEmail.setText("");
		lblIcon.setIcon(null);
		btnGroup.clearSelection();
		
	}
	
	private EmployeeDetails getEmployeeDetailByEmail(String empId) {
		if (employeeDirectory != null ) {
			for (EmployeeDetails ed: employeeDirectory.getEmployeeDirectory()) {
				if (ed.getEmployeeId().equals(empId)) {
					return ed;
				}
			}
		}
		return null;
	}
	
	private boolean validateName(String name) {
		boolean isValidated = false;
		if (name == null || name.trim().equals("")) {
			return isValidated =  true;
		}
		final Pattern pattern = Pattern.compile("^[A-Za-z- ]++$");
		if (!pattern.matcher(name).matches()) {
			return isValidated =  true;
		}
		return isValidated;
	}
	
	private boolean validateEmail(String email) {
		boolean isValidated = false;
		if (email == null || email.trim().equals("")) {
			return isValidated =  true;
		}
		final Pattern pattern = Pattern.compile("^(.+)@(.+)$");
		if (!pattern.matcher(email).matches()) {
			return isValidated =  true;
		}
		return isValidated;
	}
	
	private boolean validatePhoneNumber(String phone) {
		boolean isValidated = false;
		if (phone == null || phone.trim().equals("")) {
			return isValidated =  true;
		}
		final Pattern pattern = Pattern.compile("^(\\+\\d{1,2}\\s)?\\(?\\d{3}\\)?[\\s.-]?\\d{3}[\\s.-]?\\d{4}$");
		if (!pattern.matcher(phone).matches()) {
			return isValidated =  true;
		}
		return isValidated;
	}
	
	private ArrayList<EmployeeDetails> uniqueSearch(String emailId, String phone, String empId) {
		ArrayList<EmployeeDetails> filterEmployeeDirectory = new ArrayList<EmployeeDetails>();
		for(EmployeeDetails ed : employeeDirectory.getEmployeeDirectory()) {
			if (emailId != null && !emailId.isEmpty() && ed.getContactInfo().getEmailId().equals(emailId)) {
				if (phone != null && !phone.isEmpty() && ed.getContactInfo().getCellPhoneNumber().equals(phone)) {
					if (empId != null & !empId.isEmpty()  && ed.getEmployeeId().equals(empId)) {
						filterEmployeeDirectory.add(ed);
						populateTable(filterEmployeeDirectory);
					} else {
						filterEmployeeDirectory.add(ed);
						populateTable(filterEmployeeDirectory);
					}
				 } else if (phone == null || phone.isEmpty()) {
					 if (empId != null & !empId.isEmpty()  && ed.getEmployeeId().equals(empId)) {
							filterEmployeeDirectory.add(ed);
							populateTable(filterEmployeeDirectory);
						} else {
							filterEmployeeDirectory.add(ed);
							populateTable(filterEmployeeDirectory);
						}
				 }
				} else if(emailId == null || emailId.isEmpty()) {
				if (phone != null && !phone.isEmpty() && ed.getContactInfo().getCellPhoneNumber().equals(phone)) {
					if (empId != null && !empId.isEmpty() && ed.getEmployeeId().equals(empId)) {
						filterEmployeeDirectory.add(ed);
						populateTable(filterEmployeeDirectory);
					}	else {
						filterEmployeeDirectory.add(ed);
						populateTable(filterEmployeeDirectory);
					}
				} else if (phone == null || phone.isEmpty()) {
					if (empId != null && !empId.isEmpty() && ed.getEmployeeId().equals(empId)) {
						filterEmployeeDirectory.add(ed);
						populateTable(filterEmployeeDirectory);
					} else if (empId == null || empId.isEmpty()) {
						filterEmployeeDirectory.add(ed);
						populateTable(filterEmployeeDirectory);
					}
			}
		}
		}
		
		if (filterEmployeeDirectory.size() <= 0) {
			JOptionPane.showMessageDialog(null,"No record found");
		}
		
		return filterEmployeeDirectory;	
	}
	
	private void generalSearch(String name, String position) {
		ArrayList<EmployeeDetails> filterEmployeeDirectory = new ArrayList<EmployeeDetails>();
		for(EmployeeDetails ed : employeeDirectory.getEmployeeDirectory()) {
			if (name != null && !name.trim().isEmpty() && ed.getName().contains(name)) {
				if (filterEmployeeDirectory.size() == 0) {
					filterEmployeeDirectory.add(ed);
				} else if (!filterEmployeeDirectory.contains(ed)) {
					filterEmployeeDirectory.add(ed);
				}
			} 
			
			if (position != null && !position.trim().isEmpty() && ed.getPositionTitle().contains(position)) {
				if (filterEmployeeDirectory.size() == 0) {
					filterEmployeeDirectory.add(ed);
				} else if (!filterEmployeeDirectory.contains(ed)) {
					filterEmployeeDirectory.add(ed);
				}
			}
	
		}
		
		if (filterEmployeeDirectory.size() <= 0) {
			JOptionPane.showMessageDialog(null,"No record found");
		} else {
			populateTable(filterEmployeeDirectory);
		}
		
	}
	
	private boolean emailIdExist(String email) {
		boolean emailIdExist = false;
		ArrayList<EmployeeDetails> employeeDirectoryL = employeeDirectory.getEmployeeDirectory();
		for(EmployeeDetails ed: employeeDirectoryL) {
			if (email != null && !email.trim().isEmpty() && ed.getContactInfo().getEmailId().equals(email)) {
				emailIdExist = true;
			}
		}
		return emailIdExist;
	}


}
