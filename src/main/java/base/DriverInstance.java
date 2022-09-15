package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.FetchConfigProperties;

import java.io.File;

public class DriverInstance {

    public static WebDriver driver = null;

    public static void initiateDriverInstance() throws Exception {
        switch (FetchConfigProperties.fetchPropertyValue("BROWSER")) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addExtensions(new File(System.getProperty("user.dir") + "\\config\\uBlock-Origin.crx"));
                driver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;

            default:
                throw new Exception("Incorrect Browser");
        }
        driver.manage().window().maximize();
        driver.get(FetchConfigProperties.fetchPropertyValue("URL"));
    }

    public static void getDriverInstance() throws Exception {
        if (driver == null) DriverInstance.initiateDriverInstance();
    }

    public static void closeDriver() {
        driver.quit();
    }
}