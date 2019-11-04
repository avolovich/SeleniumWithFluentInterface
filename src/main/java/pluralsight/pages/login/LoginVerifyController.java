package pluralsight.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pluralsight.pages.CommonVerification;

import static pluralsight.DriverFactory.getChromeDriver;
import static pluralsight.pages.CommonVerification.getCommonVerification;
import static pluralsight.pages.login.LoginPage.loginErrorMessage;

public class LoginVerifyController {

    private WebDriver driver = getChromeDriver();

    public LoginVerifyController loginErrorMessageIsDisplayed() {
        Assert.assertTrue(driver.findElement(loginErrorMessage()).isDisplayed());
        return this;
    }

    public CommonVerification that() {
        return getCommonVerification();
    }

}
