package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import utils.EventReporter;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    public EventFiringWebDriver driver;
//    protected WelcomePage welcomePage;


    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
        driver.register(new EventReporter());

    }

    @BeforeMethod
    public void goHome() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.get("chrome-extension://gmbpmajieplaijaacagaokjkoefomgjo/home.html#/onboarding");
//        welcomePage = new WelcomePage (driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.addArguments("--system-developer-mode");


        File appDir = new File("src/walletApp");
        File app = new File(appDir, "app.crx");
        System.out.println(app.getAbsolutePath());
        options.addExtensions(new File(app.getAbsolutePath()));
        //options.setHeadless(true);
        return options;
    }


}
