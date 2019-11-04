package pluralsight.pages.login;

import org.openqa.selenium.By;
import pluralsight.pages.CommonVerification;

public class LoginPage {
    private LoginActController act;
    private LoginVerifyController verify;

    public LoginActController act() {
        return act;
    }

    public LoginVerifyController verify() {
        return verify;
    }

    private LoginPage(LoginActController act, LoginVerifyController verify) {
        this.act = act;
        this.verify = verify;
    }

    public static LoginPage getLoginPage() {
        return new LoginPage(new LoginActController(), new LoginVerifyController());
    }

    public static By loginField() {
        return By.id("Username");
        // return By.xpath("//input[@id=\"Username\"]");
    }

    public static By passwordField() {
        return By.id("Password");
        //return By.xpath("//input[@id=\"Password\"]");
    }

    public static By loginButton() {
        return By.id("login_on_login_page");
    }

    public static By loginErrorMessage() {
        return By.xpath("//div[@id=\"sign_in_fail\"]/p[contains(text(),'Invalid user name or password')]");
    }
}
