package pluralsight.pages.search;

import org.openqa.selenium.By;

public class SearchPage {

    private SearchActController act;
    private SearchVerifyController verify;
    private SearchGetController get;

    public SearchActController act() {
        return act;
    }

    public SearchVerifyController verify() {
        return verify;
    }

    public SearchGetController get() {
        return get;
    }

    private SearchPage() {}

    private SearchPage(SearchActController act, SearchVerifyController verify, SearchGetController get) {
        this.act=act;
        this.verify=verify;
        this.get=get;
    }

    public static SearchPage getSearchPage() {
        return new SearchPage(new SearchActController(), new SearchVerifyController(), new SearchGetController());
    }

    public static By skillLevels() {
        return By.xpath("//div[contains(@class, 'search-filter-header') and contains(.,'Skill Levels')]");
    }

    public static By skillFilter(SkillLevel value) {
        return By.xpath("//span[contains(@class, 'search-filter-option-text') and contains(.,'" + value + "')]");
    }

    public static By roles() {
        return By.xpath("//div[contains(@class, 'search-filter-header') and contains(.,'Roles')]");
    }

    public static By roleFilter(Role role) {
        return By.xpath("//span[contains(@class, 'search-filter-option-text') and contains(.,'" + role + "')]");
    }

    public static By tab(Tab tabName) {
        return By.xpath("//a[contains(@class, 'tab') and contains(., '"+ tabName +"')]");
    }

    public static By course(String courseName) {
        return By.xpath("//div[@id='search-results-category-target']" +
                "//div[@class='search-result columns' and contains(., '" + courseName + "')]" +
                "//div[@class='search-result__title']/a");
    }
}
