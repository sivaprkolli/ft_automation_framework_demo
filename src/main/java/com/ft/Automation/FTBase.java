package com.ft.Automation;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class FTBase {

    public WebDriver driver;

    public void launchBrowser(String browser){
        switch (browser){
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
        }
    }

    @Parameters({"browserName"})
    @BeforeSuite
    public void setUp(String browser){
        launchBrowser(browser);
    }

    @Parameters("url")
    @BeforeTest
    public void launchApplication(String app){
        driver.get(app);
    }

    @Parameters("url")
    @AfterMethod(dependsOnMethods = "getScreenshotIfTestFails")
    public void reLoadApplication(ITestResult iTestResult, String app){
        if (iTestResult.getStatus() == ITestResult.FAILURE){
            driver.get(app);
        }
    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }

    public void captureScreenshot() throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir")+"/screenshots/test.png");
        FileUtils.copyFile(source, destination);
    }

    @AfterMethod
    public void getScreenshotIfTestFails(ITestResult iTestResult) throws IOException {
        System.out.println("iTestResult.getStatus() :: " + iTestResult.getStatus());
        System.out.println("ITestResult.FAILURE :: " + ITestResult.FAILURE);
        if (iTestResult.getStatus() == ITestResult.FAILURE){
            captureScreenshot();
        }
    }
}
