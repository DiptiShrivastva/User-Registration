package stepDefinitions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import utils.DriverSetup;

public class RegistrationSteps {

    WebDriver driver;

    public RegistrationSteps() {
        this.driver = Hook.getDriver(); // Use shared WebDriver from Hooks.java
    }

    @Given("I am on the registration page")
    public void i_am_on_the_registration_page() {
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    //  Scenario 4: Successful Registration
    @When("I fill in the registration form with {string}, {string}, {string}, {string}, and {string}")
    public void fill_registration_form(String firstName, String lastName, String email, String password, String confirmPassword) {
        driver.findElement(By.id("member_firstname")).sendKeys(firstName);
        driver.findElement(By.id("member_lastname")).sendKeys(lastName);
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(confirmPassword);
        driver.findElement(By.id("dp")).sendKeys("01/03/1984");

        // Accept terms & conditions
        driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div:nth-child(1) > label")).click();
        //AgeAccept
        driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div.md-checkbox.margin-top-10 > label")).click();
        //Basketball England Code of Ethics and Conduct
        driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(7) > label")).click();
        driver.findElement(By.cssSelector("input[value='CONFIRM AND JOIN']")).click();
    }

    @Then("I should see either {string} or {string}")
    public void i_should_see_either(String expectedOutcome1, String expectedOutcome2) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        String actualMessage = "";

        try {
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("body > div > div.page-content-wrapper > div > h2")
            ));
            actualMessage = successMessage.getText();
            //when new user is getting registered
        } catch (TimeoutException e1) {
            try {
                WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.cssSelector("#titleText1")
                ));
                actualMessage = errorMessage.getText();
                //when user account already exists
            } catch (TimeoutException e2) {
                Assert.fail("Neither expected message was found!");
            }
        }

        System.out.println("Actual message: " + actualMessage);
        Assert.assertTrue("Expected: " + expectedOutcome1 + " or " + expectedOutcome2 + " but found: " + actualMessage,
                actualMessage.contains(expectedOutcome1) || actualMessage.contains(expectedOutcome2));
    }

    //  Scenario 1: Missing Last Name
    @When("I fill in the registration form without last name {string}, {string}, {string}, {string}, and {string}")
    public void i_fill_in_the_registration_form_without_last_name(String firstName, String lastName, String email, String password, String confirmPassword) {
        driver.findElement(By.id("member_firstname")).sendKeys(firstName);
        driver.findElement(By.id("member_lastname")).sendKeys(lastName);
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(confirmPassword);
        driver.findElement(By.id("dp")).sendKeys("01/03/1984");
        // Accept terms & conditions
        driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div:nth-child(1) > label")).click();
        //AgeAccept
        driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div.md-checkbox.margin-top-10 > label")).click();
        //Basketball England Code of Ethics and Conduct
        driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(7) > label")).click();
        driver.findElement(By.cssSelector("input[value='CONFIRM AND JOIN']")).click();
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedErrorMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#signup_form > div:nth-child(6) > div:nth-child(2) > div > span > span")
        ));

        // Get the actual error message text
        String actualErrorMessage = errorElement.getText();

        // Print the actual error message to console
        System.out.println("Actual Error Message Displayed: " + actualErrorMessage);

        // Assert the expected vs actual message
        Assert.assertEquals("Error message did not match!", expectedErrorMessage, actualErrorMessage);
    }

    //  Scenario 2: Password Mismatch
    @When("I fill in the registration form with mismatched password {string}, {string}, {string}, {string}, and {string}")
    public void i_fill_in_the_registration_form_with_mismatched_password(String firstName, String lastName, String email, String password, String confirmPassword) {
        driver.findElement(By.id("member_firstname")).sendKeys(firstName);
        driver.findElement(By.id("member_lastname")).sendKeys(lastName);
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(confirmPassword);
        driver.findElement(By.id("dp")).sendKeys("01/03/1984");
        // Accept terms & conditions
        driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div:nth-child(1) > label")).click();
        //AgeAccept
        driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div.md-checkbox.margin-top-10 > label")).click();
        //Basketball England Code of Ethics and Conduct
        driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(7) > label")).click();
        driver.findElement(By.cssSelector("input[value='CONFIRM AND JOIN']")).click();
    }

    @Then("I should see a password mismatch error")
    public void i_should_see_a_password_mismatch_error() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#signup_form > div:nth-child(9) > div > div.row > div:nth-child(2) > div > span > span")
        ));
        String actualErrorMessage = errorElement.getText();
        System.out.println("Error message displayed: " + actualErrorMessage);
        Assert.assertEquals("Password mismatch error did not appear!", "Password did not match", errorElement.getText());
    }

    //  Scenario 3: Terms & Conditions Not Accepted
    @When("I fill without term and condition {string}, {string}, {string}, {string}, and {string}")
    public void i_fill_in_the_registration_form_without_accepting_terms(String firstName, String lastName, String email, String password, String confirmPassword) {
        driver.findElement(By.id("member_firstname")).sendKeys(firstName);
        driver.findElement(By.id("member_lastname")).sendKeys(lastName);
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(password);
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(confirmPassword);
        driver.findElement(By.id("dp")).sendKeys("01/03/1984");
        // Skipp terms & conditions
        //AgeAccept
        driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div.md-checkbox.margin-top-10 > label")).click();
        //Basketball England Code of Ethics and Conduct
        driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(7) > label")).click();
        driver.findElement(By.cssSelector("input[value='CONFIRM AND JOIN']")).click();
    }

    @Then("I should see a terms and conditions error")
    public void i_should_see_a_terms_and_conditions_error() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div:nth-child(1) > span > span")
        ));

        // Get and print the actual error message
        String actualErrorMessage = errorElement.getText();
        System.out.println("Actual error message displayed: " + actualErrorMessage);

        // Assert the expected message
        Assert.assertEquals("Terms and conditions error did not appear!",
                "You must confirm that you have read and accepted our Terms and Conditions",
                actualErrorMessage);
    }



}



