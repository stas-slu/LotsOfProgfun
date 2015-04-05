import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.core.har.HarEntry;
import net.lightbody.bmp.proxy.ProxyServer;
import net.lightbody.bmp.proxy.http.BrowserMobHttpRequest;
import net.lightbody.bmp.proxy.http.RequestInterceptor;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.ArrayList;
import java.util.List;

public class ProxyIntercaptingAndFilteringRequestsAndBlacklistingUrls {

    public static void main(String[] args) throws Exception {

        /**
         * The proxy we using:
         * https://github.com/lightbody/browsermob-proxy
         *
         * Scenario inspired by:
         * http://elementalselenium.com/tips/67-broken-images
         * http://stackoverflow.com/questions/15295471/how-to-disable-loading-external-urls-on-seleniumlibrary-robotframework
         */

        // start the proxy
        ProxyServer server = new ProxyServer(4444);
        server.start();
        Proxy proxy = server.seleniumProxy(); // get the Selenium proxy object

        // configure PROXY as a desired capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, proxy);
        WebDriver driver = new ChromeDriver(capabilities);

        interceptingRequestAndOpeningSite(server, driver);

        brokenImages(server, driver);

        blacklistingRequest(server, driver);
    }

    private static void interceptingRequestAndOpeningSite(ProxyServer server, WebDriver driver) {
        // create a new HAR with the label "yahoo.com"
        server.newHar("yahoo.com"); //HAR stands for HTTP Archive. This is a common format for recording HTTP tracing information

        server.addRequestInterceptor(new RequestInterceptor() {
            @Override
            public void process(BrowserMobHttpRequest request, Har har) {
                request.getMethod().removeHeaders("User-Agent");
                request.getMethod().addHeader("User-Agent", "Bananabot/1.0");
                System.out.println("New request line: " + request.getMethod().getRequestLine());
            }
        });

        // open yahoo.com
        System.out.println("URL at step 0: " + driver.getCurrentUrl());
        System.out.println("HAR log size at step 0: " + server.getHar().getLog().getEntries().size());
        driver.get("http://yahoo.com");
        System.out.println("URL at step 1: " + driver.getCurrentUrl());
        System.out.println("HAR log size at step 1: " + server.getHar().getLog().getEntries().size());
    }

    private static void brokenImages(ProxyServer server, WebDriver driver) {
        //new http archive for the new page we going to test
        server.newHar("the-internet.herokuapp.com");
        driver.get("http://the-internet.herokuapp.com/broken_images");
        List<WebElement> allImages = driver.findElements(By.tagName("img"));
        System.out.println("Number of images on page: " + allImages.size());

        List<HarEntry> entries = server.getHar().getLog().getEntries();

        List<WebElement> brokenImages = new ArrayList<WebElement>();
        for (WebElement image : allImages){
            String imgSrc = image.getAttribute("src");
            for(HarEntry harEntry: entries){
                String harEntryRequestUrl = harEntry.getRequest().getUrl();
                if(imgSrc.equals(harEntryRequestUrl) && isHarEntryGotErroneousResponse(harEntry)){
                    if(!brokenImages.contains(image)){
                        brokenImages.add(image);
                    }
                }
            }
        }

        System.out.println("Number of broken images on page: " + brokenImages.size());
        for (WebElement brokenImage : brokenImages){
            System.out.println("Broken image: " + brokenImage.getAttribute("src"));
        }
    }

    private static void blacklistingRequest(ProxyServer server, WebDriver driver) {
        server.blacklistRequests("http://.*\\.wix.com/.*", 400);
        driver.get("http://www.wix.com"); //Should NOT get opened!
    }

    private static boolean isHarEntryGotErroneousResponse(HarEntry harEntry) {
        int status = harEntry.getResponse().getStatus();
        return status == 404 || status == 400 || status == 500;
    }
}
