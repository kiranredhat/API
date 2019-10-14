package com.api.common;
import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.ResponseSpecBuilder;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matcher.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.naming.spi.DirStateFactory.Result;

import static io.restassured.path.json.JsonPath.*;
import io.restassured.path.json.JsonPath;
import org.hamcrest.xml.HasXPath;

public class Test_ResponseSpecBuilder
{
	public ResponseSpecification responseSpec;
	public RequestSpecification requestSpec;
	@BeforeClass
	public void setup()
	{
		//After Response check following content 
	ResponseSpecBuilder builder = new ResponseSpecBuilder();
	builder.expectStatusCode(200);
	builder.expectHeader("Content-Type","application/json;charset=UTF-8");
	builder.expectHeader("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
	responseSpec= builder.build();
	//Before Response check following content
	RequestSpecBuilder builder1 = new RequestSpecBuilder();
	builder1.addParam("parameter1", "parameterValue");
	builder1.addHeader("header","Value");
	requestSpec= builder1.build();
	
		//After/Before Response check all the content 
	RestAssured.baseURI="https://api.ytel.com";
//	RestAssured.basePath="/country";
//	RestAssured.port=8080;
//	RestAssured.authentication=basic("username", "password");
//	RestAssured.rootPath="x.y.z";
//	RestAssured.filters(..);//List default filters;
//	RestAssured.requestSpecification= ..//Default request specification
//	RestAssured.responseSpecification=**//Default response specification
//	RestAssured.urlEncodingEnabled=**//Specify if Rest Assured should URL encoding the parameters.
//	RestAssured.defaultParser=**//Specifiy a default parser for response bodies if no registered parser can handle dat.
//	RestAssured.registerParser(**) //Specify a parser for the given content-type
//	RestAssured.unregisterParser(**);//Unregister a parser for the given content-type
//	RestAssured.trustStore(truststore);// for java keystore file
//	RestAssured.reset(); // reset all configuration to default like baseURI (localhost), basePath (empty),standared port.
	
	
		//Parse the request
	RestAssured.defaultParser= Parser.JSON;
	RestAssured.defaultParser= Parser.XML;
	}	
}
