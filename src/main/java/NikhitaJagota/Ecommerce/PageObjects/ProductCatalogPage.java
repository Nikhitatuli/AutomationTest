package NikhitaJagota.Ecommerce.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonComponents.AbstractComponent;
import CommonComponents.OrderPage;

public class ProductCatalogPage extends AbstractComponent {

	WebDriver driver;

	public ProductCatalogPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;

	By visible = By.cssSelector(".mb-3");
	By toast = By.id("toast-container");

	@FindBy(css = ".card-body button:last-of-type")
	WebElement addToCart;

	@FindBy(css = ".ng-animating")
	WebElement overlay;

	public List<WebElement> getList() {
		visibilityOfElement(visible);

		return products;

	}

	public String getProduct(String product) {
		products.stream().filter(s -> s.findElement(By.tagName("b")).getText().equals(product)).findFirst()
				.orElse(null);
		return product;
	}

	public void addToCart(String product) throws InterruptedException {
		getProduct(product);
		addToCart.click();
		// visibilityOfElement(toast);
		invisibilityOfElement();

	}
	
	public CartPage goToCart()
	{
		gotToCart();
		return new CartPage(driver);
	}
	
	/*public OrderPage goToOrder()
	{
		return goToOrder();
		
	}*/
	

}
