 package myprojectfont;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import myprojectmysql.LoginDb;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrontPage {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrontPage window = new FrontPage();
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
	public FrontPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("DATABASE SELECTOR");
		frame.getContentPane().setBackground(Color.GREEN);
		frame.setResizable(false);
		frame.getContentPane().setForeground(Color.PINK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLEASE SELECT THE DATABASE");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(67, 22, 294, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("MySQL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginDb log=new LoginDb();
				log.frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 16));
		btnNewButton.setForeground(Color.DARK_GRAY);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setBounds(55, 89, 103, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ORACLE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myprojectoracle.LoginDb logg=new myprojectoracle.LoginDb();
				logg.frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Sitka Text", Font.BOLD, 16));
		btnNewButton_1.setForeground(Color.DARK_GRAY);
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setBounds(266, 89, 116, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CLOSE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setForeground(Color.MAGENTA);
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setBounds(181, 161, 89, 62);
		frame.getContentPane().add(btnNewButton_2);
	}
}
