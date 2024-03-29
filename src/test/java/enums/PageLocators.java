package enums;

import org.openqa.selenium.By;

public enum PageLocators {

     SEARCH_BAR(By.id("search_query_top")),
    SUBMIT_BUTTON(By.name("submit_search")),

    PRODUCT_TEXT(By.xpath("//div[@class='right-block']/h5/a"));

    private final By by;

    PageLocators(By by)
    {
        this.by = by;
    }

    public By getBy()
    {
        return by;
    }
}
