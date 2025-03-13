package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
//For running tests in headless mode for gitHub Actions
public class DriverSetup {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = System.getProperty("browser", "chrome"); // Default: Chrome

            if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions options = new FirefoxOptions();
                if (System.getenv("CI") != null) {  // Run headless in CI/CD
                    options.addArguments("--headless");
                }
                driver = new FirefoxDriver(options);
            } else {
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                if (System.getenv("CI") != null) {  // Run headless in CI/CD
                    options.addArguments("--headless");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--disable-dev-shm-usage");
                }
                driver = new ChromeDriver(options);
            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}


/*
 //for running code in headed mode
package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverSetup {
    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            // Read the browser from system property, default to Chrome
            String browser = System.getProperty("browser", "chrome").toLowerCase();

            switch (browser) {
                case "firefox":
                    System.setProperty("web-driver.gecko.driver", "/Users/Users/xyz/Desktop/xyz/GitLearning/User Registration/src/test/java/utils/geckodriver");
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                default:
                    System.setProperty("web-driver.chrome.driver", "/Users/xyz/Desktop/xyz/GitLearning/User Registration/src/test/java/utils/chromedriver");
                    driver = new ChromeDriver();
                    break;
            }
            driver.manage().window().maximize();
        }
        return driver;
    }
}


 */




