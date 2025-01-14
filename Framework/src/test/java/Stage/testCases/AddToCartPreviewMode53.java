package Stage.testCases;

import Stage.pageObjects.AdminMode;
import Stage.pageObjects.CustomProducts;
import Stage.pageObjects.PreviewMode;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Set;

public class AddToCartPreviewMode53 extends BaseClass{

    @Test
    public void addToCartPrewieMode() throws InterruptedException, IOException {
        driver.get(stageURL);
        logger.info("open stage site");
        CustomProducts cp = new CustomProducts(driver);
        AdminMode ad = new AdminMode(driver);
        cp.switchToIFrame();
        logger.info("switch to iFrame");
        cp.clickEditButton();
        logger.info("click Edit");
        String originalWindow = driver.getWindowHandle();

        ad.clickOnPreviewModeOnProductPage();
        logger.info("Preview button was clicked");
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
        driver.close();

        // Switch back to the original tab
        driver.switchTo().window(originalWindow);
        cp.switchToIFrame();
        logger.info("switch to iFrame");


        ad.clickOnPreviewModeOnProductPage();
        logger.info("Preview button was clicked");

        Thread.sleep(6000);
        windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        Thread.sleep(3000);

        pm.enterNameField();
        logger.info("Name was entered");

        pm.enterText();
        logger.info("Text was entered");

        pm.clickOnAddToCart();
        logger.info("add to cart button was clicked");


        String pageText= driver.getPageSource();

        if (pageText.contains("Copy Of 2 Design Your Own Custom Phone Case")) {
            System.out.println("test pass");
        } else {
            System.out.println("test failed");
        }






    }

}
