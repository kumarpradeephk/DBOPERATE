package myprojectoracle;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Provider {
	static String muser;
	static String mpassword;
	
	static String odriver="oracle.jdbc.driver.OracleDriver";
	static String ourl="jdbc:oracle:thin:@localhost:1521:xe";
	
	public static Connection getConnection() {
		// TODO Auto-generated method stub
		Connection con=null;
		try
		{
			Class.forName(odriver);
		con=DriverManager.getConnection(ourl,muser,mpassword);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
