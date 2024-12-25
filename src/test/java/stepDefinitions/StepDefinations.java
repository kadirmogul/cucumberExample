package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.LoginPage;
import utilities.MyDriver;

import java.time.Duration;

public class StepDefinations {
   private WebDriver driver;
    LoginPage loginPage;

    @Given("go to login page")
    public void go_to_login_page() {

    driver.get("https://practicetestautomation.com/practice-test-login/");

    }

    @And("user types username as {string}")
    public void user_types_username_as(String username) {
        loginPage=new LoginPage(driver);
        loginPage.setUsername(username);
    }

    @And("user types password as {string}")
    public void user_types_password_as(String password) {
        loginPage.setPassword(password);
    }

    @When("click button")
    public void click_button() {
        loginPage.clikButton();
    }
    @Then("assert to success massage")
    public void assert_to_success_massage() {
        loginPage.AssertToSuccess();
        MyDriver.closeDriver();
    }


    @Given("setting driver")
    public void settingDriver() {
        driver=MyDriver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Given("go to home page")
    public void goToHomePage() {
        driver.get("https://practicetestautomation.com/");
    }

    @When("wait for two second")
    public void waitForTwoSecond() {
        try {
            Thread.sleep(Duration.ofSeconds(2));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("see {string} text")
    public void seeText(String text) {

        WebElement helloMessageWe= driver.findElement(By.className("post-title"));
        String helloMessage=helloMessageWe.getText();
        Assert.assertTrue(helloMessage.equals(text));
        MyDriver.closeDriver();

    }
}

