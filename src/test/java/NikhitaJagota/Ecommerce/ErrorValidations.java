package NikhitaJagota.Ecommerce;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import NikhitaJagota.Ecommerce.PageObjects.CartPage;
import NikhitaJagota.Ecommerce.PageObjects.CheckoutPage;
import NikhitaJagota.Ecommerce.PageObjects.ConfirmationPage;
import NikhitaJagota.Ecommerce.PageObjects.ProductCatalogPage;
import NikhitaJagota.Ecommerce.Tests.Base;

public class ErrorValidations extends Base {
	@Test(groups = { "errortests" })

	public void ecommereceOrder() throws InterruptedException, IOException {

		ProductCatalogPage productCatalog = landingPage.login("niks25@gmail.com", "Tuli@34");

		Assert.assertEquals("Incorrect email or password.", landingPage.getError());

	}
}
