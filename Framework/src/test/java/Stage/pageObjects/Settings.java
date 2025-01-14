package Stage.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Settings {
    WebDriver driver;
    WebDriverWait wait;
    public Settings (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,120);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id=\"product-builder\"]/div[1]/div/div/div[1]/div[1]/button[2]")
    @CacheLookup
    WebElement settingsButton;

    @FindBy(xpath = "/html/body/div[3]/div[4]/div/div/div/div[2]/div/div/div/div[2]/div/div/div[7]/div[1]/div/div[1]")
    @CacheLookup
    WebElement importExport;

    @FindBy(xpath = "//*[@id=\"Panel-0\"]/div/div/div[7]/div[1]/div/div[2]/div[1]/div[2]/label/span[1]/div/div[1]")
    @CacheLookup
    WebElement radioButton;

    @FindBy(xpath = "//*[@id=\"Panel-0\"]/div/div/div[7]/div[1]/div/div[2]/div[3]/button")
    @CacheLookup
    WebElement downloadButton;

    public void clickOnSettingsButton(){
        wait.until(ExpectedConditions.elementToBeClickable(settingsButton));
        settingsButton.click();
    }

    public void clickOnImportExport(){
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.elementToBeClickable(importExport));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", importExport);
        importExport.click();
    }

    public void clickOnExportButton(){
        wait.until(ExpectedConditions.elementToBeClickable(radioButton));
        radioButton.click();
    }

    public void clickOnDownloadButton(){
        wait.until(ExpectedConditions.elementToBeClickable(downloadButton));
        downloadButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(downloadButton));
    }


}
