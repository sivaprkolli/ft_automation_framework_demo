package com.ft.LoginTests;

import com.ft.Automation.FTBase;
import com.ft.Pages.PoundLandPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PoundlandTest extends FTBase {

    @Test
    public void verifyProductAddedToCart(){
        PoundLandPage poundLandPage = new PoundLandPage(driver);
        String productName = poundLandPage.getProductTitle();
        System.out.println("productName :: " + productName);
        String productPrice = poundLandPage.getProductPrice(productName);
        System.out.println("productPrice :: " + productPrice);
        poundLandPage.addProductToCart(productName);
        poundLandPage.navigateToCart();
        Assert.assertEquals(poundLandPage.getCartProductPrice(productName), productPrice);
    }
}
