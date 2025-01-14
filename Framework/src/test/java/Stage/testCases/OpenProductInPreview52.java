package Stage.testCases;

import Stage.pageObjects.AdminMode;
import Stage.pageObjects.CustomProducts;
import Stage.pageObjects.PreviewMode;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class OpenProductInPreview52 extends BaseClass{
    @Test
    public void OpenProductInPreview() throws InterruptedException, IOException {
        driver.get(stageURL);
        logger.info("open stage site");
        CustomProducts cp = new CustomProducts(driver);
        AdminMode ad = new AdminMode(driver);
        cp.switchToIFrame();
        logger.info("switch to iFrame");
        cp.clickOnPreviewButtonAtProductList();
        logger.info("clicked On preview button");

        String originalWindow = driver.getWindowHandle();



        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }


        PreviewMode pm= new PreviewMode(driver);
        pm.enterPassword();
        logger.info("password was entered");

        driver.switchTo().window(originalWindow);

        cp.switchToIFrame();
        logger.info("switch to iFrame");


        cp.clickOnPreviewButtonAtProductList();
        logger.info("clicked On preview button");



    }
}
