package com.saucedemo.sw5.testsuite;
import com.saucedemo.sw5.customelistener.CustomListeners;
import com.saucedemo.sw5.pages.InventoryPage;
import com.saucedemo.sw5.pages.LoginPage;
import com.saucedemo.sw5.testbase.BaseTest;
import com.saucedemo.sw5.testsuite.LoginPageTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    InventoryPage inventoryPage;
    LoginPage loginPage ;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        inventoryPage=new InventoryPage();
        loginPage=new LoginPage();
    }

    @Test(groups = {"sanity", "regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        String expectedText = "Products";
        String actualText = inventoryPage.getProductText();
        Assert.assertEquals(actualText, expectedText, "Expected Text does not displayed");
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatSixProductsAreDisplayedOnPage(){
        loginPage.enterUserName("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickOnLoginButton();
        int expectedNumberOfProducts=6;
        int actualNumberOfProducts=inventoryPage.findActualNumberOfProducts();
        Assert.assertEquals(actualNumberOfProducts, expectedNumberOfProducts, "Number of products are not 6");
    }
}

