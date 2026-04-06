package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class SauceDemoTest extends BaseTest {

    @Test
    public void loginAndAddProductToCartTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        InventoryPage inventoryPage = new InventoryPage(driver);
        Assert.assertTrue(inventoryPage.isInventoryDisplayed(), "Inventory page is not displayed!");

        inventoryPage.addProductToCart("Sauce Labs Backpack");
        Assert.assertEquals(inventoryPage.getCartBadgeCount(), "1", "Cart badge count is incorrect!");
    }
}
