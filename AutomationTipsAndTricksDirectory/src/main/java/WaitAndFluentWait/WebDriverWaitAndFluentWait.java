package WaitAndFluentWait;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.Assert.assertFalse;

public class WebDriverWaitAndFluentWait {
    WebDriver driver;
    WebElement button;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setCapability("driver.switches", Arrays.asList("--start-maximized"));
        driver = new ChromeDriver(dc);
        driver.manage().window().maximize();
        driver.get("http://www.google.com");
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("\"Stas Slutsker\"");
        button = driver.findElement(By.cssSelector("[name=btnK]"));
    }

    @After
    public void tearDown() {
        if(driver != null)
            driver.quit();
    }

    @Test
    public void testWebDriverWait() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOf(button)).click();
        assertTwitterLinkExists();
    }

    @Test
    public void testFluentWait() {
        new FluentWait<WebElement>(button).withTimeout(3, SECONDS)
                .pollingEvery(100, MILLISECONDS)
                .until(new Function<WebElement, Boolean>() {
                    public Boolean apply(WebElement w) {
                        return w.isDisplayed();
                    }
                });
        button.click();
        assertTwitterLinkExists();
    }

    @Test
    public void testFluentWaitPredicate() {
        new FluentWait<WebElement>(button).withTimeout(3, SECONDS)
                .pollingEvery(100, MILLISECONDS)
                .until(new Predicate<WebElement>() {
                    public boolean apply(WebElement w) {
                        return w.isDisplayed();
                    }
                });
        button.click();
        assertTwitterLinkExists();
    }

    private void assertTwitterLinkExists() {
        final String linkText = "Twitter";
        try {
            new FluentWait<WebDriver>(driver).withTimeout(3, SECONDS)
                    .pollingEvery(100, MILLISECONDS)
                    .ignoring(NoSuchElementException.class)
                    .until(new Function<WebDriver, Boolean>() {
                        public Boolean apply(WebDriver d) {
                            List<WebElement> links = d.findElements(By.partialLinkText(linkText));
                            System.out.println("Links are: " + links.toString());
                            return links.size() > 0;
                        }
                    });
        } catch(TimeoutException te) {
            assertFalse(String.format("Timeout waiting for link: '%s'", linkText), true);
        }
    }
}