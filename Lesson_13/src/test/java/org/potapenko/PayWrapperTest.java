package org.potapenko;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;


class PayWrapperTest {
    static WebDriver driver;
    static JavascriptExecutor js;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.mts.by/");
        js = (JavascriptExecutor) driver;
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка названия блока")
    void nameBlockTest() {
        WebElement nameBlock = driver.findElement(By.xpath("//*[@class=\"pay__wrapper\"]/h2"));
        assertTrue(nameBlock.isDisplayed() && nameBlock.isEnabled());
        assertEquals(nameBlock.getText(), "Онлайн пополнение\n" +
                "без комиссии");
    }

    @Test
    @DisplayName("Наличие логотипов платёжных систем")
    void availabilityPaymentSystemLogosTest() {
        List<WebElement> partners = driver.findElements(By.xpath("//*[@class=\"pay__partners\"]/ul/li"));
        partners.forEach(partner -> assertTrue(partner.isDisplayed() && partner.isEnabled()));
        assertEquals(partners.size(), 6);
    }

    @Test
    @DisplayName("Проверка ссылки «Подробнее о сервисе»")
    void linkMoreAboutServiceTest() {
        WebElement link = driver.findElement(By.xpath("//*[@class=\"pay__wrapper\"]/a"));

        assertEquals(link.getText(), "Подробнее о сервисе");
        assertTrue(link.isDisplayed() && link.isEnabled());

        js.executeScript("arguments[0].click();", link);
    }

    @Test
    @DisplayName("Заполнение поля и проверка работы кнопки «Продолжить»")
    void continueButtonTest() {
        WebElement phoneField = driver.findElement(By.id("connection-phone"));
        js.executeScript("arguments[0].click();", phoneField);
        phoneField.sendKeys("297777777");

        WebElement sumField = driver.findElement(By.id("connection-sum"));
        js.executeScript("arguments[0].click();", sumField);
        sumField.sendKeys("100");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        js.executeScript("arguments[0].click();", continueButton);
    }
}