package CommonComponents;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends AbstractComponent{
WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//table[contains(@class,\"table\")]/tbody/tr/td[2])")
List<WebElement> cols;
// Verify Orders if correct Products are present on Orders page
	public boolean verifyOrder(String product)
	
	{
		return (cols.stream().anyMatch(c->c.getText().equalsIgnoreCase(product)));
		
		
	}

}
