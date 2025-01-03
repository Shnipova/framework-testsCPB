package Stage.testCases;
import Stage.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    ReadConfig readConfig = new ReadConfig();
    public String stageURL = readConfig.getApplicationURL();
    public static WebDriver driver;
    public static Logger logger;



    @Parameters("browser")
    @BeforeClass
    public void setUp(@Optional ("safari") String br)
    {
        logger = Logger.getLogger("CPB Stage");
        PropertyConfigurator.configure("log4j.properties");

        if (br.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", readConfig.getChromeDriverPath());
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (br.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", readConfig.getFireFoxDriverPath());
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (br.equals("edge")) {
            System.setProperty("webdriver.edge.driver", readConfig.getEdgeDriverPath());
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        } else if (br.equals("safari")) {
            System.setProperty("webdriver.safari.driver", readConfig.getSafariDriverPath());
            driver = new SafariDriver();
            driver.manage().window().maximize();
        }
        driver.get(stageURL);
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir")+ "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");

    }

    @AfterClass
    public void tearDown()
    {
        if(driver!=null) {
            driver.quit();
        }
    }
}
