package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    //variable
    WebDriver driver;
    String homeUrl = "https://www.saucedemo.com/inventory.html";
    Util utilPage;

    //constrain
    public HomePage(WebDriver driver) {
        this.driver = driver;
        utilPage = new Util(this.driver);

    }

    //element
   public By elementToValidate = By.xpath("//*[@id='header_container']/div[1]/div[2]/div");

    //action
    public void userLoginSuccessfully(){
        utilPage.assertOnMassage(elementToValidate,"Swag Labs");
    }



}

