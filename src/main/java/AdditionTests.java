import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AdditionTab;
import pages.LoginTab;
import pages.TestingSite;

/**
 * Tests for addition tab
 */
public class AdditionTests {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private TestingSite webSite;
    private LoginTab loginTab;
    private AdditionTab additionTab;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, 10, 500);

        webSite = new TestingSite(webDriver);
        loginTab = webSite.loginTab(webDriver);
        additionTab = webSite.additionTab(webDriver);

        webDriver.get("http://rulkov.ru/qa/");
        webDriver.findElement(By.cssSelector("a[ng-href='/qa/login']")).click();

        loginTab = new LoginTab(webDriver);
        loginTab.enterUsername("WQA");
        loginTab.enterPassword("12345");
        loginTab.clickButton();
        webDriverWait.until(ExpectedConditions.urlContains("http://rulkov.ru/qa/addition"));
    }
    @Test
    public void testAdditionalPositive() {
        additionTab.enterValue1("1");
        additionTab.enterValue2("1");
        additionTab.enterValue3("1");
        additionTab.clickButtonNext();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("table")));
        additionTab.clickButtonNext();
        additionTab.clickButtonNext();
        int sum = additionTab.getSum();

        Assert.assertTrue(sum == 3);
    }
    @After
    public void tearDown() {
        if(webDriver != null) {
            webDriver.quit();
        }
    }
}
