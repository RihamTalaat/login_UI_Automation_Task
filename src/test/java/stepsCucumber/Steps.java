package stepsCucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BrowserAction;
import pages.HomePage;
import pages.LoginPage;

public class Steps  {
    public  WebDriver driver;
    public BrowserAction browserAction;
    LoginPage loginPage;


    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Setup the browser and navigate to login page
        browserAction = new BrowserAction (driver);
        driver = browserAction.driverSetup("chrome");
        browserAction.maxBrowser();
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoinPage();
    }

    @When("the user logs in with {string} and {string}")
    public void the_user_logs_in_with_credentials(String userName, String password) {
        // Login using the provided username and password
        loginPage.userCanLogin(userName, password);
    }

    @Then("the user should see the message {string}")
    public void the_user_should_see_the_message(String errorMessage) {
        // Validate the error message
        loginPage.validateOnErrorMessage(errorMessage);
        driver.quit();
    }

    }


