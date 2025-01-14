package Stage.pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class CreateNewProduct {

    WebDriver driver;
    WebDriverWait wait;


    public CreateNewProduct (WebDriver driver) {
        //`driver` you pass when you create an instance of `CustomProducts` is saved and used later for methods like `switchToIFrame()`.
        this.driver = driver;
        this.wait = new WebDriverWait(driver,45);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='Polaris-Checkbox__Backdrop']")
    @CacheLookup
    WebElement checkBox;


    @FindBy(xpath = "//*[@id=\"product-builder\"]/div/div/div/div/div/div/div/div[2]/div[1]/div/div/div[2]/div[2]/div[4]/button")
    @CacheLookup
    WebElement fillDataButton;

    @FindBy(id = "productTitle")
    @CacheLookup
    WebElement titleInputField;

    @FindBy (xpath = "//*[@id=\"product-builder\"]/div/div/div/div/div/div/div/div[3]/div/div[1]/button")
    @CacheLookup
    WebElement createButton;

    @FindBy (xpath = "//*[@id=\"product-builder\"]/div[1]/div/div/div[1]/div[1]/button[1]")
    @CacheLookup
    WebElement backToProductListButton;



    @FindBy(xpath = "/html/body/div[3]/div/div[6]/button[1]")
    @CacheLookup
    WebElement leaveButton;

    @FindBy(css = "body > div.swal2-container.swal2-center.swal2-backdrop-show > div > div.swal2-actions > button.swal2-confirm.swal2-styled.swal2-default-outline")
    @CacheLookup
    WebElement leaveButtonForSpecificProduct;

    @FindBy(id = "productDescription")
    @CacheLookup
    WebElement descriptionInput;

    @FindBy(id = "productBasePrice")
    @CacheLookup
    WebElement priceInput;

    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div[1]/div[2]/button[3]")
    @CacheLookup
    WebElement saveProductButton;



    public void checkTheCheckbox(){
        wait.until(ExpectedConditions.elementToBeClickable(checkBox));
        checkBox.click();
    }

    public void UploadJsonFile(String pathFile){
        driver.findElement(By.xpath("//*[@id=\"product-builder\"]/div/div/div/div/div/div/div/div[2]/div[1]/div/div/div[2]/div[2]/div[2]/div/div/input")).sendKeys(pathFile);
    }



    public void clickOnFillDataButton(){
            wait.until(ExpectedConditions.elementToBeClickable(fillDataButton));
            fillDataButton.click();
    }



    public void alertAssertion(){
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/div")));

        String modalText = modal.getText();
        Assert.assertTrue(modalText.contains("Product Data Has Been Successfully Uploaded"), "Modal message does not match!");

    }

    public void createTitleProduct(){
        titleInputField.clear();
        titleInputField.sendKeys("Amazing phone case with ribbon");
    }

    public void uploadImageField(String imageFilePath){
        driver.findElement(By.xpath("//*[@id=\"product-builder\"]/div/div/div/div/div/div/div/div[2]/div[3]/div/input")).sendKeys(imageFilePath);
    }

    public void clickOnCreateButton(){
        wait.until(ExpectedConditions.elementToBeClickable(createButton));
        createButton.click();
    }
     public void clickBackToListButton(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@id=\"product-builder\"]/div[1]/div/div/div[2]/div[2]/div[2]/div[2]/div/button[4]")));
        wait.until(ExpectedConditions.elementToBeClickable(backToProductListButton));
        backToProductListButton.click();
     }

     public void clickBackInProductAfterSafeOption(){
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"product-builder\"]/div[1]/div/div/div[1]/div[1]/button[1]")));
        driver.findElement(By.xpath("//*[@id=\"product-builder\"]/div[1]/div/div/div[1]/div[1]/button[1]")).click();
     }

     public void clickOnLeaveButton()
     {
         wait.until(ExpectedConditions.elementToBeClickable(leaveButton));
         JavascriptExecutor js = (JavascriptExecutor) driver;
         js.executeScript("arguments[0].click();", leaveButton);
     }
    public void clickOnLeaveButtonOnSpecificPage()
    {
        wait.until(ExpectedConditions.elementToBeClickable(leaveButtonForSpecificProduct));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", leaveButtonForSpecificProduct);
    }

    public void assertionTest() {
        WebElement createButton = driver.findElement(By.xpath("//*[@id=\"product-builder\"]/div/div/div/div[2]/h2/div/button"));

        wait.until(ExpectedConditions.elementToBeClickable(createButton));
        if (driver.getPageSource().contains("Copy Of upload testAmazing phone case with ribbon")) {
            Assert.assertTrue(true);
           System.out.println("pass");
        } else {

            Assert.assertFalse(false);
            System.out.println("failed");
        }
    }

    public void createDescription(){
        descriptionInput.sendKeys("cases for iphone only");
    }
    public void providePrice(){
      priceInput.sendKeys("10");
    }

    public void clickOnSaveProductButton(){
        wait.until(ExpectedConditions.elementToBeClickable(saveProductButton));
        saveProductButton.click();
    }

    public void alertAssertionAfterSavingTheProduct(){
        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div > div")));

        String modalText = modal.getText();
        Assert.assertTrue(modalText.contains("Your product has been saved" ), "Modal message does not match!");

    }

    public void assertionAfterCreatingTheProduct(){
        WebElement productList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("list-group")));
        List<WebElement> products = productList.findElements(By.className("product-list-item-title"));
        String newProductName = "Copy Of upload testAmazing Phone Case";
        boolean productFound = false;

        for (WebElement product : products) {
            if (product.getText().contains(newProductName)) {
                productFound = true;
                break;
            }
        }

        Assert.assertTrue(productFound, "The new product was not found in the product list.");

    }

}
