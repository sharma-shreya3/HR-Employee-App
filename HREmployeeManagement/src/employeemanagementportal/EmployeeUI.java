package employeemanagementportal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Dimension;

public class EmployeeUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeUI window = new EmployeeUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// creating a frame
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 64, 0));
		frame.setBounds(100, 100, 800, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		
		JPanel btnPanel = new JPanel(); // creating a panel to add buttons for CRUD
		btnPanel.setBackground(new Color(192, 192, 192));
		btnPanel.setPreferredSize(new Dimension(1000, 100));
		frame.getContentPane().add(btnPanel,BorderLayout.NORTH);
		
		JPanel actionPanel = new JPanel(); // creating a panel to add forms and table
		actionPanel.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(actionPanel,BorderLayout.CENTER);
	}

}
