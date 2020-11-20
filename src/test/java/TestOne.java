import org.junit.BeforeClass;
import org.junit.Test;
import ru.x5.pages.YMarketMainPage;
import ru.x5.helpers.Actions;
import ru.x5.helpers.EnvProperties;

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
}
