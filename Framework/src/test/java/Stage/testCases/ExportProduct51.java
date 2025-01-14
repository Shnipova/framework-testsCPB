package Stage.testCases;

import Stage.pageObjects.AdminMode;
import Stage.pageObjects.CustomProducts;
import Stage.pageObjects.Settings;
import org.testng.annotations.Test;

import java.io.IOException;

public class ExportProduct51 extends BaseClass{
    @Test
    public void exportProduct51() throws InterruptedException, IOException {
        driver.get(stageURL);
        logger.info("open stage site");
        CustomProducts cp = new CustomProducts(driver);
        AdminMode ad = new AdminMode(driver);
        cp.switchToIFrame();
        logger.info("switch to iFrame");
        cp.clickEditButton();
        logger.info("click Edit");

        Thread.sleep(3000);

        Settings settings = new Settings(driver);
        settings.clickOnSettingsButton();
        logger.info("Settings button was clicked");

        settings.clickOnImportExport();
        logger.info("import/export was clicked");

        settings.clickOnExportButton();
        logger.info("radio export button was clicked ");

        settings.clickOnDownloadButton();
        logger.info("download button was clicked");
    }
}
