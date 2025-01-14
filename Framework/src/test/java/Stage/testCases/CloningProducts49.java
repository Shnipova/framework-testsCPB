package Stage.testCases;


import Stage.pageObjects.CustomProducts;
import org.testng.annotations.Test;

public class CloningProducts49 extends BaseClass{
    @Test

    public void cloningProducts49() throws InterruptedException {
        driver.get(stageURL);
        logger.info("open stage site");
        CustomProducts cp = new CustomProducts(driver);
        cp.switchToIFrame();
        logger.info("switch to iFrame");

        cp.clickCloneButton();
        logger.info("particular product was cloned");


        cp.clickDeleteButton();
        logger.info("particular product was deleted");
         cp.clickYesConformationForDelete();



        Thread.sleep(300);

    }
}
