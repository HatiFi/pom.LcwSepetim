package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class Driver {
    static WebDriver driver;
    @BeforeClass
    public static WebDriver getDriver(){


        if(driver == null){

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;
    }

    @AfterClass
    public static void closeDriver(){
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
    public static void quitDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
