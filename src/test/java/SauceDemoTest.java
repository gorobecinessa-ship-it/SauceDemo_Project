import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChoromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.time.Duration;
public class SauceDemoTest {
  WebDriver driver;
  @BeforeMethod
  @Parameters("browser")
  public void setup(@Optional("chrome") String browser) {
    if (browser.equalsIgnoreCase("firefox")) {
      driver = new FirefoxDriver();
    } else {
      driver = new ChomeDriver():
        }
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
  }
  @Test
  public void testOneProduct() {
    LoginPage login = new LoginPage(driver);
        login.enterLoginData("standard_user", "secret_sauce");
        InventoryPage inventory = new InventoryPage(driver);
        inventory.addBackpack(); // Додаємо рюкзак
        inventory.openCart();
        driver.findElement(By.id("checkout")).click();
        fillShippingForm("Tetiana", "Testing", "12345");
        driver.findElement(By.id("finish")).click();
        String success = driver.findElement(By.className("complete-header")).getText();
        Assert.assertEquals(success, "Thank you for your order!");
    }
    @Test
    public void testTwoProductsPrice() {
        new LoginPage(driver).enterLoginData("standard_user", "secret_sauce");
        InventoryPage inv = new InventoryPage(driver);
        inv.addBackpack();
        inv.addBikeLight();
        inv.openCart();
        driver.findElement(By.id("checkout")).click();
        fillShippingForm("Tetiana", "Testing", "12345");
        String totalText = driver.findElement(By.className("summary_subtotal_label")).getText();
        Assert.assertTrue(totalText.contains("39.98"));
    }
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
    private void fillShippingForm(String name, String surname, String zip) {
        driver.findElement(By.id("first-name")).sendKeys(name);
        driver.findElement(By.id("last-name")).sendKeys(surname);
        driver.findElement(By.id("postal-code")).sendKeys(zip);
        driver.findElement(By.id("continue")).click();
    }
    class LoginPage {
        WebDriver d;
        LoginPage(WebDriver d) { this.d = d; }
        void enterLoginData(String user, String pass) {
            d.findElement(By.id("user-name")).sendKeys(user);
            d.findElement(By.id("password")).sendKeys(pass);
            d.findElement(By.id("login-button")).click();
        }
    }
    class InventoryPage {
        WebDriver d;
        InventoryPage(WebDriver d) { this.d = d; }
        void addBackpack() { d.findElement(By.id("add-to-cart-sauce-labs-backpack")).click(); }
        void addBikeLight() { d.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click(); }
        void openCart() { d.findElement(By.className("shopping_cart_link")).click(); }
    }
}
