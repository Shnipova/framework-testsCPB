package Stage.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PreviewMode {
    WebDriver driver;
    WebDriverWait wait;
    public PreviewMode(WebDriver driver) {
        //`driver` you pass when you create an instance of `CustomProducts` is saved and used later for methods like `switchToIFrame()`.
        this.driver = driver;
        this.wait = new WebDriverWait(driver,120);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement passwordToStore;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/form/button")
    WebElement submitButton;

    @FindBy(xpath = "//*[@id=\"react-tabs-3\"]/div/div[2]/div[8]/div[2]/div[2]/div/div/label[1]/input")
    @CacheLookup
    WebElement nameInputField;

    @FindBy(xpath = "//*[@id=\"react-tabs-3\"]/div/div[2]/div[8]/div[2]/div[2]/div/div/label[2]/input")
    @CacheLookup
    WebElement textInputField;

    @FindBy(xpath = "//*[@id=\"product-builder\"]/div/div/div/div/div[2]/div[2]/div[2]/div/button[4]")
    @CacheLookup
    WebElement addToCartButtonInPreviewMode;

    @FindBy(xpath = "//*[@id=\"checkout\"]")
    @CacheLookup
    WebElement checkoutButton;


    public void enterPassword() throws InterruptedException {
      //  wait.until(ExpectedConditions.elementToBeClickable(passwordToStore));

        passwordToStore.click();
        passwordToStore.sendKeys("12345");
        submitButton.click();


        Thread.sleep(3000);
    }

    public void uploadImageField(String imageFilePath) throws InterruptedException {


        wait.until(ExpectedConditions.visibilityOf(nameInputField));

        driver.findElement(By.xpath("//*[@id=\"react-tabs-3\"]/div/div[2]/div[6]/div[2]/div[2]/div[1]/div/div/input")).sendKeys(imageFilePath);
    }

    public void enterNameField(){
        wait.until(ExpectedConditions.visibilityOf(nameInputField));
        nameInputField.sendKeys("lana");
    }

    public void enterText() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(textInputField));
        textInputField.sendKeys("LOVE");
        Thread.sleep(3000);
    }

    public void clickOnAddToCart(){
        addToCartButtonInPreviewMode.click();
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
    }





}
