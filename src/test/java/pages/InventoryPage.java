package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addProductToCart(String productName) {
        String xpath = String.format("//div[text()='%s']/ancestor::div[@class='inventory_item']//button", productName);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void addToCart(String partOfId) {
        driver.findElement(By.id("add-to-cart-" + partOfId)).click();
    }
    public void clickCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

     public boolean isInventoryDisplayed() {
        return driver.findElement(By.className("title")).isDisplayed();
    }

    public String getCartBadgeCount() {
        return driver.findElement(By.className("shopping_cart_badge")).getText();
    }
}
