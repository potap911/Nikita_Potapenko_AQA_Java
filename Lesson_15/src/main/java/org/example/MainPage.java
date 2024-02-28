package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class MainPage {
    static WebDriver driver;
    static JavascriptExecutor js;
    private ArrayList<Product> expectedGoods;
    @FindBy (xpath = "//div[contains(@class,'j-item-basket')]/a")
    private WebElement buttonBasket;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        expectedGoods = new ArrayList<>();
    }

    public void addBasket(int article) {
        String name = driver
                .findElement(By.xpath("//div[@class=\"main-page__content\"]/article[" + article + "]//span[@class=\"product-card__name\"]"))
                .getText().replaceFirst("/", "").trim();
        String price = driver
                .findElement(By.xpath("//div[@class=\"main-page__content\"]/article[" + article + "]//ins")).getText();
        expectedGoods.add(new Product(name, price));

        WebElement buttonAddBasket = driver
                .findElement(By.xpath("//div[@class=\"main-page__content\"]/article[" + article + "]//a[contains(@class,'add-basket')]"));
        js.executeScript("arguments[0].click();", buttonAddBasket);
    }

    public void clickButtonBasket() {
        js.executeScript("arguments[0].click();", buttonBasket);
    }

    public ArrayList<Product> getExpectedGoods() {
        return expectedGoods;
    }
}
