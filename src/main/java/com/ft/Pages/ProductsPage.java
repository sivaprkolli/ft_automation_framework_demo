package com.ft.Pages;

import com.ft.Utilities.SeleniumActions;
import com.ft.Utilities.SeleniumWaits;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    SeleniumActions seleniumActions;
    SeleniumWaits seleniumWaits;

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumActions(driver);
        seleniumWaits = new SeleniumWaits(driver);
    }

    @Getter
    @FindBy(css = ".title")
    private WebElement productsPageHeading;

    @FindBy(css = ".shopping_cart_link")
    private WebElement cartIcon;

    private By productsHeading = By.cssSelector(".title");
    private By menu = By.id("react-burger-menu-btn");
    private By logoutLink = By.id("logout_sidebar_link");

    public By getLogoutLink(){
        return logoutLink;
    }

    public WebElement getCartIcon(){
        return cartIcon;
    }

    public String getProductsPageHeading() {
        seleniumWaits.waitForElementVisible(productsHeading);
        return seleniumActions.getTextMessage(productsPageHeading);
    }

    public void logout() {
        seleniumActions.clickOnElement(menu);
        seleniumWaits.waitForElementVisible(logoutLink);
        seleniumActions.clickOnElement(logoutLink);
    }
}
