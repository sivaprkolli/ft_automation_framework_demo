package com.ft.LoginTests;

import com.ft.Automation.FTBase;
import com.ft.Pages.LoginPage;
import com.ft.Pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyLoginSuccess extends FTBase {
    public LoginPage loginPage;
    public ProductsPage productsPage;

    @BeforeClass
    public void initialize(){
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    @Test
    public void verifyLogin(){
        loginPage.login("performance_glitch_user", "secret_sauce");
        String heading = productsPage.getProductsPageHeading();
        Assert.assertEquals(heading, "Product");
    }
}
