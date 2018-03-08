package mainpackage;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.plaf.ProgressBarUI;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.ScrollPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;

import javax.swing.JList;
import javax.swing.JPasswordField;

public class HelloWorld {

	public static int interval = 100000;
	private JFrame frame;
	private final Action action = new SwingAction();
	private JTextField txtHereYouCan;
	private JProgressBar pbr;

	int i;

	Timer t;
	private JTextField DisplayTextField1;
	private JButton Install;
	private JPasswordField passwordField;
	private JTextField Status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloWorld window = new HelloWorld();
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
	public HelloWorld() {

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1098, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Installer");
		
		// Install.setEnabled(false);

		;
		
		txtHereYouCan = new JTextField();
		txtHereYouCan.setBounds(40, 35, 993, 74);
		txtHereYouCan.setFont(new Font("Tahoma", Font.PLAIN, 25));
		frame.getContentPane().add(txtHereYouCan);
		txtHereYouCan.setColumns(10);

		Install = new JButton("Install");

		JProgressBar ProgressBAR = new JProgressBar();
		ProgressBAR.setBounds(40, 409, 993, 26);
		frame.getContentPane().add(ProgressBAR);
		ProgressBAR.setValue(0);
		
		Install.setBackground(Color.white);

		Status = new JTextField();
		Status.setEditable(false);
		Status.setBounds(842, 323, 191, 26);
		frame.getContentPane().add(Status);
		Status.setColumns(10);
		Status.setFont(new Font("Thaoma", Font.PLAIN, 14));
		Status.setEnabled(false);
		Status.setDisabledTextColor(Color.ORANGE);
		Status.setText("NORMAL USER");
		
		ProgressBAR.setBackground(Color.WHITE);
		
		JButton Login = new JButton("Login");
		Login.setBounds(502, 316, 115, 39);
		frame.getContentPane().add(Login);
		Login.setBackground(Color.WHITE);
		Install.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ProgressBAR.setValue(99);
				

			}
		});
		Install.setBounds(842, 150, 191, 98);
		frame.getContentPane().add(Install);
		Install.setEnabled(false);

		txtHereYouCan.setBackground(Color.LIGHT_GRAY);

		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.setBounds(489, 150, 161, 98);
		btnSubmit.setBackground(Color.WHITE);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String txttext = txtHereYouCan.getText();
				if (txttext.equals("U5h3-UW9V-67T5-KJUP-6H1M-H6H0-HRUP-213K-2KJFK-Z8OP-DEST-UCD3-3465-CODE")) {
					DisplayTextField1.setText("RIGHT CODE!");
					Install.setEnabled(true);
					
				} else {
					DisplayTextField1.setText("WRONG CODE");
					
				}

			}
		});
		frame.getContentPane().add(btnSubmit);

		DisplayTextField1 = new JTextField();
		DisplayTextField1.setBounds(40, 150, 422, 98);
		DisplayTextField1.setEditable(false);
		DisplayTextField1.setFont(new Font("Thaoma", Font.PLAIN, 25));
		frame.getContentPane().add(DisplayTextField1);
		DisplayTextField1.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(41, 316, 421, 39);
		frame.getContentPane().add(passwordField);

		
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		

	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {

		}
	}
}
