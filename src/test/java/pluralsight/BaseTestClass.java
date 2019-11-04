package pluralsight;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import static pluralsight.DriverFactory.*;


public class BaseTestClass {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void startUpBrowser() {
        driver = getChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        wait = getWebDriverWait();
        ChromeOptions options = new ChromeOptions();
    }

    @BeforeMethod
    public void goToHome() {
        String homePageRelativePath = "\\src\\main\\resources\\webapp\\HomePage.html";
        String homePageAbsolutePath = System.getProperty("user.dir")+homePageRelativePath;
        driver.get("file:///"+homePageAbsolutePath);
    }


    @AfterSuite(alwaysRun = true)
    public void closeBrowser() {
        driver.close();
    }
}
