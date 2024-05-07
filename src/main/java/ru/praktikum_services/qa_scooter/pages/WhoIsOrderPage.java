package ru.praktikum_services.qa_scooter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WhoIsOrderPage {
    private final WebDriver webDriver;
    //Локатор поля "Имя"
    private final By firstNameInputLocator = By.xpath("//input[@placeholder='* Имя']");
    //Локатор поля "Фамилия"
    private final By lastNameInputLocator = By.xpath("//input[@placeholder='* Фамилия']");
    //Локатор поля "Адрес"
    private final By addressInputLocator = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Локатор поля "Станция метро"
    private final By subwayStationInputLocator = By.xpath("//input[@placeholder='* Станция метро']");
    //Локатор пункта аккордеона "Станция метро"
    private final String subwayValueInputLocator = "//button/div[text()='%s']";
    //Локатор поля "Телефон"
    private final By phoneNumberInputLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Локатор кнопки "Далее"
    private final By nextButtonButtonLocator = By.xpath("//button[text()='Далее']");

    public WhoIsOrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillCustomerInfo(String firstname, String lastname, String address, String subwaystation, String phonenumber) {

        WebElement fieldFirstName = webDriver.findElement(firstNameInputLocator);
        fieldFirstName.sendKeys(firstname);

        WebElement fieldLastName = webDriver.findElement(lastNameInputLocator);
        fieldLastName.sendKeys(lastname);

        WebElement fieldAddress = webDriver.findElement(addressInputLocator);
        fieldAddress.sendKeys(address);

        WebElement fieldSubwayStation = webDriver.findElement(subwayStationInputLocator);
        fieldSubwayStation.click();

        WebElement valueSubwayStation = webDriver.findElement(By.xpath(String.format(subwayValueInputLocator, subwaystation)));
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", fieldSubwayStation);
        valueSubwayStation.click();

        WebElement fieldPhoneNumber = webDriver.findElement(phoneNumberInputLocator);
        fieldPhoneNumber.sendKeys(phonenumber);

    }

    public void clickNextButton() {
        WebElement furtherButton = webDriver.findElement(nextButtonButtonLocator);
        furtherButton.click();
    }
}
