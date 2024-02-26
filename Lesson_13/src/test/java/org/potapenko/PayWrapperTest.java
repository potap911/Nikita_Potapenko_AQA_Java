package org.potapenko;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * TODO:
 * 1. Проверить надписи в незаполненных полях каждого варианта оплаты услуг:
 *      -услуги связи
 *      -домашний интернет
 *      -рассрочка
 *      -задолженность
 * 2. Для варианта «Услуги связи» заполнить поля в соответствии с пререквизитами из предыдущей темы,
 * нажать кнопку «Продолжить» и в появившемся окне проверить корректность отображения:
 *      -суммы (в том числе на кнопке)
 *      -номера телефона
 *      -а также надписей в незаполненных полях для ввода реквизитов карты
 *      -наличие иконок платёжных систем
 */

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
    @DisplayName("Проверка надписи в незаполненных полях варианта 'Услуги связи'")
    void titleFieldPaymentServiceTest1() {
        WebElement selectHeader = driver.findElement(By.xpath("//*[@class=\"select__header\"]"));
        js.executeScript("arguments[0].click();", selectHeader);

        WebElement payOption = driver.findElement(By.xpath("//*[@class=\"select__list\"]/li"));
        js.executeScript("arguments[0].click();", payOption);

        WebElement input;

        input = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/div/input"));
        assertEquals("Номер телефона", input.getAttribute("placeholder"));

        input = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/div[2]/input"));
        assertEquals("Сумма", input.getAttribute("placeholder"));

        input = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/div[3]/input"));
        assertEquals("E-mail для отправки чека", input.getAttribute("placeholder"));
    }

    @Test
    @DisplayName("Проверка надписи в незаполненных полях варианта 'Домашний интернет'")
    void titleFieldPaymentServiceTest2() {
        WebElement selectHeader = driver.findElement(By.xpath("//*[@class=\"select__header\"]"));
        js.executeScript("arguments[0].click();", selectHeader);

        WebElement payOption = driver.findElement(By.xpath("//*[@class=\"select__list\"]/li[2]"));
        js.executeScript("arguments[0].click();", payOption);

        WebElement input;

        input = driver.findElement(By.xpath("//*[@id=\"pay-internet\"]/div/input"));
        assertEquals("Номер абонента", input.getAttribute("placeholder"));

        input = driver.findElement(By.xpath("//*[@id=\"pay-internet\"]/div[2]/input"));
        assertEquals("Сумма", input.getAttribute("placeholder"));

        input = driver.findElement(By.xpath("//*[@id=\"pay-internet\"]/div[3]/input"));
        assertEquals("E-mail для отправки чека", input.getAttribute("placeholder"));
    }

    @Test
    @DisplayName("Проверка надписи в незаполненных полях варианта 'Рассрочка'")
    void titleFieldPaymentServiceTest3() {
        WebElement selectHeader = driver.findElement(By.xpath("//*[@class=\"select__header\"]"));
        js.executeScript("arguments[0].click();", selectHeader);

        WebElement payOption = driver.findElement(By.xpath("//*[@class=\"select__list\"]/li[3]"));
        js.executeScript("arguments[0].click();", payOption);

        WebElement input;

        input = driver.findElement(By.xpath("//*[@id=\"pay-instalment\"]/div/input"));
        assertEquals("Номер счета на 44", input.getAttribute("placeholder"));

        input = driver.findElement(By.xpath("//*[@id=\"pay-instalment\"]/div[2]/input"));
        assertEquals("Сумма", input.getAttribute("placeholder"));

        input = driver.findElement(By.xpath("//*[@id=\"pay-instalment\"]/div[3]/input"));
        assertEquals("E-mail для отправки чека", input.getAttribute("placeholder"));
    }

    @Test
    @DisplayName("Проверка надписи в незаполненных полях варианта 'Задолженность'")
    void titleFieldPaymentServiceTest4() {
        WebElement selectHeader = driver.findElement(By.xpath("//*[@class=\"select__header\"]"));
        js.executeScript("arguments[0].click();", selectHeader);

        WebElement payOption = driver.findElement(By.xpath("//*[@class=\"select__list\"]/li[4]"));
        js.executeScript("arguments[0].click();", payOption);

        WebElement inputField;

        inputField = driver.findElement(By.xpath("//*[@id=\"pay-arrears\"]/div/input"));
        assertEquals("Номер счета на 2073", inputField.getAttribute("placeholder"));

        inputField = driver.findElement(By.xpath("//*[@id=\"pay-arrears\"]/div[2]/input"));
        assertEquals("Сумма", inputField.getAttribute("placeholder"));

        inputField = driver.findElement(By.xpath("//*[@id=\"pay-arrears\"]/div[3]/input"));
        assertEquals("E-mail для отправки чека", inputField.getAttribute("placeholder"));
    }

    @Test
    @DisplayName("Заполнение полей в варианте 'Услуги связи', проверка полей ввода реквизитов карты")
    void continueButtonTest() {
        WebElement phoneField = driver.findElement(By.id("connection-phone"));
        js.executeScript("arguments[0].click();", phoneField);
        phoneField.sendKeys("297777777");

        WebElement sumField = driver.findElement(By.id("connection-sum"));
        js.executeScript("arguments[0].click();", sumField);
        sumField.sendKeys("100");

        WebElement continueButton = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/button"));
        js.executeScript("arguments[0].click();", continueButton);

        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[8]/div/iframe")));

        WebElement inputField;

        inputField = driver.findElement(By.xpath("//*[@class=\"header__payment-amount\"]/span"));
        assertEquals("100.00 BYN", inputField.getAttribute("innerHTML"));

        inputField = driver.findElement(By.xpath("//*[@class=\"header__payment-info\"]"));
        assertEquals("Оплата: Услуги связи\nНомер:375297777777", inputField.getAttribute("innerHTML").trim());

        inputField = driver.findElement(By.xpath("//*[@class=\"ng-tns-c47-1 ng-star-inserted\"]"));
        assertEquals("Номер карты", inputField.getAttribute("innerHTML"));

        inputField = driver.findElement(By.xpath("//*[@class=\"ng-tns-c47-4 ng-star-inserted\"]"));
        assertEquals("Срок действия", inputField.getAttribute("innerHTML"));

        inputField = driver.findElement(By.xpath("//*[@class=\"ng-tns-c47-3 ng-star-inserted\"]"));
        assertEquals("Имя держателя (как на карте)", inputField.getAttribute("innerHTML"));

        List<WebElement> iconsContainer = driver.findElements(By.xpath("//*[@class=\"ng-tns-c53-0 ng-star-inserted\"]"));
        assertEquals(4, iconsContainer.size());
        try {
            iconsContainer.forEach(icon -> js.executeScript("arguments[0].click();", icon));
        } catch (ElementClickInterceptedException e) {
            fail();
        }

        WebElement payButton = driver.findElement(By.xpath("//*[@class=\"colored disabled ng-star-inserted\"]"));
        assertEquals(" Оплатить  100.00 BYN <!---->", payButton.getAttribute("innerHTML"));
    }
}