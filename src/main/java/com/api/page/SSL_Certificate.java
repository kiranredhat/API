package com.api.page;

import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

import com.api.common.Test_ResponseSpecBuilder;

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


public class SSL_Certificate extends Test_ResponseSpecBuilder {
	
	@Test
	public void handleSSLCertificate()
	{
		given().
		get("http://google.com").
		then().
		statusCode(200);		
	}

	@Test
	public void handleTLSCertificate()
	{
		given().
		relaxedHTTPSValidation("TLS").
		when().get("http://google.com").
		then().statusCode(200);
		
	}

}
