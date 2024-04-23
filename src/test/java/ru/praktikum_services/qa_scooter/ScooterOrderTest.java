package ru.praktikum_services.qa_scooter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.praktikum_services.qa_scooter.pages.AboutRentOrderPage;
import ru.praktikum_services.qa_scooter.pages.MainPage;
import ru.praktikum_services.qa_scooter.pages.OrderModalWindow;
import ru.praktikum_services.qa_scooter.pages.WhoIsOrderPage;


public class ScooterOrderTest {
    private WebDriverFactory webdriverfactory = new WebDriverFactory();
    private WebDriver webDriver;

    @Before
    public void setup(){
        webDriver = WebDriverFactory.getWebDriver(System.getProperty("browser", "firefox"));
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void createOrderDataFirst() {
        MainPage mainpage = new MainPage(webDriver);
        mainpage.clickOrderStartTop();

        WhoIsOrderPage whoisorderPage = new WhoIsOrderPage(webDriver);
        whoisorderPage.fillCustomerInfo("Роберт", "Рождественский", "г.Москва, ул.Левитана, д.20", "Панфиловская", "+79998887766");
        whoisorderPage.clickNextButton();

        AboutRentOrderPage aboutrentorderpage = new AboutRentOrderPage(webDriver);
        aboutrentorderpage.whereDeliverInfo("19.09.2025", "Домофона нет, звонить на мобильный +79998887766");
        aboutrentorderpage.clickOrderButton();
        aboutrentorderpage.clickApprovalButton();

        OrderModalWindow ordermodalwindow = new OrderModalWindow(webDriver);
        ordermodalwindow.assertOrderModalWindowIsEnabled(true);
        ordermodalwindow.assertOrderContainsString("Заказ оформлен");
    }

    @Test
    public void createOrderDataSecond() {
        MainPage mainpage = new MainPage(webDriver);
        mainpage.clickOrderStartBottom();

        WhoIsOrderPage whoisorderPage = new WhoIsOrderPage(webDriver);
        whoisorderPage.fillCustomerInfo("Людвиг ван", "Бетховен", "г.Москва, ул.Новохохловская, д.91с17", "Новохохловская", "+79008007060");
        whoisorderPage.clickNextButton();

        AboutRentOrderPage aboutrentorderpage = new AboutRentOrderPage(webDriver);
        aboutrentorderpage.whereDeliverInfo("10.06.2026", "Позвонить за час до прибытия на телефон +79008007060");
        aboutrentorderpage.clickOrderButton();
        aboutrentorderpage.clickApprovalButton();

        OrderModalWindow ordermodalwindow = new OrderModalWindow(webDriver);
        ordermodalwindow.assertOrderModalWindowIsEnabled(true);
        ordermodalwindow.assertOrderContainsString("Заказ оформлен");
    }

    @After
    public void closed(){
        webDriver.quit();
    }
}
