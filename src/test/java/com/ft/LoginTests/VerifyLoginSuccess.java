package com.ft.LoginTests;

import com.ft.Automation.FTBase;
import com.ft.Pages.LoginPage;
import com.ft.Pages.ProductsPage;
import com.ft.Utilities.ReadDataFromExcel;
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

    @Test(dataProvider = "loginDetails", dataProviderClass = ReadDataFromExcel.class)
    public void verifyLogin(String number, String email, String password){
        loginPage.login(email, password);
        String heading = productsPage.getProductsPageHeading();
        Assert.assertEquals(heading, "Products");
        productsPage.logout();
    }
}
