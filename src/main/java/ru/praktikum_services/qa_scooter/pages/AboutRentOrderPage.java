package ru.praktikum_services.qa_scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutRentOrderPage {
    private final WebDriver webDriver;
    //Локатор поля "Телефон"
    By whenToBringInputLocator = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Локатор поля "Срок аренды"
    By fieldRentalPeriodInputLocator = By.xpath("//div[text()='* Срок аренды']");
    //Локатор поля "Значение срока аренды"
    By valueRentalPeriodInputLocator = By.xpath("//div[text()='трое суток']");
    //Локатор поля "Цвет самоката - Черный"
    By colorScooterInputLocator = By.xpath(".//input[@id='black']");
    //Локатор поля "Комментарий для курьера"
    By commentInputLocator = By.xpath("//input[@placeholder='Комментарий для курьера']");
    //Локатор кнопки "Заказать"
    By orderApprovalButtonLocator = By.xpath("//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Локатор кнопки "Подтверждения заказа - Да"
    By orderApproveYesButtonLocator = By.xpath("//button[text()='Да']");

    public AboutRentOrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void whereDeliverInfo(String date, String comment) {
        WebElement fieldWhenToBring = webDriver.findElement(whenToBringInputLocator);
        fieldWhenToBring.sendKeys(date, Keys.ENTER);

        WebElement fieldRentalPeriod = webDriver.findElement(fieldRentalPeriodInputLocator);
        fieldRentalPeriod.click();

        WebElement valueRentalPeriod = webDriver.findElement(valueRentalPeriodInputLocator);
        valueRentalPeriod.click();

        WebElement valueColorScooter = webDriver.findElement(colorScooterInputLocator);
        valueColorScooter.click();

        WebElement fieldComment = webDriver.findElement(commentInputLocator);
        fieldComment.sendKeys(comment);
    }

    public void clickOrderButton() {
        WebElement orderApprove = webDriver.findElement(orderApprovalButtonLocator);
        orderApprove.click();
    }

    public void clickApprovalButton() {
        WebElement orderApproveYes = webDriver.findElement(orderApproveYesButtonLocator);
        orderApproveYes.click();
    }
}
