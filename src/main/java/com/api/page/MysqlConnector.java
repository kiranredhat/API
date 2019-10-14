package com.api.page;

import org.testng.annotations.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MysqlConnector {
	
@Test
public void mysqlSetup() 
{
	//https://www.guru99.com/guide-to-install-jmeter.html
	try {
		Class.forName("com.mysql.jdbc.Driver");	
	System.out.println("Driver loaded");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306","root+api", "");
	System.out.println("Connection connected successfully");
	Statement smt=con.createStatement();
		ResultSet rs=smt.executeQuery("Select * from Persons");
		String firstname=rs.getString("Age");
	System.out.println("Database record is"+firstname);
	} catch (ClassNotFoundException e) {
		// TODO Auto-gzaenerated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
