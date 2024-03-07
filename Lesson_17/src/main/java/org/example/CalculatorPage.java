package org.example;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalculatorPage {
    private AndroidDriver driver;
    @FindBy (id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_clear")
    public WebElement btnClear;
    @FindBy (id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_01")
    public WebElement btn01;
    @FindBy (id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_02")
    public WebElement btn02;
    @FindBy (id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_add")
    public WebElement btnAdd;
    @FindBy (id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_sub")
    public WebElement btnSub;
    @FindBy (id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul")
    public WebElement btnMul;
    @FindBy (id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_div")
    public WebElement btnDiv;
    @FindBy (id = "com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")
    public WebElement btnEqual;
    @FindBy (id = "com.sec.android.app.popupcalculator:id/calc_edt_formula")
    public WebElement edtFormula;

    public CalculatorPage(AndroidDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
