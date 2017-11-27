package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Tab addition
 */
public class AdditionTab {
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    @FindBy(id = "value1")
    WebElement inputValue1Field;
    @FindBy(id = "value2")
    WebElement inputValue2Field;
    @FindBy(id = "value3")
    WebElement inputValue3Field;
    @FindBy(css = "input[value='Вперед']")
    WebElement buttonNext;
    @FindBy(id = "Назад")
    WebElement buttonPrevious;


    public AdditionTab(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 30, 500);

        PageFactory.initElements(webDriver, this);
    }
    public void enterValue1(String value) {
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.))
        inputValue1Field.clear();
        inputValue1Field.sendKeys(value);
    }
    public void enterValue2(String value) {
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.))
        inputValue2Field.clear();
        inputValue2Field.sendKeys(value);
    }
    public void enterValue3(String value) {
//        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.))
        inputValue3Field.clear();
        inputValue3Field.sendKeys(value);
    }
    public void clickButtonNext() {
        buttonNext.click();
    }
    public void clickButtonPrevious() {
        buttonPrevious.click();
    }
    public int getSum() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[value='Вернуться к вводу данных']")));
        String s = webDriver.findElement(By.cssSelector("tr[ng-class='{'bg-success:!(vm.getSum()%2)'}']")).findElement(By.tagName("td")).getText();
        System.out.println(s);
        return 1;
    }
}
