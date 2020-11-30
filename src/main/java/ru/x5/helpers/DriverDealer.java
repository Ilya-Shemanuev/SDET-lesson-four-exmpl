package ru.x5.helpers;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


/**
 * Класс реализовывает некий оператор драйвера (драйверов, если модифицировать для мультипоточности)
 */
public class DriverDealer {

    /**
     * Приватное поле, хранящее драйвер
     */
    private WebDriver driver;

    /**
     * Приватное статическое поле, хранящее эклемпляр текущего класса
     * Помогает для реализации паттерна Singleton
     */
    private static DriverDealer instance;

    /**
     * Конструктор класса, который создает опции и capabilities
     * А после создает новый драйвер вместе с ними
     *
     * Здесь можно описать кроссбраузерный зоопарк
     */
    public DriverDealer() {
        Configuration.browserCapabilities = new MutableCapabilities();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

    /**
     * Метод реализации патерна Singleton
     * @return возвращает единственный экземпляр данного класса
     */
    public static DriverDealer getInstance() {
        if(instance == null) {
            instance = new DriverDealer();
        }
        return instance;
    }

    /**
     * Возвращает драйвер
     *
     * Здесь также можно реализовать кроссбраузерный зоопарк
     * Также, и наверное даже лучше создать отдельный метод создания драйвера
     * @return - возвращает WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Метод закрывает текущее окно браузера, которое управляется драйвером
     * и зануляет сам драйвер
     *
     * Если посмотреть на весь класс целиком и подумать как он будет работать,
     * то у этого метода есть проблемы
     */
    public void closeDriver() {
        driver.close();
        driver = null;
    }
}
