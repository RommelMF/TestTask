import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginTab;
import pages.TestingSite;

/**
 * Test for login form
 */
public class FormLoginTests {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private TestingSite webSite;
    private LoginTab loginTab;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, 10, 500);

        webSite = new TestingSite(webDriver);
        loginTab = webSite.loginTab(webDriver);

        webDriver.get("http://rulkov.ru/qa/");
        webDriver.findElement(By.cssSelector("a[ng-href='/qa/login']")).click();
    }

    @Test
    public void testFormLoginPositive() {
        System.out.println("Positive test form login 1");

        loginTab.enterUsername("WQA");
        loginTab.enterPassword("12345");
        loginTab.clickButton();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("value1")));

        Assert.assertTrue(webDriver.getCurrentUrl().contains("rulkov.ru/qa/addition"));
    }
    @Test
    public void testFormLoginNegative1()  {
        System.out.println("Negative test form login 1");

        loginTab.enterUsername("aaaa");
        loginTab.enterPassword("12345");
        loginTab.clickButton();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("value1")));

        Assert.assertFalse(webDriver.getCurrentUrl().contains("rulkov.ru/qa/addition"));
    }
    @Test
    public void testFormLoginNegative2() {
        System.out.println("Negative test form login 2");

        loginTab.enterUsername("______");
        loginTab.enterPassword("12345");
        loginTab.clickButton();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("value1")));

        Assert.assertFalse(webDriver.getCurrentUrl().contains("rulkov.ru/qa/addition"));
    }
    @Test
    public void testFormLoginNegative3() {
        System.out.println("Negative test form login 3");

        loginTab.enterUsername("+&*?");
        loginTab.enterPassword("12345");
        loginTab.clickButton();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("value1")));

        Assert.assertFalse(webDriver.getCurrentUrl().contains("rulkov.ru/qa/addition"));
    }
    @Test
    public void testFormLoginNegative4() {
        System.out.println("Negative test form login 4");

        loginTab.enterUsername("+&*?");
        loginTab.enterPassword("12345");
        loginTab.clickButton();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("value1")));

        Assert.assertFalse(webDriver.getCurrentUrl().contains("rulkov.ru/qa/addition"));
    }
    @Test
    public void testFormLoginNegative5() {
        System.out.println("Negative test form login 5");

        loginTab.enterUsername("WQA");
        loginTab.enterPassword("1111");
        loginTab.clickButton();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("value1")));

        Assert.assertFalse(webDriver.getCurrentUrl().contains("rulkov.ru/qa/addition"));
    }
    @Test
    public void testFormLoginNegative6() {
        System.out.println("Negative test form login 6");

        loginTab.clickButton();

        Assert.assertFalse(webDriver.getCurrentUrl().contains("rulkov.ru/qa/addition"));
    }
    @Test
    public void testFormLoginNegative7() {
        System.out.println("Negative test form login 7");

        loginTab.enterUsername("WQA");
        loginTab.clickButton();

        Assert.assertFalse(webDriver.getCurrentUrl().contains("rulkov.ru/qa/addition"));
    }
    @Test
    public void testFormLoginNegative8() {
        System.out.println("Negative test form login 8");

        loginTab.enterPassword("12345");
        loginTab.clickButton();

        Assert.assertFalse(webDriver.getCurrentUrl().contains("rulkov.ru/qa/addition"));
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}



