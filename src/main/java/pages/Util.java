package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertNotNull;


public class Util {
    //variable
    private WebDriver driver;

    //constrain
    public Util(WebDriver driver) {
        this.driver = driver;
    }
    //actions


    /**
     * this function is responsible for validate if element is present or is element to be clickable ...
     * or any condition to assert element is in the page
     **/
    public boolean validation(By element, ExpectedCondition<WebElement> condition) {
        try {
            Duration timeout = Duration.ofSeconds(30);
            new WebDriverWait(driver, timeout).until(condition);
            return true;
        } catch (Exception e) {
            System.out.println("The Condition Is wrong ");
            return false;

        }
    }


    //click on any button give it button and expected element appears when we click on button
    public void clickOnButton(By element, By expectedElement) {
        try {
            if (validation(element, ExpectedConditions.elementToBeClickable(element))) {
                driver.findElement(element).click();
            }
            Assert.assertTrue(validation(expectedElement,
                    ExpectedConditions.visibilityOf(driver.findElement(expectedElement))), "Expected Element after Click on Button Not present");
        } catch (Exception e) {
            Assert.fail("Couldn't click because of" + e.getMessage());
        }
    }

    public void clickOnButton(By element) {
        try {
            if (validation(element, ExpectedConditions.elementToBeClickable(element))) {
                driver.findElement(element).click();

            }

        } catch (Exception e) {
            Assert.fail("Couldn't click because of" + e.getMessage());
        }

    }


    //*********************************************************************************************
    //this function navigate to any url page and assert if the elemnt appear in the page
    public boolean navigateToPage(String URL, By element) {
        try {
            driver.get(URL);
            validation(element, ExpectedConditions.visibilityOfElementLocated(element));
            return true;
        } catch (Exception e) {
            assertNotNull("can't navigate to page" + URL, validation(element, ExpectedConditions.presenceOfElementLocated(element)));
            return false;
        }
    }

    //*********************************************************************************************
    public void setText(By b, String text, boolean ifYouWantToClearText) {
        WebElement element = driver.findElement(b);
        if (ifYouWantToClearText) {
            element.clear();
        }
        element.sendKeys(text);

        String actualValue = (element.getAttribute("value") == null)
                ? element.getAttribute("innerHTML")
                : element.getAttribute("value");
        Assert.assertEquals(text, actualValue);

    }


    public String getText(By b) {
        try {
            validation(b, ExpectedConditions.presenceOfElementLocated(b));
            System.out.println(driver.findElement(b).getText());
            return driver.findElement(b).getText();

        } catch (Exception e) {
            System.out.println("Text are not found");
            return null;
        }
    }


    public void assertOnMassage(By b, String expectedMessage) {
        if (validation(b, ExpectedConditions.visibilityOfElementLocated(b))) {

            Assert.assertEquals(driver.findElement(b).getText(), expectedMessage);
            System.out.println("expectedMessage: "+expectedMessage);
        } else {
            System.out.println("expectedMessage not appear");
        }

    }

}