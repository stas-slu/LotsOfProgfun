package EventFiringWebDriver.EventFiringWebDriverWithRemoteWebDriver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class MyRemoteWebDriver extends RemoteWebDriver {

    public MyRemoteWebDriver(URL remoteAddress, Capabilities desiredCapabilities) {
        super(remoteAddress, desiredCapabilities);
    }
}