package tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import utils.DriverManager;
public class BaseTest {
  protected WebDriver driver;
    @BeforeMethod
    @Parameters("browser")
  public void setUp(String browser) {
    driver = DriverManager.getDriver(browser);
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }
  @AfterMethod
    public void tearDown() {
      DriverManager.quitDriver();
   }
}
