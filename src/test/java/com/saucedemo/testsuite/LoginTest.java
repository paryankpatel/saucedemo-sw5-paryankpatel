package com.saucedemo.testsuite;
import com.saucedemo.customlisteners.CustomListeners;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)

/**
 * Created by Jay Vaghani
 */
public class LoginTest extends BaseTest {

    // HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIT(){
        // homePage = new HomePage();
        loginPage = new LoginPage();
    }
        @Test(groups = {"sanity","regeression"})
        @Parameters({"Username","Password"})
        public void verifyUserShouldNavigateToLoginPageSuccessfully(String username,String password){
            //homePage.clickOnLoginLink();
            loginPage.enterUsername("standard_user");
            loginPage.enterPassword("secret_sauce");
            loginPage.clickLoginButton();
            Assert.assertEquals(loginPage.getHeadingText(),"Products", "User login is not successfull.");
        }
        @Test(groups = {"smoke","regeression"})
        @Parameters({"Username","Password"})
        public void verifyThatSixProductsAreDisplayedOnPage(String username,String password){
            loginPage.enterUsername("standard_user");
            loginPage.enterPassword("secret_sauce");
            loginPage.clickLoginButton();
            Assert.assertEquals(loginPage.countTotalProduct(), 6, "Products are not displayed correctly");
        }
    }
