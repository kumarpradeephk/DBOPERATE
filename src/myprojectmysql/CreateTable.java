package myprojectmysql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class CreateTable {

	public JFrame frame;
    static public JTextField textFieldTname;
	static public JTextField textFieldAttributeNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateTable window = new CreateTable();
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
	public CreateTable() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Table Creation");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Table");
		lblNewLabel.setFont(new Font("Sitka Small", Font.PLAIN, 23));
		lblNewLabel.setBounds(125, 21, 183, 30);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldTname = new JTextField();
		textFieldTname.setBounds(257, 77, 118, 20);
		frame.getContentPane().add(textFieldTname);
		textFieldTname.setColumns(10);
		
		textFieldAttributeNo = new JTextField();
		textFieldAttributeNo.setBounds(257, 142, 118, 20);
		frame.getContentPane().add(textFieldAttributeNo);
		textFieldAttributeNo.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Table Name");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(51, 79, 142, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("No. Of Attributes");
		lblNewLabel_2.setFont(new Font("Sitka Text", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(51, 145, 142, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButtonNext = new JButton("");
		btnNewButtonNext.setIcon(new ImageIcon("C:\\Users\\RakeshS\\Desktop\\next.PNG"));
		btnNewButtonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
				TableField.N=Integer.parseInt(textFieldAttributeNo.getText());
				Insertion.N=TableField.N;
				}catch(Exception e){
					System.out.println("field not left blank");
				}
				
				TableField TField=new TableField();
				TField.frame.setVisible(true);
				frame.dispose();
			}
			
		});
		btnNewButtonNext.setBounds(185, 187, 42, 30);
		frame.getContentPane().add(btnNewButtonNext);
		
		JButton btnNewButton = new JButton("CANCEL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuContainer mcontain=new MenuContainer();
				mcontain.frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}
}
