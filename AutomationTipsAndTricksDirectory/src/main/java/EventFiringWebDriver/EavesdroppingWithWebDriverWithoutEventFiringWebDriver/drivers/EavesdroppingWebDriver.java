package EventFiringWebDriver.EavesdroppingWithWebDriverWithoutEventFiringWebDriver.drivers;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.HttpCommandExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class EavesdroppingWebDriver extends RemoteWebDriver {

    public EavesdroppingWebDriver(URL remoteAddress, Capabilities desiredCapabilities) {
        super(remoteAddress, desiredCapabilities);

        setCommandExecutor(new MyFunkyExecutor(new HttpCommandExecutor(remoteAddress))); //Appending my CommandExecutor!
    }
}
