package EventFiringWebDriver.EventFiringWebDriverWithRemoteWebDriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Selenium offers a range of event listening functions to track almost all of the events happening during your test script execution.
 *
 * How it works?
 *
 * The Listeners use to listen for the events in the registered webdriver.
 * It can be any type of event or action. Say, page navigation, element click, changing values in
 * a text field (analogy to javascript onXYZ () series methods) and even exceptions.
 *
 * To enable this feature:
 *
 * 1. create our own user defined Event listener class
 * 2. Create an EventFiringWebDriverobject by means of webdriver instance
 * 3. Register the Listener to the EventFiringWebDriver instance.
 **
 * https://gist.github.com/krmahadevan/1728633
 */
public class ClassWithListener {

    @Test
    public void testMethod() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setBrowserName(DesiredCapabilities.firefox().getBrowserName());

        MyRemoteWebDriver webDriver = new MyRemoteWebDriver(new URL(MyConstants.URL.toString()), dc);
        EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(webDriver);
        WebDriverListener eventListener = new WebDriverListener(webDriver);
        eventFiringWebDriver.register(eventListener);

        eventFiringWebDriver.get("http://www.linkedin.com/");
        MyWebElement element = new MyWebElement(webDriver.findElement(By.name("search")));
        element.click();
        eventFiringWebDriver.quit();
    }
}

enum MyConstants {
    URL("http://localhost:4444/wd/hub");

    private String value;

    private MyConstants(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}