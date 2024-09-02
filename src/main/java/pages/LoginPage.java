package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {
    //variable
    WebDriver driver;
    String loginUrl = "https://www.saucedemo.com/";
    Util utilPage;
    HomePage homePage;
    //constrain
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        utilPage = new Util(this.driver);
        homePage=new HomePage(driver);
    }

    //element
    private By elementToValidate = By.xpath("//Div[text()='Swag Labs']");
    private By userNameLocator= By.id("user-name");
    private By passwordLocator= By.id("password");
    private By loginButtonLocator = By.id("login-button");
    private By ErrorMassegeLocator = By.xpath("//*[@id='login_button_container']/div/form/div[3]/h3");




    //action

    public void navigateToLoinPage() {
        utilPage.navigateToPage(loginUrl, elementToValidate);
    }

    public void userCanLogin(String userName,String password) {
       utilPage.setText(userNameLocator,userName,false);
        utilPage.setText(passwordLocator,password,false);
        utilPage.clickOnButton(loginButtonLocator);
    }
    public void validateOnErrorMessage(String ErrorMassage){
        utilPage.assertOnMassage(ErrorMassegeLocator,ErrorMassage);
    }



}

