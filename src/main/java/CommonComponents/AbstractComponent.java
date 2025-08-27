package CommonComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import NikhitaJagota.Ecommerce.PageObjects.CartPage;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink='/dashboard/cart']")
	WebElement cart;

	
	@FindBy(css = "[routerlink='/dashboard/myorders']")
	WebElement order;

	public void visibilityOfElement(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}
	public void visibilityOfWebElement(WebElement locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(locator));

	}

	public void invisibilityOfElement() throws InterruptedException {
		Thread.sleep(3000);
	}

	public void gotToCart() {

		cart.click();
		
	}
	
	public OrderPage  goToOrder() throws InterruptedException
	{
		Thread.sleep(2000);
		order.click();
		return new OrderPage(driver);
		
	}

}
