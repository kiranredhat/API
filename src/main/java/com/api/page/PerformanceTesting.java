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
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static io.restassured.path.json.JsonPath.*;
import io.restassured.path.json.JsonPath;
import org.hamcrest.xml.HasXPath;

@Test
public class PerformanceTesting
{
public void timeResponse1()
{
	long t=given().get("http://test.com").time();
	System.out.println("Time(ms): " +t); 

	long t1=given().get("http://test.com").timeIn(TimeUnit.SECONDS);
	System.out.println("Time(ms): " +t); 

	given().get("http://test.com").then().
	time(lessThan(400L));
}
}
