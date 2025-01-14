package Stage.testCases;

import Stage.pageObjects.AdminMode;
import Stage.pageObjects.CreateNewProduct;
import Stage.pageObjects.CustomProducts;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddNewCustomOption54 extends BaseClass{
    @Test
    public void CPB15() throws InterruptedException, IOException {
        driver.get(stageURL);
        logger.info("open stage site");
        CustomProducts cp = new CustomProducts(driver);
        AdminMode ad = new AdminMode(driver);
        cp.switchToIFrame();
        logger.info("switch to iFrame");
        cp.clickEditButton();
        logger.info("click Edit");
        cp.clickAdminMode();
        logger.info("click Admin Mode");
        ad.clickOnAddNewCustomOption();
        logger.info("click on New Custom Option");


        ad.enterTitleInCustomOption();
        logger.info("Title was entered");

        ad.uploadImageInChoiceOption(readConfig.getImageFilePath());
        logger.info("image uploaded");


        ad.clickOnSaveCustomOption();
        logger.info("custom option was saved");

        CreateNewProduct newProd=new CreateNewProduct(driver);
        newProd.clickOnSaveProductButton();
        logger.info("product was saved");

        newProd.clickBackInProductAfterSafeOption();
        logger.info("back to list button was clicked");
        newProd.clickOnLeaveButtonOnSpecificPage();
        logger.info("leave button was clicked");


    }

}
