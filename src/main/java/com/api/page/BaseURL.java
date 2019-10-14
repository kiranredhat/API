package com.api.page;

import com.api.common.Test_ResponseSpecBuilder;
import static io.restassured.RestAssured.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import static io.restassured.path.json.JsonPath.*;
import io.restassured.path.json.JsonPath;
import org.hamcrest.xml.HasXPath;
import org.hamcrest.xml.*;


public class BaseURL extends Test_ResponseSpecBuilder {

	@Test(dataProvider="getDatafromArray")
	public void baseUrlVerify()
	{
		given().
		param("PhoneNumber", "9493518878").
		auth().basic("f5048df9-02ee-a86c-9784-8e2f775f3244", "059ca7eb79f8e4be358339d76c85c0aa").
		get("/api/v3/carrier/lookup.json").
		
		then().
		statusCode(200).
		log().all();		
		
	}
	
	@DataProvider (name="getDatafromArray")
	public Object[][] getData()
	{
		Object obj[][]= {{"adfsdf","445"},{"afdds","334"},{"adfsd","366"}};
		return obj;
	}

}
