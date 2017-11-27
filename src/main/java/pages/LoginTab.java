package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Tab login
 */
public class LoginTab {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(id = "username")
    WebElement usernameInputField;

    @FindBy(id = "password")
    WebElement passwordInputField;

    @FindBy(css = "button[type='submit']")
    WebElement buttonAuth;

    public LoginTab(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 30, 500);

        PageFactory.initElements(webDriver, this);
    }
    // enter login
    public void enterUsername(String username) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        usernameInputField.clear();
        usernameInputField.sendKeys(username);
    }
    // enter password
    public void enterPassword(String password) {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("password")));
        passwordInputField.clear();
        passwordInputField.sendKeys(password);
    }
    //click button
    public void clickButton() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[type='submit']")));
        buttonAuth.click();
    }
}
