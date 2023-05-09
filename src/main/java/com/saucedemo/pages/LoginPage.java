package com.saucedemo.pages;

import com.aventstack.extentreports.Status;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(xpath ="//span[@class='title']" )
    WebElement headingText ;
    @CacheLookup
    @FindBy(id="user-name")
   WebElement usernameField ;

    @CacheLookup
    @FindBy(id ="password")
    WebElement passwordField ;

    @CacheLookup
    @FindBy(xpath ="//input[@id='login-button']" )
    WebElement loginButton ;

    @CacheLookup
    @FindBy (xpath= "//span[contains(text(),'Products')]")
    WebElement textProduct;
    @CacheLookup
    @FindBy(xpath= "//div[@class ='inventory_item']")
    List<WebElement> totalProduct ;

    public String getHeadingText(){
        Reporter.log("Get headingtext " +headingText.toString());
        CustomListeners.test.log(Status.PASS,"Products" + headingText);
        return getTextFromElement(headingText);
    }
    public void enterUsername(String username){
        sendTextToElement(usernameField,username);
        Reporter.log("Enter username " + username + " to username field " +usernameField.toString());
        CustomListeners.test.log(Status.PASS,"Enter username" + username);

    }
    public void enterPassword(String password){
        sendTextToElement(passwordField,password);
        Reporter.log("Enter password " + password + " to password field " +passwordField.toString());
        CustomListeners.test.log(Status.PASS,"Enter password " + password);

    }
    public void clickLoginButton(){
        clickOnElement(loginButton);
        Reporter.log("Click on " +  loginButton.toString());
        CustomListeners.test.log(Status.PASS,"Click on" + loginButton);

    }
    public int countTotalProduct(){
        Reporter.log("Count products " +totalProduct.toString());
       CustomListeners.test.log(Status.PASS,"Count products" + totalProduct);
        return countItem(totalProduct);


    }
}
