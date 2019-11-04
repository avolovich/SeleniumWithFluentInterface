package pluralsight.pages.search;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElementsLocatedBy;
import static pluralsight.DriverFactory.getChromeDriver;
import static pluralsight.DriverFactory.getWebDriverWait;
import static pluralsight.pages.search.SearchPage.*;
import static pluralsight.utils.TestUtils.explicitWait;

public class SearchActController {

    WebDriver driver = getChromeDriver();
    WebDriverWait wait = getWebDriverWait();

    public SearchActController filterBySkillLevel(SkillLevel value) {
        driver.findElement(skillLevels())
                .click();

        wait.until(visibilityOfAllElementsLocatedBy(skillFilter(value)));
        driver.findElement(skillFilter(value))
                .click();

        explicitWait();
        return this;
    }

    public SearchActController filterByRole(Role roleName) {
        driver.findElement(roles())
                .click();

        wait.until(visibilityOfAllElementsLocatedBy(roleFilter(roleName)));
        driver.findElement(roleFilter(roleName))
                .click();

        explicitWait();
        return this;
    }

    public SearchActController selectTab(Tab tabName) {
        driver.findElement(tab(tabName))
                .click();
        return this;
    }

    public void selectCourse(String courseName) {
        driver.findElement(course(courseName))
                .click();
    }

}
