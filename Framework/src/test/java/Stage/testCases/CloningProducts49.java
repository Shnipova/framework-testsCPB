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
        logger.info("click Clone");
        Thread.sleep(3000);
        cp.clickDeleteButton();
        logger.info("click Delete");
        Thread.sleep(3000);
        cp.clickYesConformationForDelete();
        logger.info("yes clicked");

        Thread.sleep(300);

    }
}
