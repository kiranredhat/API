package com.api.page;

import com.api.common.Test_ResponseSpecBuilder;
import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.ResponseSpecBuilder;
import static org.hamcrest.Matchers.lessThan;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.lessThan;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.swing.Popup;

import static io.restassured.path.json.JsonPath.*;
import io.restassured.path.json.JsonPath;
import org.hamcrest.xml.HasXPath;

public class ResponseAndRequestSpectBuilderPage extends Test_ResponseSpecBuilder{

	@Test
	public void responseSpec()
	{
	when().
	get("http://test.com").
	then().
	spec(responseSpec).
	time(lessThan(4000L)).
	time(greaterThan(4999L));	
	}

	@Test
	public void requestSpec()
	{
	given().
	spec(requestSpec).
	when().
	get("http://test.com").
	then().	
	time(lessThan(4000L)).
	time(greaterThan(4999L));	
	}
}
