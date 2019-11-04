package pluralsight.pages.course;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pluralsight.pages.CommonVerification;

import static pluralsight.DriverFactory.getChromeDriver;
import static pluralsight.pages.CommonVerification.getCommonVerification;

public class CourseVerifyController {
    private WebDriver driver = getChromeDriver();

    public CourseVerifyController freeTrialIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='course-page-hero']//div[@class='ps-button section'][1]"))
                .isDisplayed());
        return this;
    }

    public CourseVerifyController coursePreviewIsDisplayed() {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@id='course-page-hero']//div[@class='ps-button section'][2]"))
        .isDisplayed());
        return this;
    }

    public CommonVerification that() {
        return getCommonVerification();
    }
}
