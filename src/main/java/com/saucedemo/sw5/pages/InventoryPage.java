package com.saucedemo.sw5.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.sw5.customelistener.CustomListeners;
import com.saucedemo.sw5.utility.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class InventoryPage extends Utilities {

    @CacheLookup
    @FindBy(className ="title" )
    WebElement productsText;

    public String getProductText(){

        Reporter.log("Get Product Text " + productsText.toString());
        CustomListeners.test.log(Status.PASS, "Product Text");
        return getTextFromElement(productsText);

    }
    public int findActualNumberOfProducts(){

        Reporter.log("Finding number of elements" + productsText.getText().toString());
        List<WebElement> productList=findElementsFromWebPage(By.xpath("//img[starts-with(@class,'inventory_item_img')]"));
        CustomListeners.test.log(Status.PASS, productsText.toString());
        return productList.size();
    }

}
