package ru.x5.helpers;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс помошник. В нем описаны общие действия
 */
public class Actions {

    // allure.link.tms.pattern=https://jira.ru/fdhh/{}

    /**
     * Приватное финальное поле хранящее экземпляр опаратора драйвера
     */
    private static DriverDealer dealer = DriverDealer.getInstance();

    /**
     * Приватное финальное поле хранящее количество секунд, которое будет использоваться для явных ожиданий
     *
     * Явные ожидания - это те, что проиходят непосредствено в данный момент.
     * Такие ожидания применяются только в рамках описанных кодом
     *
     * Неявные ожидания - это те, что проиходят при всех действиях поиска элементов, как страховка.
     * Они не вызываются отдельно, а устанавливаются на глобальном уровне для драйвера.
     * По-умолчанию, таймаут неявных ожиданий равен 0
     */
    private static final long EXPLICIT_TIMEOUT = Long.getLong(EnvProperties.getProperty("explicit.timeout"));

    /**
     * Метод принимает уже найденый элемент и кликает на него
     * @param element - заранее найденый элемент
     */
    @Step("Кликнуть по элементу {element.getText()}")
    public static void click(WebElement element) {
        wait(400);
        element.click();
        wait(200);
    }

    /**
     * Метод реализующий хорошее явное ожидание
     * Метод будет ждать, пока текст в уже найденном элементе не станет тем, что мы передали в этом метод
     * @param element - заранее найденый элемент
     * @param text - текст, который мы хотим дождаться
     */
    public static void waitForTextInElement(WebElement element, String text) {
        new WebDriverWait(dealer.getDriver(), EXPLICIT_TIMEOUT)
                .until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    /**
     * Метод реализует явное ожидание
     *
     * Такое ожидание нежелательно применять как отдельный шаг в тестах
     * НО, оно прекрасно помогает для создания микраожиданий между действиями, чтобы они не смешивались.
     *
     * Собственно так метод и используется в методе click()
     * @param millis - количество миллисекунд, которые обязательно пройдут прежде чем тест проболжит выполнение
     */
    public static void wait(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
