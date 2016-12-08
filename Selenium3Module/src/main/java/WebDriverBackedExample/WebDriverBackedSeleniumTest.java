package WebDriverBackedExample;



import com.thoughtworks.selenium.Selenium;
import com.thoughtworks.selenium.webdriven.WebDriverBackedSelenium;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebDriverBackedSeleniumTest {

    @Test
    public void selenium3withWebDriverBackedSelenium(){

        WebDriver driver = new ChromeDriver();

        String baseUrl = "http://www.compendiumdev.co.uk";
        Selenium selenium = new WebDriverBackedSelenium(driver, baseUrl);

        selenium.open("/selenium");

        Assert.assertEquals(true, selenium.getTitle().startsWith("Selenium Simplified"));

        // according to official docs need to use .stop() otherwise JVM continues to run
        selenium.stop();

        // after a quit, you cannot use the Firefox driver
        driver.quit();
    }
}
