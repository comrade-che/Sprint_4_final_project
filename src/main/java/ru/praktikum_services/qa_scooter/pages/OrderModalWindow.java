package ru.praktikum_services.qa_scooter.pages;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderModalWindow {
    private final WebDriver webDriver;
    //Локатор модального окна "Заказ оформлен"
    By modalWindowOrderLocator = By.xpath("//div[@class='Order_Modal__YZ-d3']");
    //Локатор сообщения в модальном окне "Заказ оформлен"
    By messageOrderCompletedLocator = By.xpath("//div[text()='Заказ оформлен']");


    public OrderModalWindow(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

   public boolean isEnabledLocatorModalWindow() {
       WebElement modalWindowOrder = webDriver.findElement(modalWindowOrderLocator);
        return modalWindowOrder.isEnabled();
   }

    public String serchLocatormessegeOrderComleted() {
        WebElement messageOrderCompleted = webDriver.findElement(messageOrderCompletedLocator);
        return messageOrderCompleted.getText();
    }

    public void assertOrderModalWindowIsEnabled(boolean expectedOMW) {
        Assert.assertEquals(expectedOMW, isEnabledLocatorModalWindow());
    }

    public void assertOrderContainsString(String expectedMOC) {
        MatcherAssert.assertThat(serchLocatormessegeOrderComleted(), CoreMatchers.containsString(expectedMOC));
    }
}

