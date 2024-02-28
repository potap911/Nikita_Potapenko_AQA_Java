package org.potapenko;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayWrapperPage {
    static WebDriver driver;
    static JavascriptExecutor js;
    @FindBy (className = "select__header")
    private WebElement selectHeader;
    @FindBy (xpath = "//*[@class=\"select__list\"]/li")
    private WebElement payOption;
    @FindBy (id = "connection-phone")
    private WebElement phoneField;
    @FindBy (id = "connection-sum")
    private WebElement sumField;
    @FindBy (xpath = "//*[@id=\"pay-connection\"]/button")
    private WebElement continueButton;

    public PayWrapperPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        PayWrapperPage.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    public void clickSelectHeader() {
        js.executeScript("arguments[0].click();", selectHeader);
    }

    public void clickPayOption() {
        js.executeScript("arguments[0].click();", payOption);
    }

    public void clickContinueButton() {
        js.executeScript("arguments[0].click();", continueButton);
    }

    public void inputPhone(String phone) {
        js.executeScript("arguments[0].click();", phoneField);
        phoneField.sendKeys(phone);
    }

    public void inputSum(String sum) {
        js.executeScript("arguments[0].click();", sumField);
        sumField.sendKeys(sum);
    }
}
