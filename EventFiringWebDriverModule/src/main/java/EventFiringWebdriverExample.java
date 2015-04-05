
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class EventFiringWebdriverExample {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        EventFiringWebDriver eventFiringWD= new EventFiringWebDriver(driver);

        EventListenerType2 eventListener = new EventListenerType2();

        //Register the Listener with the event firing driver
        eventFiringWD.register(eventListener);

        eventFiringWD.get("https://www.google.co.in/");

        eventFiringWD.findElement(By.className("nosuchclassName"));

         //Just in case, in any point if you want any listener to stop listening the EventFiringWebDriver, you can do it by simply unregister it.
        eventFiringWD.unregister(eventListener);
    }
}