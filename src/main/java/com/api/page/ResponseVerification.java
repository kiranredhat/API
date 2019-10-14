package com.api.page;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matcher.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.path.json.JsonPath.*;
import io.restassured.path.json.JsonPath;
import org.hamcrest.xml.HasXPath;

public class ResponseVerification 
{
	public void testStatusInResponse()
	{
		given().get("http://dsfj.com").
		then().assertThat().statusCode(200).log().all();
		given().get("http://dsfj.com").
		then().assertThat().statusLine("HTTP/1.1 200 OK");
		given().get("http://dsfj.com").
		then().assertThat().statusLine(containsString("OK"));
	}
	
	public void verifyHeaders()
	{
		 given().get("http://dsfj.com").
		  then().
		  assertThat().headers("content-encoding", "gzip").
		  assertThat().headers("content-encoding", "gzip", "content-type", containsString("json"));
	}
	
	public void verifyBodyResponse()
	{
		String responseString = get("http://test.coom").asString();
		given().get("http://test.com").
		then().assertThat().body(equalTo(responseString));
	}
	
	//Cookies change with every hit
	public void verifyCookies()
	{
		given().get("http://test.com").
		then().assertThat().cookie("--cfuid", "dddlkjfdkdslfkljasdffflf");
	}
	//Verify response with lamba expression
	public void lambaExpression()
	{
		given().get("http://test.com").
		then().body("AccountSid", response -> equalTo("asdfdfdffsdsfafsdf"));
	}
	
	
	
	
}
