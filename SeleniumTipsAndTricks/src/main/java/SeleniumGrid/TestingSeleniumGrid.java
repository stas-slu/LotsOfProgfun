package SeleniumGrid;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

/**
 * SELENIUM GRID acts as a load balancer, but for tests. It’s primary job is to distribute the tests to different NODES (machines) registered to the server
 * which has the hub. Let’s get started with the same.
 *
 * Selenium Grid 2.0 architecture:
 * https://automatictester.wordpress.com/2012/11/10/selenium-grid-2-0-architecture/
 *
 * Set up of the GRID environment is a two step process.
 * Step 1: Set up the HUB which acts as the Server
 * Step 2: Set up the Node which acts as the Client
 * The test is initiated at the Hub and Nodes run the test and send the results back to Hub (server).
 *
 * What done in the steps?
 * Step 1:
 * Issue the command “java -jar selenium-server-standalone-2.25.0.jar -role hub“ on the server machine.
 * This command starts the selenium server as a GRID hub server. Once the server is started, it looks like the following image.
 * Once the server is running you can verify the state by navigating to http://localhost:4444 in a browser (add an exception for the port 4444 in firewall).
 *
 * Step 2:
 * Set up node:
 * Every node should have java installed. It should also have the same selenium server jar file. Assuming we have them, the command to register machine
 * as a node to already running hub is: “java -jar selenium-server-standalone-2.25.0.jar -role node -hub http://ip-address-of-hub:4444/grid/register”
 *
 * https://automationtestingsimplified.wordpress.com/2012/10/16/starting-with-selenium-grid/
 *
 * Another good guide:
 * https://automatictester.wordpress.com/2012/08/26/selenium-grid-tutorial-from-webdriver-to-grid-2-0/
 */
public class TestingSeleniumGrid {

    private WebDriver driver;
    private String baseUrl;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        //Instantiating the driver object through new RemoteWebDriver() tells the script executor that this script is to be executed through selenium server
        driver = new RemoteWebDriver(capability);
        //driver = new ChromeDriver();
        baseUrl = "https://www.google.com";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitled() throws Exception {
        driver.get(baseUrl + "/");
        WebElement search = driver.findElement(By.name("q"));
        search.clear();
        search.sendKeys("My test!");
        assert search.getText().equals("My test!");
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            System.out.println(verificationErrorString);
        }
    }
}