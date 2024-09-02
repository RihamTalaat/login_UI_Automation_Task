package tests;


import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.Util;
import utility.TestDataProvider;

import java.util.concurrent.TimeUnit;
/*
this class for login page locators and methods
 */

public class LoginTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    @Test(dataProvider = "csvValidDataProvider", dataProviderClass = TestDataProvider.class)
    public void UC01_userCanLoginWithValidData(String userName, String Password) {
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoinPage();
        loginPage.userCanLogin(userName, Password);
        homePage = new HomePage(driver);
        homePage.userLoginSuccessfully();
    }

    @Test(dataProvider = "csvInvalidDataProvider", dataProviderClass = TestDataProvider.class)
    public void UC02_userCantLogin(String userName, String Password, String errorMassage) {
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoinPage();
        loginPage.userCanLogin(userName, Password);
        loginPage.validateOnErrorMessage(errorMassage);
    }




}
