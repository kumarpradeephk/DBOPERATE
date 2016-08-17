package myprojectmysql;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Insertion {

	public JFrame frame;
	static int n;
	static int N;
	String attribute[]=new String[N];
	static String qry1="";
	static StringBuffer sb=new StringBuffer();
	//private JTextField textField;
	JTextField textField[]=new JTextField[N];
	JLabel lblNewLabel[]=new JLabel[N];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableField tbff=new TableField();
					Insertion window = new Insertion(tbff.Attribute,tbff.N);
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
	public Insertion(String atr[],int s) {
		int s1=s;
		initialize(atr,s1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String atr[],int s) {
		frame = new JFrame("INSERT INTO TABLE");
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TableField tbf=new TableField();
		int co=63;
		for(int i=0;i<N;i++)
		{
				
		    lblNewLabel[i] = new JLabel(atr[i].toUpperCase());
			lblNewLabel[i].setBounds(59, co, 109, 20);
			frame.getContentPane().add(lblNewLabel[i]);
			
			textField[i] = new JTextField();
			textField[i].setBounds(239, co, 71, 20);
			frame.getContentPane().add(textField[i]);
			textField[i].setColumns(10);
			co=co+25;
		}
		
		JButton btnNewButton = new JButton("INSERT");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		
			n=Integer.parseInt(CreateTable.textFieldAttributeNo.getText());
			int j=0;
			for(int i=0;i<N-1;i++)
			{	
			sb=sb.append(textField[i].getText()+",");
			j=i;
			}
			sb=sb.append(textField[j+1].getText()+"");;
			qry1="insert into " + CreateTable.textFieldTname.getText()+" values"+"("+sb+")";
			try {
				Connection con=Provider.getConnection();
				Statement stmt=con.createStatement();
				int status=stmt.executeUpdate(qry1);
				System.out.println(status);
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
	btnNewButton.setBounds(395, 11, 79, 49);
	frame.getContentPane().add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);	
		}
	});
	btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\RakeshS\\Desktop\\cancel.PNG"));
	btnNewButton_1.setBounds(449, 71, 25, 23);
	frame.getContentPane().add(btnNewButton_1);


	}
}
