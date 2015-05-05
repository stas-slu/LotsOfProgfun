package BrowserstackWithJunitAndTestNgWithParallelRuns;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStack {

    public static void main(String args[]) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capability = DesiredCapabilities.firefox();
        /*WebDriver driver = new RemoteWebDriver(
                new URL("http://USERNAME:ACCESS_KEY@hub.browserstack.com/wd/hub"),
                capability
        );    */
        WebDriver driver = new RemoteWebDriver(
                new URL("http://stass:mxCQS6op7Yw42zkqYEbt@hub.browserstack.com/wd/hub"),
                capability
        );
        driver.get("http://www.google.com");
        System.out.println("Page title is: " + driver.getTitle());
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("BrowserstackWithJunitAndTestNgWithParallelRuns.BrowserStack");
        element.submit();
        System.out.println("And the Title is: " + driver.getTitle());
        driver.quit();
    }
}