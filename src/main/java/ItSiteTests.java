import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TestingSite;

/**
 * Tests
 */
public class ItSiteTests {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private TestingSite webSite;

    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver, 30, 500);

        webSite = new TestingSite(webDriver);

        webDriver.get("http://rulkov.ru/qa/");
        System.out.println("test title");

    }
    @Test
    public void testTransitionToTAbHome() {
        System.out.println("Test transition to tab Home");

//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("nav navbar-nav")));
        webDriver.findElement(By.cssSelector("a[ng-href='/']")).click();

        Assert.assertTrue(webDriver.getCurrentUrl().contains("rulkov.ru/qa/"));
    }
    @Test
    public void testTransitionToTAbAdditional() {
        System.out.println("Test transition to tab Addition");

//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("nav navbar-nav")));
        webDriver.findElement(By.cssSelector("a[ng-href='/qa/addition']")).click();

        Assert.assertTrue(webDriver.getCurrentUrl().contains("rulkov.ru/qa/addition"));
    }
    @Test
    public void testTransitionToTAbLogin() {
        System.out.println("Test transition to tab Login");

//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("nav navbar-nav")));
        webDriver.findElement(By.cssSelector("a[ng-href='/qa/login']")).click();

        Assert.assertTrue(webDriver.getCurrentUrl().contains("rulkov.ru/qa/login"));
    }
    @Test
    public void testTransitionToTAbLogout() {
        System.out.println("Test transition to tab Logout");

//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.className("nav navbar-nav")));
        webDriver.findElement(By.cssSelector("a[ng-href='/qa/logout']")).click();

        Assert.assertTrue(webDriver.getCurrentUrl().contains("rulkov.ru/qa/logout"));
    }

    }

//    @After
//    public void tearDown() {
//        if(webDriver != null) {
//            webDriver.quit();
//        }
//    }

