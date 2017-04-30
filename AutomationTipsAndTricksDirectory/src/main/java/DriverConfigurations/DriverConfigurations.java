package DriverConfigurations;

import org.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

/**
 * Relevant to http://stackoverflow.com/questions/11808310/how-to-disable-location-service-by-chromedriver-selenium/21077039#21077039
 */
public class DriverConfigurations {

    WebDriver driver;

    @Before
    public void setupTest() {
        driver = new ChromeDriver();
    }

    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLocationService() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("profile.default_content_settings.geolocation", 2);

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setExperimentalOption("prefs", jsonObject);
        driver = new ChromeDriver(chromeOptions);
    }
}
