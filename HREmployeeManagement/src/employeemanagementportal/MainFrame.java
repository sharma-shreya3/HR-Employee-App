package employeemanagementportal;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.EmployeeDirectory;

import javax.swing.JSplitPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	EmployeeDirectory employeeDirectory;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 10000);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBounds(10, 0, 1000, 1000);
		contentPane.add(splitPane);
		
		JPanel workSpace = new JPanel();
		splitPane.setRightComponent(workSpace);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setBackground(new Color(235, 235, 226));
		controlPanel.setPreferredSize(new Dimension(100, 600));
		splitPane.setLeftComponent(controlPanel);
		controlPanel.setLayout(null);
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewEmployeeDetails viewPanel = new ViewEmployeeDetails(employeeDirectory);
				splitPane.setRightComponent(viewPanel);
			}
		});
		btnView.setForeground(new Color(255, 255, 255));
		btnView.setBackground(new Color(128, 64, 0));
		btnView.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnView.setBounds(7, 294, 85, 25);
		controlPanel.add(btnView);
		
		JButton btnCreate = new JButton("ADD");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddJPanel addPanel = new AddJPanel(employeeDirectory);
				splitPane.setRightComponent(addPanel);
			}
		});
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCreate.setForeground(new Color(255, 255, 255));
		btnCreate.setBackground(new Color(0, 128, 64));
		btnCreate.setBounds(7, 228, 85, 25);
		controlPanel.add(btnCreate);
		
		employeeDirectory = new EmployeeDirectory(); 
	}
}
