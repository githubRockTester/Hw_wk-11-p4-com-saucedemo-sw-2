package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest {
    //Set up method and tear down method
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        //calling Method to open the browser with URL
        openBrowser(baseUrl);
    }

    @Test
    public void verityUserShouldLoginSuccessfullyWithValidCredentials() {
        driver.findElement(By.name("user-name")).sendKeys("standard_user");    //Find the login link and enter user ID
        driver.findElement(By.id("password")).sendKeys("secret_sauce");   //Find the password link and enter password
        driver.findElement(By.xpath("//input[@name='login-button']")).click(); //Find the X-path & Click on login button
        String expectedMessage = "Products";                                                //Expected message
        WebElement actualTextElement = driver.findElement(By.xpath("//span[@class='title']")); //find x-path for the dashboard
        String actualMessage = actualTextElement.getText();                         //matching actual with the expected
        Assert.assertEquals("Not redirected to login page", expectedMessage, actualMessage);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Verifying the number of products on the home page
        driver.findElement(By.name("user-name")).sendKeys("standard_user");    //Find the login link and enter user ID
        driver.findElement(By.id("password")).sendKeys("secret_sauce");   //Find the password link and enter password
        driver.findElement(By.xpath("//input[@name='login-button']")).click(); //Find the X-path & Click on login button

        //Class name Locator --- To find multiple elements
        List<WebElement> imageList = driver.findElements(By.xpath("//div[@class='inventory_item']"));
        System.out.println("Total slide: " + imageList.size());
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
