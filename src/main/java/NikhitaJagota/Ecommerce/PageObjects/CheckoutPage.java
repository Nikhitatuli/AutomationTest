package NikhitaJagota.Ecommerce.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import CommonComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By dropdown = By.cssSelector(".ta-results");

	@FindBy(css = "input[placeholder=\"Select Country\"]")
	WebElement city;
	
	@FindBy(css=".action__submit ")
	WebElement orderButton;

	public void selectCity(String city) {
		Actions a = new Actions(driver);
		a.sendKeys(this.city, city).build().perform();

		visibilityOfElement(dropdown);

		List<WebElement> countryList = driver.findElements(By.cssSelector(".ta-results"));

		countryList.get(countryList.size() - 1).click();
	}
	
	public ConfirmationPage placeOrder()
	{
		orderButton.click();
		return new ConfirmationPage(driver);
	}

}
