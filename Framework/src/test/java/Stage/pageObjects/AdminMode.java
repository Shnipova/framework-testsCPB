package Stage.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class AdminMode {
    WebDriver driver;
    WebDriverWait wait;
    public AdminMode(WebDriver driver) {
        //`driver` you pass when you create an instance of `CustomProducts` is saved and used later for methods like `switchToIFrame()`.
        this.driver = driver;
        this.wait = new WebDriverWait(driver,60);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]/div[2]/div[1]/div[2]")
    @CacheLookup
    WebElement addNewCustomOption;
    @FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/button[1]")
    @CacheLookup
    WebElement reorderToggle;
    public void clickOnAddNewCustomOption() {
        wait.until(ExpectedConditions.elementToBeClickable(addNewCustomOption));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", addNewCustomOption);
    }
    public void clickReorderToggle() {
        wait.until(ExpectedConditions.elementToBeClickable(reorderToggle));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", reorderToggle);
    }
}

