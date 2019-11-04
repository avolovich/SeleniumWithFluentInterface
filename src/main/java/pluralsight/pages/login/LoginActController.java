package pluralsight.pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import pluralsight.pages.CommonVerification;

import static pluralsight.DriverFactory.getChromeDriver;
import static pluralsight.pages.login.LoginPage.*;

public class LoginActController {

    WebDriver driver = getChromeDriver();

    public LoginActController enterLogin(String value) {
        driver.findElement(loginField()).sendKeys(value);
        return this;
    }

    public LoginActController enterPassword(String value) {
        driver.findElement(passwordField()).sendKeys(value);
        return this;
    }

    public LoginActController clickSignIn() {
        driver.findElement(loginButton()).click();
        return this;
    }

    public CommonVerification andThen() {
        return CommonVerification.getCommonVerification();
    }



}
