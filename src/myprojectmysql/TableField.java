package myprojectmysql;

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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class TableField {

	static int N;
	static StringBuffer sb1=new StringBuffer();
	static String qry="";
	public JFrame frame;
	JTextField textField[]=new JTextField[N];
	JTextField textField_1[]=new JTextField[N];
	String Attribute[]=new String[N];
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
		
		JLabel lblNewLabel = new JLabel("Attribute Name");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(54, 26, 112, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data types");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(245, 25, 91, 17);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		    int j=0,status=-99,i;
				for(i=0;i<N-1;i++)
				{	
				sb1=sb1.append(textField[i].getText()+" "+textField_1[i].getText()+",");
				j=i;
				}
				sb1=sb1.append(textField[j+1].getText()+" "+textField_1[j+1].getText());
				for(i=0;i<N;i++)
				Attribute[i]=textField[i].getText();
				qry="create table " + CreateTable.textFieldTname.getText()+"("+sb1+")";
			   	try 
				{	
					Connection conn=Provider.getConnection();
					Statement stmt=conn.createStatement();
				    status =stmt.executeUpdate(qry);
					if(status==0)
					{
						JOptionPane.showMessageDialog(null, "Table Successfully Created!");
					}
					conn.close();
				}  
			catch (Exception e)
			{
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "SQL Syntax Error Foumd!!");
			} 
				Insertion insrt=new Insertion(Attribute,N);
				insrt.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton.setBounds(401, 11, 73, 45);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\RakeshS\\Desktop\\cancel.PNG"));
		btnNewButton_1.setBounds(440, 67, 23, 28);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateTable cwindow=new CreateTable();
				cwindow.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\RakeshS\\Desktop\\back.PNG"));
		btnNewButton_2.setBounds(434, 101, 40, 23);
		frame.getContentPane().add(btnNewButton_2);
	}

}
