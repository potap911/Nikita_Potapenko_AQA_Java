package org.example;

import io.appium.java_client.remote.options.BaseOptions;
import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AndroidCalculatorTest {
    private AndroidDriver driver;
    private CalculatorPage calculator;

    @BeforeEach
    public void setUp() {
        BaseOptions options = new BaseOptions()
                .amend("appium:deviceName", "A12")
                .amend("platformName", "Android")
                .amend("appium:ensureWebviewsHavePages", true)
                .amend("appium:nativeWebScreenshot", true)
                .amend("appium:newCommandTimeout", 1000)
                .amend("appium:connectHardwareKeyboard", true);
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub/"), options);
            calculator = new CalculatorPage(driver);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Тест суммы")
    public void sumTest() {
        calculator.btnClear.click();
        calculator.btn01.click();
        calculator.btnAdd.click();
        calculator.btn02.click();
        calculator.btnEqual.click();
        assertEquals("3 Результат вычисления", calculator.edtFormula.getText());
    }

    @Test
    @DisplayName("Тест вычетания")
    public void subTest() {
        calculator.btnClear.click();
        calculator.btn01.click();
        calculator.btnSub.click();
        calculator.btn02.click();
        calculator.btnEqual.click();
        assertEquals(" Минус 1 Результат вычисления", calculator.edtFormula.getText());
    }

    @Test
    @DisplayName("Тест умножения")
    public void mulTest() {
        calculator.btnClear.click();
        calculator.btn01.click();
        calculator.btnMul.click();
        calculator.btn02.click();
        calculator.btnEqual.click();
        assertEquals("2 Результат вычисления", calculator.edtFormula.getText());
    }
    @Test
    @DisplayName("Тест деления")
    public void divTest() {
        calculator.btnClear.click();
        calculator.btn01.click();
        calculator.btnDiv.click();
        calculator.btn02.click();
        calculator.btnEqual.click();
        assertEquals("0.5 Результат вычисления", calculator.edtFormula.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
