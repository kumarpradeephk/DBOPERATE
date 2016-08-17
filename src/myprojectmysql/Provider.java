package myprojectmysql;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Provider {
	static String muser;
	static String mpassword;
	static String mdriver="com.mysql.jdbc.Driver";
	static String murl="jdbc:mysql://localhost:3306/company";
	
	//static String odriver="oracle.jdbc.driver.OracleDriver";
	//static String ourl="jdbc:oracle:thin:@localhost:1521:xe";
	
	public static Connection getConnection() {
		// TODO Auto-generated method stub
		Connection con=null;
		try
		{
			Class.forName(mdriver);
		con=DriverManager.getConnection(murl,muser,mpassword);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
