package EventFiringWebDriver.EventFiringWebDriverWithNormalWebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;


/**
 * AbstractWebDriverEventListener is an abstract class that implements WebDriverEventListener interface.
 * So it has overridden all the methods of WebDriverEventListener Interface with no steps.
 * Now we can extend AbstractWebDriverEventListener class and define methods only which we really care about.
 */
public class EventListenerType2 extends AbstractWebDriverEventListener {

    @Override
    public void onException(Throwable arg0, WebDriver arg1) {
        System.out.println("************************************************************************************************" );
        System.out.println("EventListenerType2: There is an exception in the script, please find the below error description" );
        System.out.println("************************************************************************************************" );
        arg0.printStackTrace();
    }
}