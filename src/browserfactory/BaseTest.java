package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;

    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver();                        //Launch the URL
        driver.get(baseUrl);                                //To open the URL into Browser using Get method
        driver.manage().window().maximize();                //To maximise the browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  //We give implicit wait to driver
    }

    public void closeBrowser() {
        //To close all the open windows
        driver.quit();
    }
}
