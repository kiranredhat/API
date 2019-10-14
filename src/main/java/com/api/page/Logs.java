package com.api.page;

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
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.*;
import io.restassured.path.json.JsonPath;
import org.hamcrest.xml.HasXPath;
import org.hamcrest.xml.*;
import static org.hamcrest.Matchers.*;
import static io.restassured.response.ValidatableResponseLogSpec.*;

public class Logs {
	@Test
	public void allTypeLogs()
	{
		given().
		get("http://test.com").
		then().
		log().headers();
//		log().body();
//		log().cookies();
//		log().all();
	}
	
	public void logIfError()
	{
		given().
		get("http://test.com").
		then().
		log().ifError();
	}
	
	public void logOnCondition()
	{
		given().
		get("http://test.com").
		then().
		log().ifStatusCodeIsEqualTo(400);
		
	}
	
	
	

}
