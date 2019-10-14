package com.api.page;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;


import io.restassured.parsing.Parser;
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

public class CommonAPI {
//@Test
public void getresponse()
{
	given().
	get("http://jsonplaceholder.typicode.com/posts/3").
	then().
	statusCode(200);
//	body("RestResponse.id", equalTo("k"));
//log().all();
}

//@Test
public void getresponse1()
{
	given().
	get("http://www.postalpincode.in/api/pincode/560100").
	then().
	assertThat().body("Status", equalTo("Success")).
	assertThat().body("PostOffice[0].Name", startsWith("Ele")).
	assertThat().body("PostOffice[0].Name", endsWith("City")).
	assertThat().body("PostOffice[0].Name", containsString("lectronic")).
	
	//Verifying multiple content using org.harcrest.Mathers library
	assertThat().body("PostOffice[1].DeliveryStatus", hasItems("Non-Delivery")).
	log().all();
}

//@Test
public void getresponse2()
{
	given().
	param("key1", "value1").
	header("headA","valueA").
	
	when().
	get("http://www.postalpincode.in/api/pincode/560100").
	
	then().
	assertThat().body("Status", equalTo("Success")).body("Status", equalTo("Success")).
	log().all().
	assertThat().body("PostOffice[0].text()", equalTo("Electronics CitynullSub Post OfficeDeliveryBangalore SouthBangalore SouthBangaloreBangalore SouthBangalore HQKarnatakaIndia")).
	log().all();	
}

//@Test
public void getresponse3()
{
	given().
	get("http:..www.thomas-bayer.com/sqlrest/CUSTOMER/10/sqlrest/CUSTOMER/10").
	then().
	//body(hasXpath("/CUSTOMER/FIRSTNAME", containsString("Sue")));
//assertThat().body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("sue")));
	//body(hasXpath("/INVOICEList/INVOICE[text()="40"]"));	
	log().all();
}

//has to be give authentication for url
//@Test
public void getresponse4()
{
	given().
	auth().preemptive().basic("f5048df9-02ee-a86c-9784-8e2f775f3244", "059ca7eb79f8e4be358339d76c85c0aa").
	when().get("https://api.ytel.com/api/v3/carrier/lookup.xml?phonenumber=9493518878").
	then().statusCode(200).
	log().all();
}

//preemptive() means either need or not need of authentication

//@Test
public void getresponse5()
{
	given().
	param("phonenumber", "9493518878").
	auth().preemptive().basic("f5048df9-02ee-a86c-9784-8e2f775f3244", "059ca7eb79f8e4be358339d76c85c0aa").
	when().get("https://api.ytel.com/api/v3/carrier/lookup.json").
	then().statusCode(200).
	assertThat().body("Message360.Carrier.ApiVersion", equalTo("3")).body("Message360.Carrier.Zips[0]", hasItems("92602","92603","92604","92606")).
	log().all();
}

//@Test
public void root()
{
	given().
	param("phonenumber", "9493518878").
	auth().preemptive().basic("f5048df9-02ee-a86c-9784-8e2f775f3244", "059ca7eb79f8e4be358339d76c85c0aa").
	when().get("https://api.ytel.com/api/v3/carrier/lookup.json").
	then().
	log().all().
	root("Message360.Carrier").
	body("ApiVersion", is("3")).
	body("AccountSid", is("f5048df9-02ee-a86c-9784-8e2f775f3244"));
	//detachRoot("Carrier").
	//body("ResponseStatus", is(1));


//	root("Message360.ResponseStatus").
//	body("Message360.ResponseStatus", is("1"));

	//detachRoot("result").
	//body("result.alpha3_code" , is("ITA"));
}

//@Test
public void convertToStringInputSteamBytecode() throws IOException{
//String	
String responseAsString = get("http://dummy.restapiexample.com/api/v1/employees").asString();
String path = get("http://dummy.restapiexample.com/api/v1/employees").path("Message360.Carrier.CarrierSid");
System.out.println("My Response:\n\n\n" +responseAsString);
//InputStream
InputStream stream= get("http://dummy.restapiexample.com/api/v1/employees").asInputStream();
System.out.println("Stream Length:" + stream.toString().length());
stream.close();
//ByteArray
byte[] byteArray= get("http://dummy.restapiexample.com/api/v1/employees").asByteArray();
System.out.println("Byte Length:" + byteArray.length);
}

//@Test
public void getParticularElement(){

// p
//when().get(href).then().statusCode(200);
}

//@Test
public void wholeResponseExtreact()
{
	Response response=
			when().
			get("http://safdfl.com").

			then().
			 
			extract().
			 response();
			System.out.println("Content Type:" +response.contentType());
			System.out.println("Href"+response.path("url"));
			System.out.println("Status Code:" +response.statusCode());
}

//@Test
public void groovyAdvanceFeature()
{
	//Groovy Feature 1
//	given().
//	param("phonenumber", "9493518878").
//	auth().preemptive().basic("f5048df9-02ee-a86c-9784-8e2f775f3244", "059ca7eb79f8e4be358339d76c85c0aa").//
//	when().get("https://api.ytel.com/api/v3/carrier/lookup.json").
//	body("Message360.Carrier.AccountSid*.length().sum()", "greaterThan(10)");
//	assertThat().body("Message360.Carrier.ApiVersion", equalTo("3"))

	//Groovy Feature 2	
	String response = get("http://sdklka.com").asString();
	List<String> ls = from(response).getList("Message360.Carrier.AccountSid");
	System.out.println("ListSize:" +ls.size());

	for(String country: ls)
	{
	if(country.equals("Saloon Island"))
		System.out.println("Found my place");
	}
	//Groovy Feature 3
	String response =get("http://dslk.com").asString();
	List<String> ls = from(response).getList("Message360.Carrier.findAll {Message360.Carrier.AccountSid.length()>30}.name");
	System.out.println(ls);
}

//@Test
public void extractResponse()
{
	//Extract by String
//	String responseAsString=
//			when().
//			get("http://ldjfl.com").
//			then().
//			extract().asString();
//			List<Integer> albumIds = from(responseAsString).get("id");
//			System.out.println(albumIds.size());
	
	//Extract by JSON path

//String json=
//when().
//get("http://ldjfl.com").
//then().
//extract().asString();
//JsonPath jsonPath = new JsonPath(json).setRoot("Message360.Carrier");
//List<String> list = jsonPath.get("Accountsid");
//System.out.println(list.size());	
	
		//Extract by JSON path2
//	Response response = get("http://dslda.com");
//	//to get single header
//	String oneHeader = response.getHeader("Content-Encoding");
//	System.out.println(">>> Header: "+oneHeader);
//	System.out.println("");

		//	to get all headers
//	Headers headers = response.getHeaders();
//	for (Header h: headers)
//	{
//	System.out.println(h.getName()+":"+h.getValue());
//	}
	
// 		To Get Cookies
//	Response response = get("http://dslda.com");
//	Map<String, String> cookies = response.getCookies();
//
//	for(Map.Entry<String, String> entry : cookies.entrySet())
//	{
//	System.out.println(entry.getKey()+":"+entry.getValue());
//	}
	
	//Get Details of Cookies
//	Response response = get("http://dslda.com");
//	Cookie a = response.getDetailedCookie("==cfduid");
//	System.out.println("Detailed: "+a.hasExpiryDate());
//	System.out.println("Detailed: "+a.getExpiryDate());
//	System.out.println("Detailed: "+a.hasValue());
	
	//Can pass muliple value or no value with URL
//	List<String> list = new ArrayList<String>();
//	list.add("one");
//	list.add("two");
//	given().
//	param("A", "val1", "val2", "val3").
//	param("B").
//	param("C", list).
//	when().
//	get("https://adlfl.com").
//	then().
//	statusCode(200);
	
	//Headers set as a parameter
//	given().
//	headers("k1", "val1", "val2", "val3").
//	header("k2", "v").
//	header("k3", "val1", "val2", "val3").
//	when().
//	get("https://adlfl.com").
//	then().
//	statusCode(200);
	
//	ContentType set as a parameter
	//Headers as a parameter
//	given().
//	contentType("application/json; charset=UTF-8").
//	when().
//	get("https://adlfl.com").
//	then().
//	statusCode(200);
		
}

public void resposeVerification() 

{
	
}

}
