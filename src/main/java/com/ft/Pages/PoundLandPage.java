package com.ft.Pages;

import org.apache.logging.log4j.util.PropertiesUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PoundLandPage {
    private WebDriver driver;

    public PoundLandPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = ".nosto-product-name")
    private List<WebElement> productTitles;

    @FindBy(css = "[class-toggle='minicart--open'] > span.cart-badge")
    private List<WebElement> cartIcon;

    @FindBy(xpath = "//table[@id='shopping-cart-table']/descendant::strong/a")
    private WebElement cartProductTitle;

    @FindBy(xpath = "//table[@id='shopping-cart-table']/descendant::td[@data-th='Price']//span[@class=\"price\"]")
    private WebElement cartProductPrice;

    String addButtonXpath = "//a[@class='nosto-product-name'][text()='%s']/following-sibling::div/button";
    String priceXpath = "//a[@class='nosto-product-name'][text()='%s']/following-sibling::div/div[@class='bottom-info-price']/a";

    public String getProductTitle() {

        List<String> productNames = new ArrayList<>();

        for(int i=0; i<productTitles.size(); i++){
            String name = productTitles.get(i).getText().trim();
            if (name.equals("")){

            }else {
                productNames.add(name);
            }
        }
        //System.out.println(productNames.remove(""));
        System.out.println(productNames);
        return productNames.get(0);
    }

    public String getProductPrice(String product) {

        List<WebElement> prices = driver.findElements(By.xpath(String.format(priceXpath, product)));

        String actualPrice1 = prices.get(0).getText().trim();
        String actualPrice2 = prices.get(1).getText().trim();
        return actualPrice1 + actualPrice2;
    }

    public void addProductToCart(String product) {
        driver.findElement(By.xpath(String.format(addButtonXpath, product))).click();
    }

    public void navigateToCart() {
        cartIcon.get(1).click();
    }

    public String getCartProductPrice(String product) {
        return driver.findElement(By.xpath("(//a[text()='"+product+"']/ancestor::td/following-sibling::td/descendant::span[@class='price'])[1]")).getText();
    }

}
