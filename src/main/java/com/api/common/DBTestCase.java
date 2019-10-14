package com.api.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

public class DBTestCase extends BaseAPI {
//@Test (dataProvider=("kirandp"))
	@Test
public void show()
{
		String sqlQuerya="Select * from persons";
		List <String> ls=new ArrayList<String>();
		ls.add("LastName");
		ls.add("FirstName");
		Map<String,String> mp=new HashMap<String,String>();
	 mp =MySqlConnection3.MySqlConection( sqlQuerya,  ls);
	for (Map.Entry<String, String> entry:mp.entrySet())
	{
		System.out.println("Coloum Name is "+entry.getKey()+" DBValue is "+entry.getValue());
	}
	
}
}
