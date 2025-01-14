package Stage.testCases;

import Stage.pageObjects.AdminMode;
import Stage.pageObjects.CustomProducts;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
public class CPB15 extends BaseClass{
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

        Thread.sleep(3000);

        if(driver.getPageSource().contains("Edit Custom Option"))
        {
            Assert.assertTrue(true);
            logger.info("test passed");
        }else{
           captureScreen(driver,"CPB15");
            Assert.assertFalse(false);
            logger.info("test failed");
        }
    }
}



