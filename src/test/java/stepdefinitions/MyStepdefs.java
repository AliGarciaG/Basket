// Namn: Ali Garcia
// MyStepdefs.java
// Datum : 240422

package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class MyStepdefs {
    private WebDriver driver;
    private String actual;
    private String expected;

    @Given("I have entered date of birth {string}")
    public void iHaveEnteredDateOfBirth(String date) {
        driver = new ChromeDriver();
        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
        driver.manage().window().setSize(new Dimension(1696, 1026));
        driver.findElement(By.id("dp")).sendKeys(date);
    }

    @And("I have entered first name {string}")
    public void iHaveEnteredFirstName(String first) {
        driver.findElement(By.id("member_firstname")).click();
        driver.findElement(By.id("member_firstname")).sendKeys(first);
    }

    @And("I have entered last name {string}")
    public void iHaveEnteredLastName(String last) {
        driver.findElement(By.id("member_lastname")).click();
        driver.findElement(By.id("member_lastname")).sendKeys(last);
    }

    @And("I have entered email and confirmed email {string}")
    public void iHaveEnteredEmailAndConfirmedEmail(String email) {
        driver.findElement(By.id("member_emailaddress")).sendKeys(email);
        driver.findElement(By.id("member_confirmemailaddress")).sendKeys(email);
    }

    @And("I have entered password {string} and confirmed password {string}")
    public void iHaveEnteredPasswordAndConfirmedPassword(String password1, String password2) {
        driver.findElement(By.id("signupunlicenced_password")).sendKeys(password1);
        driver.findElement(By.id("signupunlicenced_confirmpassword")).sendKeys(password2);
    }

    @And("I have entered terms and conditions")
    public void iHaveEnteredTermsAndConditions() {
        driver.findElement(By.cssSelector(".md-checkbox > .md-checkbox:nth-child(1) .box")).click();
    }

    @And("I have checked Over 18 and code of conduct")
    public void iHaveCheckedOverAndCodeOfConduct() {
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(2) > label > .box")).click();
        driver.findElement(By.cssSelector(".md-checkbox:nth-child(7) .box")).click();
    }

    @When("I press the join button")
    public void iPressTheJoinButton() {
        driver.findElement(By.name("join")).click();
    }

    @Then("I am registered")
    public void iAmRegistered() {
        expected = "THANK YOU FOR CREATING AN ACCOUNT WITH BASKETBALL ENGLAND";
        WebElement element = driver.findElement(By.cssSelector("body > div > div.page-content-wrapper > div > h2"));
        actual = element.getText();
        //Alt. String actual = driver.findElement(By.cssSelector("body > div > div.page-content-wrapper > div > h2")).getText();
        assertEquals(expected, actual);
        //driver.close();
    }

    @Then("I am not registered and get error code {string}")
    public void iAmNotRegisteredAndGetErrorCode(String expected) {
        if (expected.equals("Last Name is required")) {
            actual = driver.findElement(By.cssSelector("#signup_form > div:nth-child(6) > div:nth-child(2) > div > span > span")).getText();
        } else if (expected.equals("Password did not match")) {
            WebElement element = driver.findElement(By.cssSelector("#signup_form > div:nth-child(9) > div > div.row > div:nth-child(2) > div > span > span"));
            actual = element.getText();
        } else if (expected.equals("You must confirm that you have read and accepted our Terms and Conditions")) {
            WebElement element = driver.findElement(By.cssSelector("#signup_form > div:nth-child(12) > div > div:nth-child(2) > div:nth-child(1) > span > span"));
            actual = element.getText();
        }
        assertEquals(expected, actual);
        //driver.close();
    }
}