package employeemanagementportal;

import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public class AddJPanel extends JPanel {
	private JTextField textName;
	private JTextField textAge;
	private JTextField textStartDate;
	private JTextField textLevel;
	private JTextField textTeamInfo;
	private JTextField textPositionTitle;
	private JTextField textPhoneNumber;
	private JTextField textEmail;

	/**
	 * Create the panel.
	 */
	public AddJPanel() {
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
				ColumnSpec.decode("max(134dlu;default):grow"),
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
		add(rdbtnMale, "10, 10");
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBackground(new Color(255, 255, 255));
		rdbtnFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(rdbtnFemale, "12, 10");
		
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
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		add(btnNewButton, "10, 28");

	}

}
