package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class MainPage {
    private WebDriver driver;
    private JavascriptExecutor js;
    private ArrayList<Product> addedGoods;
    @FindBy (xpath = "//div[contains(@class,'j-item-basket')]/a")
    private WebElement buttonBasket;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        addedGoods = new ArrayList<>();
    }

    public void addProduct(int article) {
        String name = driver
                .findElement(By.xpath("//div[@class=\"main-page__content\"]/article[" + article + "]//span[@class=\"product-card__name\"]"))
                .getText().replaceFirst("/", "").trim();
        String price = driver
                .findElement(By.xpath("//div[@class=\"main-page__content\"]/article[" + article + "]//ins")).getText();
        addedGoods.add(new Product(name, price));

        WebElement buttonAddBasket = driver
                .findElement(By.xpath("//div[@class=\"main-page__content\"]/article[" + article + "]//a[contains(@class,'add-basket')]"));
        js.executeScript("arguments[0].click();", buttonAddBasket);

        clickItemSize();
    }

    private void clickItemSize() {
        try {
            WebElement itemSize = driver.findElement(By.xpath("//div[@class=\"popup__content\"]/ul/li/label"));
            js.executeScript("arguments[0].click();", itemSize);
        } catch (NoSuchElementException ignore) {}
    }

    public void clickButtonBasket() {
        js.executeScript("arguments[0].click();", buttonBasket);
    }

    public ArrayList<Product> getAddedGoods() {
        return addedGoods;
    }
}
