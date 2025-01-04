package com.ft.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumWaits {
    WebDriverWait webDriverWait;

    public SeleniumWaits(WebDriver driver){
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitForElementVisible(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementVisible(By by){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }


}
