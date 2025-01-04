package com.ft.Pages;

import com.ft.Utilities.SeleniumActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    private SeleniumActions seleniumActions;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        seleniumActions = new SeleniumActions(driver);
    }

    @FindBy(css = "#user-name") private WebElement userNameInputField;
    @FindBy(css = "[data-test='password']") private WebElement passwordInputField;
    @FindBy(css = "[value='Login']") private WebElement submitButton;

    private By userNameInputBox = By.cssSelector("#user-name");
    private By passwordInputBox = By.cssSelector("[data-test='password']");
    private By loginButton = By.cssSelector("[value='LOGIN']");

    public void login(String username, String password){
        seleniumActions.enterValue(userNameInputField, username);
        seleniumActions.enterValue(passwordInputField, password);
        seleniumActions.clickOnElement(submitButton);
    }
}
