package BrowserstackWithJunitAndTestNgWithParallelRuns.usingjunit;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class JUnitTest {
    private static WebDriver driver;

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setPlatform(Platform.MAC);
        capability.setVersion("20.0");
        /*driver = new RemoteWebDriver(
                new URL("http://USERNAME:ACCESS_KEY@hub.browserstack.com/wd/hub"),
                capability
        );*/

        driver = new RemoteWebDriver(
                new URL("http://stass:mxCQS6op7Yw42zkqYEbt@hub.browserstack.com/wd/hub"),
                capability
        );
    }

    @Test
    public void testSimple() throws Exception {
        driver.get("http://www.google.com");
        System.out.println("Page title is: " + driver.getTitle());
        assertEquals("Google", driver.getTitle());
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Browser Stack");
        element.submit();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }
}