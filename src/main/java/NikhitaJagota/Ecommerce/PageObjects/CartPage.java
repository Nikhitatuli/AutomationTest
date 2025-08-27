package NikhitaJagota.Ecommerce.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonComponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

@FindBy(xpath="//li[@class=\"totalRow\"]/button")
WebElement checkout;
	
	

	public CheckoutPage gotToCheckout() {

		checkout.click();
		return new CheckoutPage(driver);
	}

}
