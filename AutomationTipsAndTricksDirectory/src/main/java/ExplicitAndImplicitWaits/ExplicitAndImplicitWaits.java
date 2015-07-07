package ExplicitAndImplicitWaits;

import com.google.common.base.Stopwatch;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


/**
 * Don't ever mix Implicit & Explicit waits together:
 * http://stackoverflow.com/questions/29474296/clarification-on-the-cause-of-mixing-implicit-and-explicit-waits-in-selenium-doc
 */
public class ExplicitAndImplicitWaits {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        if(driver != null)
            driver.quit();
    }

    @Test
    public void implicitWaitTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();

        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();

        try
        {
            //new WebDriverWait(driver, TimeSpan.FromSeconds(15)).Until(
            //ExpectedConditions.ElementExists(By.CssSelector("Should Fail")));
            driver.findElement(By.cssSelector("Should Fail"));
        }
        catch ( NoSuchElementException exception )
        //catch ( OpenQA.Selenium.WebDriverTimeoutException)
        {
            stopwatch.stop();
            System.out.println("IMPLICIT WAIT TEST: " + stopwatch.elapsedTime(TimeUnit.SECONDS));
        }
    }

    @Test
    public void explicitWaitTest() {
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();

        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();

        try
        {
            new WebDriverWait(driver, 15).until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("Should Fail")));
            driver.findElement(By.cssSelector("Should Fail"));
        }
        //catch ( NoSuchElementException exception)
        catch ( TimeoutException exception)
        {
            stopwatch.stop();
            System.out.println("EXPLICIT WAIT TEST: " + stopwatch.elapsedTime(TimeUnit.SECONDS));
        }
    }


    @Test
    public void explicitAndImplicitWaitTest() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://www.google.com/");
        driver.manage().window().maximize();

        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();

        try
        {
            new WebDriverWait(driver, 15).until(
                    ExpectedConditions.presenceOfElementLocated(By.cssSelector("Should Fail")));
            driver.findElement(By.cssSelector("Should Fail"));
        }
        //catch ( NoSuchElementException exception)
        catch ( TimeoutException exception)
        {
            stopwatch.stop();
            System.out.println("EXPLICIT AND IMPLICIT WAIT TEST: " + stopwatch.elapsedTime(TimeUnit.SECONDS));
        }
    }
}