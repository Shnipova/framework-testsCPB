package Stage.testCases;

import Stage.pageObjects.AdminMode;
import Stage.pageObjects.CustomProducts;
import org.testng.annotations.Test;

import java.io.IOException;

public class ReorderModeProductPage extends BaseClass {
    @Test


    public void ReorderModeProductPage() throws InterruptedException, IOException {
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

        ad.clickReorderToggle();
        logger.info("reorder mode turn on");

        ad.reorderingItems();
        logger.info("2 elements were switched");


    }
}