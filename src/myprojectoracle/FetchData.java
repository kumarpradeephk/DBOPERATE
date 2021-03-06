package myprojectoracle;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class FetchData {

	public JFrame frame;
	private JTextField textFieldTbn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FetchData window = new FetchData();
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
	public FetchData() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("QUERY PAGE");
		frame.setBounds(100, 100, 1000, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(Color.GREEN);
		textArea.setBackground(Color.BLACK);
		textArea.setBounds(10, 63, 1000, 650);
		frame.getContentPane().add(textArea);
		
		textFieldTbn = new JTextField();
		textFieldTbn.setBounds(347, 12, 142, 20);
		frame.getContentPane().add(textFieldTbn);
		textFieldTbn.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter Table Name");
		lblNewLabel.setFont(new Font("Sitka Subheading", Font.BOLD, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(157, 15, 129, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
				String qry="select * from "+textFieldTbn.getText();
				int i,j=0;
				try {
					Connection con=Provider.getConnection();
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(qry);
					ResultSetMetaData rsmd=rs.getMetaData();
					int cols=rsmd.getColumnCount();
					textArea.append("Quries for Table "+textFieldTbn.getText().toUpperCase()+"\n");
					for(i=1;i<=cols;i++)
					{
					textArea.append((rsmd.getColumnName(i).toUpperCase()+"\t"));
					}
					textArea.append("\n");
					
					while(rs.next())
					{
						int n=cols;
						for(i=1;i<=cols;i++)
						{
						textArea.append((rs.getString(i)+"\t"));
						if(n==i)
						{
						textArea.append("\n");
						}
						}
					}
					textArea.append("\n");
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Table doesn't exist");
				}
				
			}
		});
		btnNewButton.setBounds(592, 11, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setBounds(731, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Back");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuContainer mcontain=new MenuContainer();
				mcontain.frame.setVisible(true);
				frame.dispose();
			}
		});
		btnNewButton_2.setBounds(46, 11, 76, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
