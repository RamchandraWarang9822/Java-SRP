package SRPWindow;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.AttributeSet.ColorAttribute;



public class MainPortal {

//---------------
// MODEL  
//---------------


	private JFrame frame;
	JTextField txtUsername;
	private JPasswordField passwordField;

//---------------	
// VIEW
//---------------


	// Create the application.

	public MainPortal() {
		initialize();
	}

	// Initialize the contents of the frame.

	private void initialize() {

		//Main Panel
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0x0F3D3E));
		frame.setBounds(100, 100, 927, 498);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		//Header Label
		JLabel headerlbl = new JLabel("LOGIN");
		headerlbl.setForeground(new Color(0xE2DCC8));
		headerlbl.setHorizontalAlignment(SwingConstants.CENTER);
		headerlbl.setFont(new Font("Roboto", Font.BOLD,50));
		headerlbl.setBounds(340, 42, 195, 54);
		frame.getContentPane().add(headerlbl);

		//Username Input Field
		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
		txtUsername.setForeground(new Color(0x000000));
		txtUsername.setBounds(274, 147, 320, 30);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		txtUsername.setBorder(new LineBorder(new Color(0x345B63),1));

		//Password Input Field
		passwordField = new JPasswordField(10);
		passwordField.setForeground(new Color(0x000000));
		passwordField.setBounds(274, 193, 320,30);
		passwordField.setBorder(new LineBorder(new Color(0x345B63),1));
		frame.getContentPane().add(passwordField);
		
		//Login button
		JButton Login_Button = new JButton("Login");
		Login_Button.setBackground(new Color(0xFFFFFF));
		Login_Button.setForeground(new Color(0x0F3D3E));
		Login_Button.setFont(new Font("Tahoma", Font.BOLD, 18));
		Login_Button.setBounds(357, 263, 145, 54);
		frame.getContentPane().add(Login_Button);

		//Execute funtion after pressing 'Enter' key 
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					checkPassword();
				}
			}
		});


		Login_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				checkPassword();
			}
		});

	}

//---------------
// CONTROLLER
//---------------

	//Correct Password stored in array format
	protected boolean isPasswordCorrect(char[] pass) {
		boolean isCorrect = true;
		char[] correctPassword = { '1', '2', '3', '4' };

		if (pass.length != correctPassword.length) {
			isCorrect = false;
		} else {
			isCorrect = Arrays.equals(pass, correctPassword);
		}

		// Zero out the password.
		Arrays.fill(correctPassword, '0');

		return isCorrect;
	}

	//Function to Validate the login details.
	private void checkPassword(){
		String Uname = txtUsername.getText().toString();
		char[] Pass = passwordField.getPassword();

		if (Uname.equals("Aditya") && isPasswordCorrect(Pass)) {

			//Dispose current frame
			frame.dispose();

			//Redirect to other Window
			Registration_Form RF = new Registration_Form();
			RF.setVisible(true);

		} else {
			txtUsername.setBorder(new LineBorder(new Color(0xA62349),2));
			passwordField.setBorder(new LineBorder(new Color(0xA62349),2));
			JOptionPane.showMessageDialog(passwordField, "Invalid Username & Password", "", 0);
		}
	}

	//
	// Launch the application.
	//

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPortal window = new MainPortal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
