package myprojectoracle;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class TableField {

	static int N;
	static StringBuffer sb1=new StringBuffer();
	static String qry="";
	public JFrame frame;
	JTextField textField[]=new JTextField[N];
	JTextField textField_1[]=new JTextField[N];
	String Attribute[]=new String[N];
	//private JTextField textField;
	//private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableField window = new TableField();
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
	public TableField() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Attribute Field ");
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		int co=63;
		for(int i=0;i<N;i++)
		{
			
			textField[i] = new JTextField();
			textField[i].setBounds(59, co, 109, 20);
			frame.getContentPane().add(textField[i]);
			textField[i].setColumns(10);
			
			textField_1[i] = new JTextField();
			textField_1[i].setBounds(239, co, 71, 20);
			frame.getContentPane().add(textField_1[i]);
			textField_1[i].setColumns(10);
			co=co+25;
		}
		
		
	/*	
		textField = new JTextField();
		textField.setBounds(59, 63, 109, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(239, 63, 71, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);*/
		
		JLabel lblNewLabel = new JLabel("Attribute Name");
		lblNewLabel.setBounds(60, 26, 109, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data types");
		lblNewLabel_1.setBounds(245, 25, 81, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		    int j=0,status=-99;
		 //   Insertion insrts=new Insertion();
				for(int i=0;i<N-1;i++)
				{
				//insrts.attribute[i]=textField[i].getText();	
				sb1=sb1.append(textField[i].getText()+" "+textField_1[i].getText()+",");
				j=i;
				}
				sb1=sb1.append(textField[j+1].getText()+" "+textField_1[j+1].getText());
				//for(int i=0;i<N-1;i++)
				//System.out.println(Attribute[i]+" ");
				//ConnectionDb.qry="create table " + CreateTable.textFieldTname.getText()+"("+ConnectionDb.sb1+")";
				qry="create table " + CreateTable.textFieldTname.getText()+"("+sb1+")";
				
			   	try 
				{	
					Connection conn=Provider.getConnection();
					Statement stmt=conn.createStatement();
				    status =stmt.executeUpdate(qry);
					if(status==0)
					{
						//System.out.println("Table created");
						JOptionPane.showMessageDialog(null, "Table Successfully Created!");
					}
					conn.close();
				}  
			catch (Exception e)
			{
				// TODO: handle exception
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "SQL Syntax Error Foumd!!");
			} 
				Insertion insrt=new Insertion();
				insrt.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(401, 11, 73, 45);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateTable cwindow=new CreateTable();
				cwindow.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(401, 76, 73, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Close");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(401, 110, 73, 23);
		frame.getContentPane().add(btnNewButton_2);
	}

}
