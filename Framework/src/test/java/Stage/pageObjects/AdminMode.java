package Stage.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    @FindBy(xpath="/html/body/div[2]/div[1]/div/div/div[2]/div[1]/div/div[4]/div/table/tbody[2]/tr/td[2]/div/div/div[1]")
    @CacheLookup
    WebElement uploadImageInChoiceOption;

    @FindBy(xpath = "//*[@id=\"product-builder\"]/div[1]/div/div/div[1]/div[2]/button[3]")
    @CacheLookup
    WebElement saveCustomOption;

    @FindBy (id = "cpb-category-WtRSSjGluho-lm4ifzGPOu0L")
    @CacheLookup
    WebElement sourceElementWantToMove;

    @FindBy(id ="cpb-category-0F9LJ23OxPf71EnnKPpK7IuO")
    @CacheLookup
    WebElement targetElementOnPlace;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div[1]/div[1]/a[2]")

    @CacheLookup
    WebElement previewButtonInHeaderProductPage;

    @FindBy(xpath = "//*[@id=\"product-builder\"]/div[1]/div/div/div[2]/div[2]/div[2]/div[2]/div/button[4]")
    @CacheLookup
    WebElement addToCartButton;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div[2]/div[1]/div/div[1]/div/div[1]/input")
    @CacheLookup
    WebElement titleInputField;





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
    public void enterTitleInCustomOption(){
        wait.until(ExpectedConditions.visibilityOf(titleInputField));
        titleInputField.sendKeys("Image");
    }

    public void uploadImageInChoiceOption(String imageFilePath){
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.elementToBeClickable(uploadImageInChoiceOption));
        uploadImageInChoiceOption.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", uploadImageInChoiceOption);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[2]/div[1]/div/div[4]/div/table/tbody[2]/tr/td[2]/div/div/div[2]/div/div[2]/div/div/div[1]/input")).sendKeys(imageFilePath);
    }

    public void clickOnSaveCustomOption(){
        saveCustomOption.click();
    }

    public void reorderingItems()  {
        Actions actions = new Actions(driver);
        actions.clickAndHold(sourceElementWantToMove).build().perform();
        actions.clickAndHold().moveToElement(targetElementOnPlace).release(targetElementOnPlace).build().perform();

    }

    public void clickOnPreviewModeOnProductPage() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        wait.until(ExpectedConditions.elementToBeClickable(previewButtonInHeaderProductPage));
        previewButtonInHeaderProductPage.click();

        Thread.sleep(3000);
    }




}

