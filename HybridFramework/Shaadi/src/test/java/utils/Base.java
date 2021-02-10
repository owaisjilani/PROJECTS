package utils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Base {

	public static WebDriver driver;
	public static String AppUrl;

	@Test
	public  WebDriver getBrowserDriver() throws IOException
	{

		Properties prop=new Properties();
		FileInputStream fin=new FileInputStream("src\\test\\resources\\ExternalFiles\\data.properties");
		prop.load(fin);
		String browser=prop.getProperty("browser");
		AppUrl=prop.getProperty("AppUrl");
		System.out.println(browser);

		if (browser.equalsIgnoreCase("chrome"))
		{

			System.setProperty("webdriver.chrome.driver" , "src\\test\\resources\\ExternalFiles\\chromedriver.exe");
			driver=new ChromeDriver();

		}

		else if (browser.equalsIgnoreCase("Edge"))
		{

			System.setProperty("webdriver.chrome.driver" , "");
			driver=new EdgeDriver();

		}

		else if (browser.equalsIgnoreCase("firefox"))
		{

			System.setProperty("webdriver.gecko.driver" , "FirefoxDriver\\geckodriver.exe");
			driver=new FirefoxDriver();

		}
		else if (browser.equalsIgnoreCase("IE"))
		{

			System.setProperty("webdriver.ie.driver" , "IEDriver\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();


		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}

	@DataProvider (name="dp")
	public String[]  jsonDataRetrieve() throws IOException, ParseException
	{
		JSONParser jsonParser = new JSONParser();
		FileReader reader = new FileReader("src\\test\\resources\\ExternalFiles\\testData.json");
		Object obj = jsonParser.parse(reader);
		JSONObject com=(JSONObject) obj;
		JSONArray communityList = (JSONArray) com.get("shaadiCommunity");
		String arr[]=new String[communityList.size()];
		for(int i=0;i<communityList.size();i++)
		{
			JSONObject c=(JSONObject) communityList.get(i);
			String communityUrl=(String) c.get("Url");
			String communityName=(String) c.get("Name");
			arr[i]=communityUrl+","+communityName;
			//System.out.println(arr[i]);
		}
		return arr;

	}

	@AfterTest
	public void closeDriver() {
		driver.close();
	}

}
