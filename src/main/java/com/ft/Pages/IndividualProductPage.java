package com.ft.Pages;

import com.ft.Utilities.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndividualProductPage {

    private ProductsPage productsPage;
    private SeleniumActions seleniumActions;

    public IndividualProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        productsPage = new ProductsPage(driver);
        seleniumActions = new SeleniumActions(driver);
    }

    public boolean isCartIconDisplayed(){
        //return productsPage.getCartIcon().isDisplayed();
        return productsPage.getCartIcon().isDisplayed();
    }

    public void logout(){
        seleniumActions.clickOnElement(productsPage.getLogoutLink());
    }


}
