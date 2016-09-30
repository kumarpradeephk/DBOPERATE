package myprojectoracle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class InsertPage {

	public JFrame frame;
	//private JTextField textFieldData;
	static int colms;
	static String tbname;
	String attribute[]=new String[colms];
	static String qry1="";
	StringBuffer sb=new StringBuffer();
	 JTextField textFieldData[]=new JTextField[colms];
	 JLabel lblNewLabel_1 []=new JLabel[colms];
	private JLabel textFieldTbname;
	 static String typename[]=new String[colms];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InsertPage window = new InsertPage();
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
	public InsertPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("DATA INSERTION PAGE");
		frame.getContentPane().setBackground(Color.MAGENTA);
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PLEASE FILL THE DATA");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(79, 17, 243, 23);
		frame.getContentPane().add(lblNewLabel);
		
		 int co=63,i;
		for(i=0;i<colms;i++)
		{
		    lblNewLabel_1[i] = new JLabel("label"+(i+1));
			lblNewLabel_1[i].setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1[i].setBounds(59, co, 109, 20);
			frame.getContentPane().add(lblNewLabel_1[i]);
			
			textFieldData[i] = new JTextField();
			textFieldData[i].setBounds(239, co, 71, 20);
			frame.getContentPane().add(textFieldData[i]);
			textFieldData[i].setColumns(10);
			co=co+25;
		}
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setFont(new Font("Sitka Small", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int j=0;
				for(int i=0;i<colms-1;i++)
				{	
				sb=sb.append(textFieldData[i].getText()+",");
				j=i;
				}
				sb=sb.append(textFieldData[j+1].getText()+"");;
				qry1="insert into " +tbname+" values"+"("+sb+")";
				try {
					Connection con=Provider.getConnection();
					Statement stmt=con.createStatement();
					int status=stmt.executeUpdate(qry1);
					sb=new StringBuffer();
					if(status!=0)
					{
						JOptionPane.showMessageDialog(null, "Record SUCCESSFULLY Inserted");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error! / Record already Exist");
				}
			}
		});
		btnNewButton.setBounds(371, 17, 103, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableNamePage tnp=new TableNamePage();
				tnp.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(398, 68, 72, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(398, 102, 76, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
