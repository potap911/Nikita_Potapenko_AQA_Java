package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfWindowsToBe;

class BasketPageTest {

    static WebDriver driver;
    private MainPage mainPage;
    private BasketPage basketPage;
    Wait<WebDriver> wait;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.wildberries.ru/");
        mainPage = new MainPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }


    @Test
    @DisplayName("Добавление товаров в корзину и проверка корзины")
    void addGoodsTest() throws InterruptedException {
        mainPage.addBasket(1);
        mainPage.addBasket(2);
        mainPage.addBasket(3);

        Thread.sleep(2000);
        mainPage.clickButtonBasket();

        driver.switchTo();
        Thread.sleep(2000);
        basketPage = new BasketPage(driver);

        List<Product> expectedGoods = mainPage.getExpectedGoods();
        List<Product> actualGoods = basketPage.getActualGoods();
        if (expectedGoods.size() == actualGoods.size()) {
            Collections.sort(expectedGoods);
            Collections.sort(actualGoods);
            for (int i = 0; i < expectedGoods.size(); i++) {
                assertEquals(expectedGoods.get(i), actualGoods.get(i));
            }

        } else fail();

    }

}