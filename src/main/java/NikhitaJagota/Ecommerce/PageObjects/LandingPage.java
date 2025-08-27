package NikhitaJagota.Ecommerce.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonComponents.AbstractComponent;

import org.openqa.selenium.By;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement username;
	@FindBy(id = "userPassword")
	WebElement pwd;
	@FindBy(id = "login")
	WebElement submit;
	@FindBy(css="[class*=flyInOut]")
	WebElement error;
	
	public String getError()
	{
		visibilityOfWebElement(error);
		return
		error.getText();
	}
	
	

	public ProductCatalogPage login(String email, String password) {
		username.sendKeys(email);
		pwd.sendKeys(password);
		submit.click();
		return new ProductCatalogPage(driver);

	}

	public void gotTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}
