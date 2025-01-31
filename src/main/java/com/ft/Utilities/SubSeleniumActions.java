package com.ft.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SubSeleniumActions extends SeleniumActions{

    private WebDriver driver;

    public SubSeleniumActions(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @Override
    public void clickOnElement(WebElement element){
        // move to element
        element.click();
    }

    @Override
    public void enterValue(WebElement element, String data){
        element.clear();
        element.sendKeys(data);
    }
}
