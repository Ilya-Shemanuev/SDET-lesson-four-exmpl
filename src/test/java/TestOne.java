import com.codeborne.selenide.*;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.x5.pages.YMarketMainPage;
import ru.x5.helpers.Actions;
import ru.x5.helpers.EnvProperties;

import static com.codeborne.selenide.Selenide.*;

public class TestOne {

    private YMarketMainPage page;

    @BeforeClass
    public void init() {
        page = new YMarketMainPage();
    }

    @Test
    public void test1() {
        // получаем страницу
        page
                .getSearchBox()
                .writeIntoSearch(EnvProperties.getProperty("test.property"))
                .clickSearch();

        Actions.click(page.getSearchBox().getSearchField());
    }

    @Test
    public void test2() {
        open("google.com");
        SelenideElement table = $(By.xpath("//div[@id='main']//img"));
        ElementsCollection rows = table.$$("tr");


        rows.filterBy(Condition.attribute("sdgh", "1001"));
        rows.get(2).getText();

        switchTo().alert().accept();

        rows.shouldBe(CollectionCondition.noneMatch("sf", WebElement::isDisplayed));


        table
                .shouldBe(Condition.appear)
                .$("button")
                .waitUntil(Condition.selected, 10)
                .click();

        table.setValue("125");

        Configuration.baseUrl = "https://git.x5.ru";
        open("/repositories");

        Configuration.reportsFolder = "target/allure-results";
    }
}
