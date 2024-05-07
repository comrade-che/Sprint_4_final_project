package ru.praktikum_services.qa_scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class MainPage {
    private final WebDriver webDriver;
    private WebDriver driver;
    //Локатор кнопки "Заказать"
    public final By orderStartButtonTopLocator = By.xpath("//div[@class='Header_Header__214zg']//button[text()='Заказать']");
    public final By orderStartButtonBottomLocator = By.xpath("//div[@class='Home_FinishButton__1_cWm']//button[text()='Заказать']");
    private final By cookiesButtonLocator = By.id("rcc-confirm-button");

    private final String questionLocator = "accordion__heading-%s";
    private final String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void clickOrderStartTop() {
        WebElement orderStartButton = webDriver.findElement(orderStartButtonTopLocator);
        orderStartButton.click();
    }

    public void clickOrderStartBottom() {
        WebElement orderStartButton = webDriver.findElement(orderStartButtonBottomLocator);
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", orderStartButton);
        new WebDriverWait(driver, ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(orderStartButton));
        orderStartButton.click();
    }

    public void closeCookiesWindow() {
        webDriver.findElement(cookiesButtonLocator).click();
    }

    public void expandQuestion(int index) {
        WebElement element = webDriver.findElement(By.id(String.format(questionLocator, index)));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean AnswerIsDisplayed(String expectedAnswer) {
        WebElement element = webDriver.findElement(By.xpath(String.format(answerLocator, expectedAnswer)));
        return element.isDisplayed();
    }
}
