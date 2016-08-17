package myprojectmysql;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class TableNamePage {

	public JFrame frame;
	private JTextField textFieldTbname;
	private JButton btnNewButton_1;
	String str[];
	String str1[];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableNamePage window = new TableNamePage();
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
	public TableNamePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("TABLE NAME BAR");
		frame.getContentPane().setBackground(Color.PINK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER TABLE NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(65, 41, 300, 20);
		frame.getContentPane().add(lblNewLabel);
		
		textFieldTbname = new JTextField();
		textFieldTbname.setBounds(127, 102, 215, 20);
		frame.getContentPane().add(textFieldTbname);
		textFieldTbname.setColumns(10);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				InsertPage.tbname=textFieldTbname.getText();
				String qry="select * from "+textFieldTbname.getText();
				int i=1,j;
			
				try {
					Connection con=Provider.getConnection();
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(qry);
					ResultSetMetaData rsmd=rs.getMetaData();
					int cols=rsmd.getColumnCount();
					InsertPage.colms=cols;
					String st[]=new String[cols];
					String st1[]=new String[cols];
					for(i=1,j=0;i<=cols;i++)
					{
					st[j]=rsmd.getColumnTypeName(i);
					st1[j]=rsmd.getColumnName(i);
					j++;
					}
					str=st;
					str1=st1;
					InsertPage instp=new InsertPage(str,str1,cols,cols);
					instp.frame.setVisible(true);
					frame.dispose();
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Table doesn't exist");
				}

				
			}
		});
		btnNewButton.setBounds(189, 156, 89, 59);
		frame.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(335, 227, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuContainer mcontain=new MenuContainer();
				mcontain.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnBack.setBounds(25, 227, 89, 23);
		frame.getContentPane().add(btnBack);
	}
}
