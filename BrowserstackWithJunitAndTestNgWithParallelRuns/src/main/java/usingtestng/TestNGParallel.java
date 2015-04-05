package usingtestng;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestNGParallel {
    /**
     * Test should be run from the xml file (the XML need to be exeuted)
     */

    private WebDriver driver;

    @BeforeClass
    @org.testng.annotations.Parameters(value={"browser","version","platform"})
    public void setUp(String browser, String version, String platform) throws Exception {
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("platform",platform);
        capability.setCapability("browser", browser);
        capability.setCapability("browserVersion", version);
        capability.setCapability("project", "P1");
        capability.setCapability("build", "1.0");
        System.out.println("Current test capabilities: " + platform + ", " + browser + ", " + version);
        driver = new RemoteWebDriver(new URL("http://stass:mxCQS6op7Yw42zkqYEbt@hub.browserstack.com/wd/hub"), capability);
    }

    @Test
    public void testSimple() throws Exception {
        driver.get("http://www.google.com");
        System.out.println("Page title is: " + driver.getTitle());
        Assert.assertEquals("Google", driver.getTitle());
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Browser Stack");
        element.submit();
        driver = new Augmenter().augment(driver);
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("TestNG-Screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() throws Exception {
        driver.quit();
    }
}