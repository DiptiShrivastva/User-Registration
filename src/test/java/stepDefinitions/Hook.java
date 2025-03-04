package stepDefinitions;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import utils.DriverSetup;

public class Hook {

    private static WebDriver driver;

    @BeforeAll
    public static void setUp() {
        if (driver == null) {
            driver = DriverSetup.getDriver();
            driver.manage().window().maximize();
        }
    }

    @AfterAll
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}