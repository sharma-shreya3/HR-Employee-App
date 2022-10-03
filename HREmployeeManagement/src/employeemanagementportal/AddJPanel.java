package employeemanagementportal;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import model.ContactInfo;
import model.EmployeeDetails;
import model.EmployeeDirectory;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class AddJPanel extends JPanel {
	private JTextField textName;
	private JTextField textAge;
	private JLabel lblImage;
	private JTextField textStartDate;
	private JTextField textLevel;
	private JTextField textTeamInfo;
	private JTextField textPositionTitle;
	private JTextField textPhoneNumber;
	private JTextField textEmail;
	private String imagePath;

	/**
	 * Create the panel.
	 */
	EmployeeDirectory employeeDirectory;
	HashMap<String, String> validationFields;
	
	
	public AddJPanel(EmployeeDirectory employeeDirectory) {
		setBackground(new Color(255, 255, 255));
		setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(57dlu;default)"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(128dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(70dlu;default):grow"),},
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblTitle = new JLabel("Add Employee Data");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		add(lblTitle, "10, 2");
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblName, "8, 6, right, default");
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textName, "10, 6, fill, default");
		textName.setColumns(10);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblAge, "8, 8, right, default");
		
		textAge = new JTextField();
		textAge.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textAge, "10, 8, fill, default");
		textAge.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setHorizontalAlignment(SwingConstants.TRAILING);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblGender, "8, 10");
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBackground(new Color(255, 255, 255));
		rdbtnMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(rdbtnMale, "10, 10, left, default");
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(255, 255, 255));
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(rdbtnFemale, "12, 10");
		ButtonGroup btnGroup = new ButtonGroup();
		btnGroup.add(rdbtnMale);
		btnGroup.add(rdbtnFemale);
		
		
		
		JLabel lblStartDate = new JLabel("StartDate");
		lblStartDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblStartDate, "8, 12, right, default");
		
		textStartDate = new JTextField();
		textStartDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textStartDate, "10, 12, fill, default");
		textStartDate.setColumns(10);
		
		JLabel lblLevel = new JLabel("Level");
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblLevel, "8, 14, right, default");
		
		textLevel = new JTextField();
		textLevel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textLevel, "10, 14, fill, default");
		textLevel.setColumns(10);
		
		JLabel lblTeamInfo = new JLabel("Team Info");
		lblTeamInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblTeamInfo, "8, 16, right, default");
		
		textTeamInfo = new JTextField();
		textTeamInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textTeamInfo, "10, 16, fill, default");
		textTeamInfo.setColumns(10);
		
		JLabel lblPositionTitle = new JLabel("Position Title");
		lblPositionTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblPositionTitle, "8, 18, right, default");
		
		textPositionTitle = new JTextField();
		textPositionTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textPositionTitle, "10, 18, fill, default");
		textPositionTitle.setColumns(10);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblPhoneNumber, "8, 20, right, default");
		
		textPhoneNumber = new JTextField();
		textPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textPhoneNumber, "10, 20, fill, default");
		textPhoneNumber.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblEmail, "8, 22, right, center");
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(textEmail, "10, 22, fill, default");
		textEmail.setColumns(10);
		
		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPhoto.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblPhoto, "8, 24, default, top");
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textName.getText();
				String age = textAge.getText();
				String gender = null;
				String startDate = textStartDate.getText();
				String level = textLevel.getText();
				String teamInfo = textTeamInfo.getText();
				String positionTitle = textPositionTitle.getText();
				String phoneNumber = textPhoneNumber.getText();
				String email = textEmail.getText();
				String photosLink;
				
				if (rdbtnFemale.isSelected()) {
					gender = "Female";
				} else if (rdbtnMale.isSelected()) {
					gender = "Male";
				}
				
				String validateMsg = "";
				
				if (validateName(name)) {
					validateMsg = validateMsg + "Name field is invalid.";
				}
				try {
					int ageEmp = Integer.parseInt(age);
					if (age.isEmpty() || ageEmp < 18 && ageEmp <  60) {
						if (validateMsg.isEmpty()) {
							validateMsg = "Age field is invalid.";
						} else {
							validateMsg = validateMsg + " , " +"Age field is invalid";
						}
					}
							
				} catch (Exception e1) {
					validateMsg = validateMsg + " , " +"Age field is invalid";
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

				ContactInfo contactInfo = new ContactInfo();
				contactInfo.setCellPhoneNumber(phoneNumber);
				contactInfo.setEmailId(email);
				
				EmployeeDetails employeeDetail = employeeDirectory.addNewEmployeeDetails();
				employeeDetail.setName(name);
				employeeDetail.setAge(age);
				employeeDetail.setEmployeeId(getRandomNumber());
				employeeDetail.setGender(gender);
				employeeDetail.setStartDate(startDate);
				employeeDetail.setLevel(level);
				employeeDetail.setTeamInfo(teamInfo);
				employeeDetail.setPositionTitle(positionTitle);
				employeeDetail.setContactInfo(contactInfo);
				employeeDetail.setPhotosLink(imagePath);
				
				JOptionPane.showMessageDialog(null,"Employee Details added Successfully");
				
				textName.setText("");
				textAge.setText("");
				textStartDate.setText("");
				textLevel.setText("");
				textTeamInfo.setText("");
				textPositionTitle.setText("");
				textPositionTitle.setText("");
				textPhoneNumber.setText("");
				textEmail.setText("");
				btnGroup.clearSelection(); 			
				
			}
		});
		
		JButton btnImg = new JButton("Add Image");
		btnImg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser browseImage = new JFileChooser();
				
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("IMAGES", "png", "jpg", "jpeg");
				browseImage.addChoosableFileFilter(fnef);
				int showOpenDialog = browseImage.showOpenDialog(null);
				
				 if (showOpenDialog == JFileChooser.APPROVE_OPTION) {
			            File selectedImageFile = browseImage.getSelectedFile();
			            String selectedImagePath = selectedImageFile.getAbsolutePath();
			            JOptionPane.showMessageDialog(null, selectedImagePath);
			            imagePath = selectedImagePath;
			            ImageIcon ii = new ImageIcon(selectedImagePath);
			            Image image = ii.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH);
			             
			            lblImage.setIcon(new ImageIcon(image));
			        }
			}
		});
		add(btnImg, "10, 24");
		
		 lblImage = new JLabel("Image Display");
		add(lblImage, "12, 24, 1, 5");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(btnNewButton, "10, 28");
		
		this.employeeDirectory = employeeDirectory;
		this.validationFields = new HashMap<String, String>();
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
	
	private String getRandomNumber() {
		
		Random random = new Random();
        int num = random.nextInt(100000);
        String employeeId = String.format("%05d", num);
        return employeeId;
        
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
