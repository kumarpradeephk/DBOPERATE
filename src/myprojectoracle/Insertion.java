package myprojectoracle;

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
					Insertion window = new Insertion();
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
	public Insertion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("INSERT INTO TABLE");
		frame.setBounds(100, 100, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		TableField tbf=new TableField();
		int co=63;
		for(int i=0;i<N;i++)
		{
			
		/*	textField[i] = new JTextField();
			textField[i].setBounds(59, co, 109, 20);
			frame.getContentPane().add(textField[i]);
			textField[i].setColumns(10);
		*/	
		    lblNewLabel[i] = new JLabel("label");
			lblNewLabel[i].setBounds(59, co, 109, 20);
			frame.getContentPane().add(lblNewLabel[i]);
			
			textField[i] = new JTextField();
			textField[i].setBounds(239, co, 71, 20);
			frame.getContentPane().add(textField[i]);
			textField[i].setColumns(10);
			co=co+25;
		}
		
/*		textField = new JTextField();
		textField.setBounds(241, 38, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(82, 41, 46, 14);
		frame.getContentPane().add(lblNewLabel);
	*/
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
			//System.out.println(n);
			//System.out.println(qry1);
			
			try {
				Connection con=Provider.getConnection();
				Statement stmt=con.createStatement();
				int status=stmt.executeUpdate(qry1);
				System.out.println(status);
				if(status!=0)
				{
					//System.out.println("record inserted");
					JOptionPane.showMessageDialog(null, "Record SUCCESSFULLY Inserted!");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Error/Record already Exist!");
			}
		}
	});
	btnNewButton.setBounds(395, 11, 79, 61);
	frame.getContentPane().add(btnNewButton);
	
	JButton btnNewButton_1 = new JButton("Close");
	btnNewButton_1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
		}
	});
	btnNewButton_1.setBounds(395, 96, 79, 23);
	frame.getContentPane().add(btnNewButton_1);


	}
}
