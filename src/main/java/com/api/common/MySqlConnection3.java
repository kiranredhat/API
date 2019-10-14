package com.api.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.mysql.cj.xdevapi.Result;

public class MySqlConnection3 {
	public static Map  MySqlConection(String sqlQuerya, List ls)
	{
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/";
		String databaseName="api";
		String username="root";
		String password="";
		String k ="";
		Map <String,String>mp=new HashMap<String,String>();
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn= DriverManager.getConnection(url+databaseName, username, password);
			String sqlQuery=sqlQuerya;
			Statement statement=conn.createStatement();
			ResultSet result=statement.executeQuery(sqlQuery);
			
			result.next();
			
			Iterator<String>itr=ls.iterator();
			while (itr.hasNext())
			{
				String value=itr.next();
				k=result.getString(value);		
				mp.put(value, k);
			}
			
//			System.out.println(result.getString("ID"));
//			System.out.println(result.getString("LastName"));
//			System.out.println(result.getString("FirstName"));
//			System.out.println(result.getString("Age"));
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
		return  mp;

	}

}
