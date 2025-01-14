package Stage.testCases;

import Stage.pageObjects.CreateNewProduct;
import Stage.pageObjects.CustomProducts;
import org.testng.annotations.Test;

import java.awt.*;
import java.io.IOException;

public class CreatingProductJSON50 extends BaseClass {


    @Test
    public void creatingProductJson() throws InterruptedException, AWTException, IOException {
        driver.get(stageURL);
        logger.info("open stage site");
        CustomProducts cp = new CustomProducts(driver);
        cp.switchToIFrame();
        logger.info("switch to iFrame");

        cp.clickCreateNew();
        logger.info("Create new button was clicked");
        Thread.sleep(3000);

        CreateNewProduct newProd = new CreateNewProduct(driver);
        newProd.checkTheCheckbox();
        Thread.sleep(3000);
        logger.info("Checkbox was checked");

        newProd.UploadJsonFile(readConfig.getJsonFilePath());
        logger.info("file uploaded");

        newProd.clickOnFillDataButton();
        logger.info("fill data button was clicked ");

        newProd.alertAssertion();
        logger.info("alert is checked");

        newProd.createTitleProduct();
        logger.info("title is created");

        newProd.uploadImageField(readConfig.getImageFilePath());
        logger.info("image uploaded");


        newProd.clickOnCreateButton();
        logger.info("create button was clicked");


        newProd.clickBackToListButton();
        logger.info("Back to list button was clicked");


        newProd.clickOnLeaveButton();
        logger.info("Leave button eas clicked");


    }
}
