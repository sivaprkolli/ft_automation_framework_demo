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
    By menu = By.id("react-burger-menu-btn");
    By logoutLink = By.id("logout_sidebar_link");

    public String getProductsPageHeading(){
        seleniumWaits.waitForElementVisible(productsHeading);
        return seleniumActions.getTextMessage(productsPageHeading);
    }

    public void logout(){
        seleniumActions.clickOnElement(menu);
        seleniumWaits.waitForElementVisible(logoutLink);
        seleniumActions.clickOnElement(logoutLink);
    }
}
