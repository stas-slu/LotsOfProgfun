package EventFiringWebDriver.EavesdroppingWithWebDriverWithoutEventFiringWebDriver;

import EventFiringWebDriver.EavesdroppingWithWebDriverWithoutEventFiringWebDriver.drivers.EavesdroppingWebDriver;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class EavesdroppingWithRemoteWebDriver {
    WebDriver webDriver;

    @BeforeClass
    public void setup() throws MalformedURLException {
        webDriver = new EavesdroppingWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox()); //RemoteWebDriver inside, can append listener (inside)
    }

    @Test
    public void testMethod() {
        webDriver.get("http://www.yahoo.com");
        System.out.println("Title : " + webDriver.getTitle());
    }

    @AfterClass
    public void cleanup() {
        webDriver.quit();
    }
}
