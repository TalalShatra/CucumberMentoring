package StepDefinition;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class demoWebShop_editCustomerInfoSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User navigate to demo web shop")
    public void user_navigate_to_demo_web_shop() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://demowebshop.tricentis.com/");

    }
    @Given("User login to account")
    public void user_login_to_account() {

        WebElement loginButton = driver.findElement(By.linkText("Log in"));
        loginButton.click();

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/login"));

        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.sendKeys("batch6@test.com");

        WebElement passwordInput = driver.findElement(By.id("Password"));
        passwordInput.sendKeys("batch6test");

        WebElement loginConfirmButton = driver.findElement(By.cssSelector("input[value='Log in']"));
        loginConfirmButton.click();

        WebElement logoutButton = driver.findElement(By.linkText("Log out"));

        wait.until(ExpectedConditions.visibilityOf(logoutButton));

    }
    @When("User navigate to customer info page")
    public void user_navigate_to_customer_info_page() {

        WebElement accountInfoButton = driver.findElement(By.className("account"));
        accountInfoButton.click();

        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.urlToBe("https://demowebshop.tricentis.com/customer/info"));

    }
    @When("User update first name and last name")
    public void user_update_first_name_and_last_name() {

        WebElement firstNameInput = driver.findElement(By.id("FirstName"));
        firstNameInput.clear();
        firstNameInput.sendKeys("Maria");

        WebElement lastNameInput = driver.findElement(By.id("LastName"));
        lastNameInput.clear();
        lastNameInput.sendKeys("Gherkin");

        WebElement saveButton = driver.findElement(By.cssSelector("input[value='Save']"));
        saveButton.click();

    }
    @Then("First name and last name should be updated")
    public void first_name_and_last_name_should_be_updated() {

        WebElement firstNameInput = driver.findElement(By.id("FirstName"));
        String actualFirstName  = firstNameInput.getAttribute("value");
        String expectedFirstName = "Maria";
        Assert.assertEquals(actualFirstName, expectedFirstName);

        WebElement lastNameInput = driver.findElement(By.id("LastName"));
        String actualLastName = lastNameInput.getAttribute("value");
        String expectedLastName = "Gherkin";
        Assert.assertEquals(actualLastName, expectedLastName);

    }

    @Given("User update email address")
    public void user_update_email_address() {

        WebElement emailInput = driver.findElement(By.id("Email"));
        emailInput.clear();
        emailInput.sendKeys("batch6gherkin@test.com");

        WebElement saveChangesButton = driver.findElement(By.name("save-info-button"));
        saveChangesButton.click();

    }
    @Then("Email address should be updated")
    public void email_address_should_be_updated() {

        WebElement emailInput = driver.findElement(By.id("Email"));
        String actualEmailInput = emailInput.getAttribute("value");
        String expectedEmailInput = "batch6gherkin@test.com";
        Assert.assertEquals(actualEmailInput, expectedEmailInput);

        driver.quit();

    }
}
