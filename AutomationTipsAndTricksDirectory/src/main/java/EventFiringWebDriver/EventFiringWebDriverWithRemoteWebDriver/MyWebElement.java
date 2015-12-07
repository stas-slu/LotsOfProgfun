package EventFiringWebDriver.EventFiringWebDriverWithRemoteWebDriver;
import org.openqa.selenium.WebElement;

public class MyWebElement {
    private WebElement element;

    public MyWebElement(WebElement element) {
        this.element = element;
    }

    public void click() {
        System.out.println("About to perform clicking on a web element");
        validateWebElement();
        element.click();
    }

    public void setElement(WebElement element) {
        this.element = element;
    }

    private void validateWebElement() {
        if (this.element == null)
            throw new IllegalStateException("WebElement cannot be null");
    }
}
