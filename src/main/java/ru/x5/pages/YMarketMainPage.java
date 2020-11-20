package ru.x5.pages;

import org.openqa.selenium.By;
import ru.x5.elements.SearchBox;
import ru.x5.helpers.Actions;
import ru.x5.helpers.DriverDealer;

/**
 * Класс реализаует паттерн PageObject
 *
 * Описывает страницу Yandex.Market
 */
public class YMarketMainPage {

    /**
     * Приватное финальное поле хранящее экземпляр опаратора драйвера
     */
    private final DriverDealer dealer = DriverDealer.getInstance();

    /**
     * Поле хранящее описание комплексного элемента строки поиска
     */
    private SearchBox searchBox;

    /**
     * Финальное поле хранящае локатор, чтобы найти лого
     */
    private final By logoXPath = By.xpath("//span[text()='Маркет']");

    /**
     * Конструктор который сразу находит строку поиска
     */
    public YMarketMainPage() {
        searchBox = new SearchBox();
    }

    /**
     * Метод возвращает уже найденую строку поиска
     * @return комплексный элемент строка поиска
     */
    public SearchBox getSearchBox() {
        return searchBox;
    }

    /**
     * Метод находит и кликает по лого сайта
     * @return себя, чтобы можно было вызывать другие методы класса
     */
    public YMarketMainPage clickOnLogo() {
        Actions.click(dealer.getDriver().findElement(logoXPath));
        return this;
    }
}
