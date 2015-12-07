package EventFiringWebDriver.EventFiringWebDriverWithRemoteWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebDriverListener implements WebDriverEventListener {
    private RemoteWebDriver webDriver;

    public WebDriverListener(RemoteWebDriver webDriver){
        this.webDriver = webDriver;
    }

    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to url printing the browser associated capabilities");
        System.out.println(this.webDriver.getCapabilities());

    }

    public void afterNavigateTo(String url, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeNavigateBack(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterNavigateBack(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeNavigateForward(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterNavigateForward(WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterChangeValueOf(WebElement element, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void beforeScript(String script, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void afterScript(String script, WebDriver driver) {
        // TODO Auto-generated method stub

    }

    public void onException(Throwable throwable, WebDriver driver) {
        // TODO Auto-generated method stub

    }
}