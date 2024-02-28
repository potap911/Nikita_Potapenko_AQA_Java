package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BasketPage {
    static WebDriver driver;
    static JavascriptExecutor js;
    @FindBy(xpath = "//div[contains(@class,'basket-item')]")
    static List<WebElement> elementGoods;

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        BasketPage.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    public List<Product> getActualGoods() {
        ArrayList<Product> actualGoods = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            String name = driver
                    .findElement(By.xpath("//div[contains(@class,'basket-item')]" + "[" + i + "]//span[contains(@class,'good-name')]"))
                    .getText().trim();
            String price = driver
                    .findElement(By.xpath("//div[contains(@class,'basket-item')]" + "[" + i + "]//div[contains(@class,'price-wallet')]"))
                    .getText();
            actualGoods.add(new Product(name, price));
        }
        return actualGoods;
    }
}
