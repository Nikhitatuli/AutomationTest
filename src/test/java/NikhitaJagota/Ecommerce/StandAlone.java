package NikhitaJagota.Ecommerce;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import NikhitaJagota.Ecommerce.PageObjects.LandingPage;
import NikhitaJagota.Ecommerce.PageObjects.ProductCatalogPage;

public class StandAlone {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/client");
		driver.findElement(By.id("userEmail")).sendKeys("niks9025@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Tuli@1234");
		driver.findElement(By.id("login")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));

		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));

		products.stream().filter(s -> s.findElement(By.tagName("b")).getText().equals("ZARA COAT 3")).findFirst()
				.orElse(null);

		driver.findElement(By.cssSelector(".card-body button:last-of-type")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));

		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));

		driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();

		driver.findElement(By.xpath("//li[@class=\"totalRow\"]/button")).click();

		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(By.cssSelector("input[placeholder=\"Select Country\"]")), "India").build()
				.perform();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));

		List<WebElement> countryList = driver.findElements(By.cssSelector(".ta-results"));

		countryList.get(countryList.size() - 1).click();

		driver.findElement(By.cssSelector(".action__submit ")).click();

		System.out.print(driver.findElement(By.tagName("h1")).getText());

	}

}
