package ru.x5.elements;

import org.openqa.selenium.*;

import java.util.List;

/**
 * Набросок элемента
 * Сложные элементы не обязательно наследовать от WebElement
 * Но можно, если вы хотите работать с ним как с любым другим элементом
 * Главное реализовать методы ниже
 *
 * Сейчас они пустышки
 */
public class SuperComplicatedRadioButton implements WebElement {
    public void click() {
        // плак-плак, я никуда не кликну
    }

    public void submit() {
        // хнык-хнык я не отправлю форму..
    }

    public void sendKeys(CharSequence... charSequences) {

    }

    public void clear() {

    }

    public String getTagName() {
        return null;
    }

    public String getAttribute(String s) {
        return null;
    }

    public boolean isSelected() {
        return false;
    }

    public boolean isEnabled() {
        return false;
    }

    public String getText() {
        return null;
    }

    public List<WebElement> findElements(By by) {
        return null;
    }

    public WebElement findElement(By by) {
        return null;
    }

    public boolean isDisplayed() {
        return false;
    }

    public Point getLocation() {
        return null;
    }

    public Dimension getSize() {
        return null;
    }

    public Rectangle getRect() {
        return null;
    }

    public String getCssValue(String s) {
        return null;
    }

    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return null;
    }
}
