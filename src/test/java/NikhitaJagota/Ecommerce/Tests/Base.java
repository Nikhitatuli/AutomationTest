package NikhitaJagota.Ecommerce.Tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import NikhitaJagota.Ecommerce.PageObjects.LandingPage;

public class Base {

	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver invokeBrowser() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
				+ "\\src\\main\\java\\NikhitaJagota\\Ecommerce\\resources\\GlobalProperties.properties");

		prop.load(fis);
		
		String browsername = System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
		 

		if (browsername.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			EdgeOptions options = new EdgeOptions(); // add args if needed
		    driver = new EdgeDriver(options);  
			
		}
		else
			System.out.println("browser not present");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	public String getScreenshot(String testcaseName, WebDriver driver) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File file= new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
		FileUtils.copyFile(src,file);
		return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";
	}
	public List<HashMap<String, String>> getJSONData() throws IOException
	{
		//File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\NikhitaJagota\\Ecommerce\\dataReader\\orderData.json");
	
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\NikhitaJagota\\Ecommerce\\dataReader\\orderData.json");

		String jsonContent=FileUtils.readFileToString(file, StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();
	    List<HashMap<String, String>> data = mapper.readValue(
                jsonContent,
                new TypeReference<List<HashMap<String, String>>>() {}
        );
	    
	    return data;
		
	}


	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		driver = invokeBrowser();
		landingPage = new LandingPage(driver);
		landingPage.gotTo();
		return landingPage;
		
	}

	@AfterMethod
	public void driverClose() {
		driver.close();
	}
}
