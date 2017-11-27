package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by rommel on 26.11.17.
 */
public class HomeTab {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public HomeTab(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 30);

        PageFactory.initElements(webDriver, this);
    }
}
