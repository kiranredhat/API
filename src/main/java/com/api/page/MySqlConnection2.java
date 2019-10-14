package com.api.page;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.cj.xdevapi.Result;

public class MySqlConnection2 {
@Test
	public void MySqlConection()
	{
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/";
		String databaseName="api";
		String username="root";
		String password="";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection(url+databaseName, username, password);
			String sqlQuery="Select * from persons";
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sqlQuery);
			
			result.next();
			System.out.println(result.getString("ID"));
			System.out.println(result.getString("LastName"));
			System.out.println(result.getString("FirstName"));
			System.out.println(result.getString("Age"));
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		finally
		{
			if(conn!=null)
			{
				conn=null;
			}
		}
	}

}
