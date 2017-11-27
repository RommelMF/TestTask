package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by rommel on 26.11.17.
 */
public class TestingSite {
    private WebDriver webDriver;

    public TestingSite(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    // return tab home with her web elements
    public HomeTab homeTab(WebDriver webDriver) {
        return new HomeTab(webDriver);
    }
    public LoginTab loginTab(WebDriver webDriver) {
        return new LoginTab(webDriver);
    }
    public AdditionTab additionTab(WebDriver webDriver) {
        return new AdditionTab(webDriver);
    }
}
