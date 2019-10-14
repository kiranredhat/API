package com.api.common;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

public class BaseAPI {
	
@DataProvider (name="kirandp")	
public String[][] dp()
	{
		 String [][] a= {{"Select * from persons","LastName"},{"Select * from persons","LastName"}};
		return a;
	}
}
