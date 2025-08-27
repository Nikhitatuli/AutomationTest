package NikhitaJagota.Ecommerce.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonComponents.AbstractComponent;

public class ConfirmationPage  extends AbstractComponent{
	
	WebDriver driver;
	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName="h1")
	WebElement message;
		 public String getMessage()
		{
			
			String confirmmessage=message.getText();
			return confirmmessage;
		}


	

	
	}

