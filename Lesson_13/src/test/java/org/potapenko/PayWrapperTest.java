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
    private PayWrapperPage page;
    private String labelInputField;

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
        page = new PayWrapperPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Проверка надписи в незаполненных полях варианта 'Услуги связи'")
    void titleFieldPaymentServiceTest1() {
        page.clickSelectHeader();
        page.clickPayOption();

        labelInputField = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/div/input")).getAttribute("placeholder");
        assertEquals("Номер телефона", labelInputField);

        labelInputField = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/div[2]/input")).getAttribute("placeholder");
        assertEquals("Сумма", labelInputField);

        labelInputField = driver.findElement(By.xpath("//*[@id=\"pay-connection\"]/div[3]/input")).getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", labelInputField);
    }

    @Test
    @DisplayName("Проверка надписи в незаполненных полях варианта 'Домашний интернет'")
    void titleFieldPaymentServiceTest2() {
        page.clickSelectHeader();
        page.clickPayOption();

        labelInputField = driver.findElement(By.xpath("//*[@id=\"pay-internet\"]/div/input")).getAttribute("placeholder");
        assertEquals("Номер абонента", labelInputField);

        labelInputField = driver.findElement(By.xpath("//*[@id=\"pay-internet\"]/div[2]/input")).getAttribute("placeholder");
        assertEquals("Сумма", labelInputField);

        labelInputField = driver.findElement(By.xpath("//*[@id=\"pay-internet\"]/div[3]/input")).getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", labelInputField);
    }

    @Test
    @DisplayName("Проверка надписи в незаполненных полях варианта 'Рассрочка'")
    void titleFieldPaymentServiceTest3() {
        page.clickSelectHeader();
        page.clickPayOption();

        labelInputField = driver.findElement(By.xpath("//*[@id=\"pay-instalment\"]/div/input")).getAttribute("placeholder");
        assertEquals("Номер счета на 44", labelInputField);

        labelInputField = driver.findElement(By.xpath("//*[@id=\"pay-instalment\"]/div[2]/input")).getAttribute("placeholder");
        assertEquals("Сумма", labelInputField);

        labelInputField = driver.findElement(By.xpath("//*[@id=\"pay-instalment\"]/div[3]/input")).getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", labelInputField);
    }

    @Test
    @DisplayName("Проверка надписи в незаполненных полях варианта 'Задолженность'")
    void titleFieldPaymentServiceTest4() {
        page.clickSelectHeader();
        page.clickPayOption();

        labelInputField = driver.findElement(By.xpath("//*[@id=\"pay-arrears\"]/div/input")).getAttribute("placeholder");
        assertEquals("Номер счета на 2073", labelInputField);

        labelInputField = driver.findElement(By.xpath("//*[@id=\"pay-arrears\"]/div[2]/input")).getAttribute("placeholder");
        assertEquals("Сумма", labelInputField);

        labelInputField = driver.findElement(By.xpath("//*[@id=\"pay-arrears\"]/div[3]/input")).getAttribute("placeholder");
        assertEquals("E-mail для отправки чека", labelInputField);
    }

    @Test
    @DisplayName("Заполнение полей в варианте 'Услуги связи', проверка полей ввода реквизитов карты")
    void continueButtonTest() {
        page.inputPhone("297777777");
        page.inputSum("100");
        page.clickContinueButton();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class=\"bepaid-iframe\"]")));

        labelInputField = driver.findElement(By.xpath("//*[@class=\"header__payment-amount\"]/span"))
                .getAttribute("innerHTML");
        assertEquals("100.00 BYN", labelInputField);

        labelInputField = driver.findElement(By.xpath("//*[@class=\"header__payment-info\"]"))
                .getAttribute("innerHTML");
        assertEquals(" Оплата: Услуги связи\nНомер:375297777777 ", labelInputField);

        labelInputField = driver.findElement(By.xpath("//*[@id=\"cc-number\"]/following-sibling::label"))
                .getAttribute("innerHTML");
        assertEquals("Номер карты", labelInputField);

        labelInputField = driver.findElement(By.xpath("//*[@class=\"ng-tns-c47-4 ng-star-inserted\"]"))
                .getAttribute("innerHTML");
        assertEquals("Срок действия", labelInputField);

        labelInputField = driver.findElement(By.xpath("//*[@class=\"ng-tns-c47-3 ng-star-inserted\"]"))
                .getAttribute("innerHTML");
        assertEquals("Имя держателя (как на карте)", labelInputField);

        try {
            List<WebElement> iconsContainer = driver.findElements(By.xpath("//*[@class=\"ng-tns-c53-0 ng-star-inserted\"]"));
            assertEquals(4, iconsContainer.size());
        } catch (NoSuchElementException e) {
            fail();
        }

        WebElement payButton = driver.findElement(By.xpath("//*[@class=\"colored disabled ng-star-inserted\"]"));
        assertEquals(" Оплатить  100.00 BYN <!---->", payButton.getAttribute("innerHTML"));
    }
}