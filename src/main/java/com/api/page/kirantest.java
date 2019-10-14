package com.api.page;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.testng.annotations.Test;

public class kirantest {
	@Test
	public void root()
	{
		String response = get("http://jsonplaceholder.typicode.com/posts/3").asString();
		
		System.out.println(response);
//		List<String> ls = from(response).getList("id");
//		ls.isEmpty();
//		System.out.println("ListSize:" +ls.size());
//
//		for(String country: ls)
//		{
//			if(country.equals("Saloon Island"))
//				{
//					System.out.println("Found my place");
//		}		}
}
}