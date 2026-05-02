package resourses;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {

	RequestSpecification reqSpec;
	Properties prop = new Properties();
	
	
	public RequestSpecification requestSpecification() throws IOException {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		//InputStream is = getClass().getClassLoader().getResourceAsStream("global.properties");
		//prop.load(is);
		String baseURL = getGlobalValues("baseUrl");			
		reqSpec = new RequestSpecBuilder().setBaseUri(baseURL)
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();

		return reqSpec;
	}
	
	public String getGlobalValues(String key) throws IOException
	{
		InputStream is = getClass().getClassLoader().getResourceAsStream("global.properties");
		prop.load(is);
		String value = prop.getProperty(key);
		return value;
	}

}
