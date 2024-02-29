package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BasketPage {
    private WebDriver driver;
    private JavascriptExecutor js;
    @FindBy(xpath = "//div[contains(@class,'basket-item')]")
    private List<WebElement> basketItemList;
    @FindBy(xpath = "//p[contains(@class,'top__total')]/span[2]/span")
    private WebElement sumPriceBasketElement;
    @FindBy(xpath = "//div[contains(@class,'price-new')]")
    private List<WebElement> priceElementList;
    @FindBy(xpath = "//button[contains(@class,'count__plus')]")
    private WebElement buttonCountPlus;
    @FindBy(xpath = "//button[contains(@class,'count__minus')]")
    private WebElement buttonCountMinus;
    @FindBy(xpath = "//div[contains(@class,'top__count')]/span")
    private WebElement topCountLine;

    public BasketPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        js = (JavascriptExecutor) driver;
    }

    public List<Product> getBasketGoods() {
        ArrayList<Product> actualGoods = new ArrayList<>();
        for (WebElement item : basketItemList) {
            String name = item
                    .findElement(By.xpath(".//span[contains(@class,'good-name')]"))
                    .getText().trim().replaceAll("\\.$", "");

            String price = item
                    .findElement(By.xpath(".//div[contains(@class,'price-wallet')]"))
                    .getText();
            actualGoods.add(new Product(name, price));
        }
        return actualGoods;
    }

    public int getSumPriceBasketActual() {
        int sumPriceBasketActual = 0;
        for (WebElement priceElement : priceElementList) {
            sumPriceBasketActual += Integer.parseInt(priceElement.getText().replaceAll("₽", "").replaceAll(" ", ""));
        }
        return sumPriceBasketActual;
    }

    public int getSumPriceBasketExpected() {
        return Integer.parseInt(sumPriceBasketElement.getText().replaceAll("₽", "").replaceAll(" ", ""));
    }

    public void clickButtonCountPlus() {
        js.executeScript("arguments[0].click();", buttonCountPlus);
    }

    public void clickButtonCountMinus() {
        js.executeScript("arguments[0].click();", buttonCountMinus);
    }

    public String getTopCountLine() {
        return topCountLine.getText();
    }
}
