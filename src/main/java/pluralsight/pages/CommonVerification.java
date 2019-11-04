package pluralsight.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static pluralsight.DriverFactory.getChromeDriver;

public class CommonVerification {
    protected WebDriver driver = getChromeDriver();

    private CommonVerification() { // hide it
    }

    public static CommonVerification getCommonVerification() {
        return new CommonVerification();
    }

    public CommonVerification isDisplayed(By element) {
        Assert.assertTrue(driver.findElement(element).isDisplayed());
        return this;
    }

    public CommonVerification isNotDisplayed(By element) {
        Assert.assertFalse(driver.findElement(element).isDisplayed());
        return this;
    }

}
