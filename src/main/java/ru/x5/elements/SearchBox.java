package ru.x5.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.x5.helpers.DriverDealer;

/**
 * Класс реализуюший паттерн PageFactory
 *
 * В частности описывается структурный элемент, строка поиска
 */
public class SearchBox {

    /**
     * Приватное финальное поле хранящее экземпляр опаратора драйвера
     */
    private final DriverDealer dealer = DriverDealer.getInstance();

    /**
     * Описание элементов на Yandex.Market
     */
    @FindBy(id = "header-search")
    private WebElement searchField;

    @FindBy(xpath = "//form[@aria-label=\"Искать\"]//button[div/text()='Найти']")
    private WebElement searchButton;

    // -----------------------------------------

    /**
     * Конструктор в котором инициализируется структурный элемент
     */
    public SearchBox() {
        PageFactory.initElements(dealer.getDriver(), this);
    }

    /**
     * Метод пишет текст в текстовое поле поиска
     * @param text - текст, который будет записан в текстовое поле
     * @return себя, чтобы можно было вызывать другие методы класса
     */
    public SearchBox writeIntoSearch(final String text) {
        searchField.sendKeys(text);
        return this;
    }

    /**
     * Метод кликает на кнопку поиска
     * @return себя, чтобы можно было вызывать другие методы класса
     */
    public SearchBox clickSearch() {
        searchButton.click();
        return this;
    }

    /**
     * Метод возвращает элемент, текстовое поле
     * @return web-элемент
     */
    public WebElement getSearchField() {
        return searchField;
    }
}
