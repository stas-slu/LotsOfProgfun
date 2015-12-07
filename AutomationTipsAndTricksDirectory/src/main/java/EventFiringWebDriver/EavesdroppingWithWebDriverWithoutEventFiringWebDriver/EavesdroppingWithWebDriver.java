package EventFiringWebDriver.EavesdroppingWithWebDriverWithoutEventFiringWebDriver;

import EventFiringWebDriver.EavesdroppingWithWebDriverWithoutEventFiringWebDriver.drivers.MyFunkyExecutor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *  WebDriver already gives us a mechanism so that we can eavesdrop into WebDriver originated events. The way you get this done is by making use of EventFiringWebDriver.
 *  But, not many people know that EventFiringWebDriver has 1 small short-coming. It cannot tap into events that arise out of the Actions class.
 *  This is what this example for.
 *
 *  Lets see how we can append the a CommandListener into a WebDriver instance (ChromeDriver).
 *  Unlike RemoteWebDriver (the mother of all WebDriver implementations), ChromeDriver/FirefoxDriver etc., don’t have an easy way in which the CommandExecutor can be injected into a WebDriver.
 *  That is because the method via which we set the CommandExecutor is a protected method and so its only available within a child class. We will use reflection!
 *
 *  The second example, with RemoteWebDriver, will show how easy is it to append CommandListener to RemoteWebDriver.
 *
 *  https://rationaleemotions.wordpress.com/2015/04/18/eavesdropping-into-webdriver/
 */
public class EavesdroppingWithWebDriver {
    WebDriver webDriver;

    @BeforeClass
    public void setup() {
        webDriver = new ChromeDriver(); //Normal webdriver, can't append listener, reflection used
    }

    @AfterClass
    public void cleanup() {
        webDriver.quit();
    }

    @Test
    public void testMethod() throws NoSuchMethodException {
        //Lets inject our CommandExecutor into the newly created WebDriver instance.
        appendListenerToWebDriver((RemoteWebDriver) webDriver);
        webDriver.get("http://www.yahoo.com");
        System.out.println(webDriver.getTitle());
    }

    private void appendListenerToWebDriver(RemoteWebDriver rwd) {
        CommandExecutor executor = new MyFunkyExecutor(rwd.getCommandExecutor());
        Class clazz = rwd.getClass();
        while (! RemoteWebDriver.class.equals(clazz)) {
            // iterate repeatedly till we get to a RemoteWebDriver reference
            clazz = clazz.getSuperclass();
        }
        try {
            //setCommandExector is the protected method within RemoteWebDriver that is
            //responsible for accepting a command exector.
            Method m = clazz.getDeclaredMethod("setCommandExecutor", CommandExecutor.class);
            //This method is a protected method. So we have to make it accessible.
            m.setAccessible(true);
            m.invoke(rwd, executor);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}