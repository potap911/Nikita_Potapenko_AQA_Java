package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BasketPageTest {

    static WebDriver driver;
    private MainPage mainPage;
    private BasketPage basketPage;
    private static final int COUNT_GOODS = 5;
    @BeforeAll
    static void setupWebDriverManager() { WebDriverManager.chromedriver().setup(); }

    @BeforeEach
    void setupAll() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://www.wildberries.ru/");
        mainPage = new MainPage(driver);
    }

    @BeforeEach
    void executeAddProduct() throws InterruptedException {
        for (int i = 1; i <= COUNT_GOODS; i++) {
            mainPage.addProduct(i);
        }
        mainPage.clickButtonBasket();
        basketPage = new BasketPage(driver);

        Thread.sleep(1000);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @RepeatedTest(3)
    @DisplayName("Проверка соответствия имен товаров и заявленной цены")
    void nameAndPriceTest() {
        List<Product> expectedGoods = mainPage.getAddedGoods();
        List<Product> actualGoods = basketPage.getBasketGoods();

        if (expectedGoods.size() == actualGoods.size()) {
            Collections.sort(expectedGoods);
            Collections.sort(actualGoods);
            for (int i = 0; i < COUNT_GOODS; i++) {
                Product expected = expectedGoods.get(i);
                Product actual = actualGoods.get(i);
                assertEquals(expected, actual);
            }
        } else fail("Колличество добавленных товаров не соответствует колличеству в корзине");
    }

    @Test
    @DisplayName("Проверка сумарной стоймости товаров")
    void sumPriceGoodsTest() {
        int sumPriceBasketExpected = basketPage.getSumPriceBasketExpected();
        int sumPriceBasketActual = basketPage.getSumPriceBasketActual();
        assertEquals(sumPriceBasketExpected, sumPriceBasketActual);
    }

    @Test
    @DisplayName("Проверка колличества товаров после добавления")
    void countGoodsTest() {
        String expected = "Товары, " + COUNT_GOODS + " шт.";
        assertEquals(expected, basketPage.getTopCountLine());
    }

    @Test
    @DisplayName("Проверка колличества товаров в корзине после увеличения/уменьшения колличества в позиции")
    void chengCountGoodsTest() {
        int newCount = COUNT_GOODS + 1;
        basketPage.clickButtonCountPlus();
        assertEquals("Товары, " + newCount + " шт.", basketPage.getTopCountLine());

        basketPage.clickButtonCountMinus();
        assertEquals("Товары, " + COUNT_GOODS + " шт.", basketPage.getTopCountLine());
    }
}