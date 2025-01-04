package com.ft.Pages;

import com.ft.Utilities.SeleniumActions;
import com.ft.Utilities.SeleniumWaits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    SeleniumActions seleniumActions;
    SeleniumWaits seleniumWaits;

    public ProductsPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumActions(driver);
        seleniumWaits = new SeleniumWaits(driver);

    }

    @FindBy(css = ".title") private WebElement productsPageHeading;

    By productsHeading = By.cssSelector(".title");

    public String getProductsPageHeading(){
        seleniumWaits.waitForElementVisible(productsHeading);
        return seleniumActions.getTextMessage(productsPageHeading);
    }
}
