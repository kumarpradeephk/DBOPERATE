package myprojectmysql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

//import JDBC.LIT.Provider;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.net.ssl.SSLEngineResult.Status;
import javax.swing.JButton;
import java.awt.event.ActionListener;
//import java.security.cert.CRLException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.awt.event.ActionEvent;
import java.awt.Font;
//import java.awt.Window;
import java.awt.Color;
import javax.swing.JPasswordField;
//import java.awt.ActiveEvent;
public class LoginDb {

	public JFrame frame;
	private JTextField textFieldUser;
	private JPasswordField textFieldPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginDb window = new LoginDb();
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
	public LoginDb() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Login to MySQL");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(194, 31, 152, 20);
		frame.getContentPane().add(textFieldUser);
		textFieldUser.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(74, 34, 86, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(74, 89, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(Color.MAGENTA);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						try{				
						Provider.muser=textFieldUser.getText();
						Provider.mpassword=textFieldPassword.getText();
						Connection con=Provider.getConnection();
						if(con!=null)
						{
							JOptionPane.showMessageDialog(null, "connected to mysql database");	
						}
						else{
							JOptionPane.showMessageDialog(null, "invalid user");	
						}
						}catch(Exception e){
							JOptionPane.showMessageDialog(null, "Retry");
						}
					
							MenuContainer mcontain=new MenuContainer();
							mcontain.frame.setVisible(true);
							frame.setVisible(false);
			}
					
		});
		btnNewButton.setBounds(194, 150, 101, 45);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("use default user name \"root\"");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(248, 62, 169, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		textFieldPassword = new JPasswordField();
		textFieldPassword.setBounds(194, 87, 152, 20);
		frame.getContentPane().add(textFieldPassword);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(345, 237, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
}
