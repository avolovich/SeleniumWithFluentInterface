package pluralsight;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pluralsight.pages.CommonVerification;
import pluralsight.pages.course.CoursePage;
import pluralsight.pages.home.HomePage;
import pluralsight.pages.login.LoginPage;
import pluralsight.pages.search.SearchPage;
import pluralsight.pages.search.Role;
import pluralsight.pages.search.SkillLevel;
import pluralsight.pages.search.Tab;

import java.util.List;
import java.util.Stack;

import static pluralsight.pages.course.CoursePage.*;
import static pluralsight.pages.home.HomePage.getHomePage;
import static pluralsight.pages.login.LoginPage.loginErrorMessage;
import static pluralsight.pages.search.SearchPage.getSearchPage;
import static pluralsight.pages.login.LoginPage.getLoginPage;


public class SearchTest  extends BaseTestClass{

    HomePage home = getHomePage();
    SearchPage search = getSearchPage();
    CoursePage course = getCoursePage();
    LoginPage login = getLoginPage();
    CommonVerification common = CommonVerification.getCommonVerification();

    @Test
    public void basicFilterByTest() throws InterruptedException {
        home.act()
                .search("Java");

        search.act()
                .filterBySkillLevel(SkillLevel.BEGINNER)
                .filterByRole(Role.SOFTWARE_DEVELOPMENT)
                .selectTab(Tab.COURSES)
                .selectCourse("Java Fundamentals: The Java Language");

        course.verify().that()
                .isDisplayed(freeTrialButton())
                .isDisplayed(coursePreviewButton());

//        course.verify()
//                .freeTrialIsDisplayed()
//                .coursePreviewIsDisplayed();


//        course.verifyIsDisplayed(freeTrialButton())
//                .verifyIsDisplayed(coursePreviewButton());
//
//        // OR

//        common.verifyIsDisplayed(freeTrialButton())
//                .verifyIsDisplayed(coursePreviewButton());
    }

    @Test
    public void getCourseListAssertionTest() {
        home.act()
                .search("Java");

        search.act()
                .filterBySkillLevel(SkillLevel.BEGINNER)
                .filterByRole(Role.SOFTWARE_DEVELOPMENT)
                .selectTab(Tab.COURSES);

        Assertions.assertThat(search.get().courses())
                .hasSize(25)
                .containsOnlyOnce("Java Fundamentals: The Java Language")
                .doesNotContain("Python");
    }

    @Test
    public void loginPageErrorMessageTest() {
        home.act()
                .openLoginPage();

        login.act()
                .enterLogin("blabla")
                .enterPassword("blabla")
                .clickSignIn();

        login.verify().that()
                .isDisplayed(loginErrorMessage());
    }

}
