package Stage.testCases;

import Stage.pageObjects.CreateNewProduct;
import Stage.pageObjects.CustomProducts;
import org.testng.annotations.Test;

public class CreateNewProduct5 extends BaseClass{

    @Test
    public void createNewProductManually() throws InterruptedException {
        driver.get(stageURL);
        logger.info("open stage site");
        CustomProducts cp = new CustomProducts(driver);
        cp.switchToIFrame();
        logger.info("switch to iFrame");

        cp.clickCreateNew();
        logger.info("Create new button was clicked");
        Thread.sleep(3000);

        CreateNewProduct newProd = new CreateNewProduct(driver);
        newProd.createTitleProduct();
        logger.info("title was created");

        newProd.createDescription();
        logger.info("description was created");

        newProd.providePrice();
        logger.info("price was provided");

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
