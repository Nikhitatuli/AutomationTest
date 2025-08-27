package NikhitaJagota.Ecommerce;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import NikhitaJagota.Ecommerce.PageObjects.CartPage;
import NikhitaJagota.Ecommerce.PageObjects.CheckoutPage;
import NikhitaJagota.Ecommerce.PageObjects.ConfirmationPage;
import NikhitaJagota.Ecommerce.PageObjects.ProductCatalogPage;
import NikhitaJagota.Ecommerce.Tests.Base;

public class StandAloneTest extends Base {

	String city = "India";

	@Test(dataProvider = "getData")

	public void ecommereceOrder(HashMap<String, String> map) throws InterruptedException, IOException {

		ProductCatalogPage productCatalog = landingPage.login(map.get("email"), map.get("password"));

		productCatalog.addToCart(map.get("product"));
		CartPage cartPage = productCatalog.goToCart();
		CheckoutPage checkout = cartPage.gotToCheckout();
		checkout.selectCity(city);

		ConfirmationPage confirmPage = checkout.placeOrder();
		System.out.println(confirmPage.getMessage());

	}

	/*
	 * @Test(dependsOnMethods = { "ecommereceOrder" }) public void
	 * orderverification() throws InterruptedException { ProductCatalogPage
	 * productCatalog = landingPage.login("niks9025@gmail.com", "Tuli@1234");
	 * OrderPage orderPage = productCatalog.goToOrder(); Assert.assertEquals(true,
	 * orderPage.verifyOrder(product));
	 * 
	 * }
	 * 
	 * /*
	 * 
	 * @DataProvider public Object getData() {
	 * 
	 * return new Object [][] {{"niks9025@gmail.com", "Tuli@1234","ZARA COAT3"} ,
	 * {"niks9025@gmail.com", "Tuli@1234","ADIDAS ORIGINAL"}};
	 * 
	 * 
	 * }
	 * 
	 * 
	 * @DataProvider public Object[][] getData() {
	 * 
	 * HashMap<Object, Object> data = new HashMap<Object, Object>();
	 * data.put("email", "niks9025@gmail.com"); data.put("password", "Tuli@1234");
	 * data.put("product", "ZARA COAT3");
	 * 
	 * HashMap<Object, Object> data1 = new HashMap<Object, Object>();
	 * data1.put("email", "niks9025@gmail.com"); data1.put("password", "Tuli@1234");
	 * data1.put("product", "ADIDAS ORIGINAL");
	 * 
	 * return new Object[][] { { data }, { data1 } };
	 * 
	 * }
	 */

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJSONData();
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}
}
