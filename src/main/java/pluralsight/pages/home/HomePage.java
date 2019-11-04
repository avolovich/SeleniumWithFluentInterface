package pluralsight.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static pluralsight.DriverFactory.getChromeDriver;

public class HomePage {

    private HomeActController act;
    private HomeVerifyController verify;

    private HomePage() {
        // hide it
    }

    public HomeActController act() {
        return act;
    }

    public HomeVerifyController verify() {
        return verify;
    }

    private HomePage(HomeActController act, HomeVerifyController verify) {
        this.act = act;
        this.verify = verify;
    }

    public static HomePage getHomePage()
    {
        return new HomePage(new HomeActController(), new HomeVerifyController());
    }

    public static By loginPageButton() {
        return By.linkText("Login");
    }
    // WebElement loginButton = driver.findElement(By.xpath("//div[@id=\"login\"]/a"));


}
