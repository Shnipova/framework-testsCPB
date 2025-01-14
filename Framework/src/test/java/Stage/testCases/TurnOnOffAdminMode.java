package Stage.testCases;

import Stage.pageObjects.AdminMode;
import Stage.pageObjects.CustomProducts;
import org.testng.annotations.Test;

import java.io.IOException;

public class TurnOnOffAdminMode extends BaseClass {

@Test
    public void TurnOnOffAdminMode() throws InterruptedException, IOException {
        driver.get(stageURL);
        logger.info("open stage site");
        CustomProducts cp = new CustomProducts(driver);
        AdminMode ad = new AdminMode(driver);
        cp.switchToIFrame();
        logger.info("switch to iFrame");
        cp.clickEditButton();
        logger.info("click Edit");
        cp.clickAdminMode();
        logger.info("Turn ON Admin Mode");
        cp.clickAdminMode();
        logger.info("Turn OFF Admin Mode");

    }
}
