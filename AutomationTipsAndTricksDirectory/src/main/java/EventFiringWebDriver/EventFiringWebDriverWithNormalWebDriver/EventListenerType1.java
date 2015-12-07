package EventFiringWebDriver.EventFiringWebDriverWithNormalWebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

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
 *
 * How to create your own event listener classes? You can create a  event listener class in two ways, those are:
 * 1. By implementing WebDriverEventListener interface
 * 2. By extending AbstractWebDriverEventListener class
 *
 * http://www.seleniummonster.com/eventfiringwebdriver-and-event-listeners-in-selenium/
 *
 * */
public class EventListenerType1 implements WebDriverEventListener {

    @Override
    public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
// Things to be done after changing the value in the webelement argo
    }

    @Override
    public void afterClickOn(WebElement arg0, WebDriver arg1) {
// Things to be done after clicking an element arg0
    }

    @Override
    public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
// Things to be done  after findby of webelement arg1
    }

    @Override
    public void afterNavigateBack(WebDriver arg0) {
// Things to be done after navigating back
    }

    @Override
    public void afterNavigateForward(WebDriver arg0) {
// Things to be done after navigating forward
    }

    @Override
    public void afterNavigateTo(String arg0, WebDriver arg1) {
// Things to be done after navigating to the given URL say, arg0
    }

    @Override
    public void afterScript(String arg0, WebDriver arg1) {
// Things to be done after script execution
    }

    @Override
    public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {
// Things to be done before Changing value in the webelement arg0
    }

    @Override
    public void beforeClickOn(WebElement arg0, WebDriver arg1) {
// Things to be done before Clicking an element arg0
    }

    @Override
    public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
// Things to be done before a Findby of an web element arg1
    }

    @Override
    public void beforeNavigateBack(WebDriver arg0) {
// Things to be done before navigating back
    }

    @Override
    public void beforeNavigateForward(WebDriver arg0) {
// Things to be done before Navigating forward
    }

    @Override
    public void beforeNavigateTo(String arg0, WebDriver arg1) {
// Things to be done before navigating to a url arg0
    }

    @Override
    public void beforeScript(String arg0, WebDriver arg1) {
// Things to be done before javascript execution
    }

    /**
     * In this class we have defined only onException method () and rest are left as empty.
     * Despite, we really don’t care about rest of the events( at least for this hello world example), still we have forced to
     * override every other method. (That’s what implementing an interface all about).
     *
     * For better solution check the next event type listener.
     */
    @Override
    public void onException(Throwable arg0, WebDriver arg1) {
        System.out.println("************************************************************************************************" );
        System.out.println("EventListenerType1: There is an exception in the script, please find the below error description" );
        System.out.println("************************************************************************************************" );
        arg0.printStackTrace();
    }
}