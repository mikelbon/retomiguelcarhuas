package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Contact_Us_Steps {

    private WebDriver driver;

  /*  @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }*/

 /*   @After
    public void tearDown() {
        //driver.quit();
    }*/



    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page() {
        driver.get("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }


    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name_joe(String firstName) {
        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
    }

    @When("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name_blogs(String lastName) {
        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
    }

    @When("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address_joe_blogs123_email_com(String email) {
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);

    }

    @When("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);
    }

    @When("I click on the submit button")
    public void i_click_on_the_submit_button() {
        driver.findElement(By.xpath("//input[@value=\"SUBMIT\"]")).click();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        WebElement contactUs_Submission_Message = driver.findElement(By.xpath("//div[@id='contact_reply']/h1"));
        Assert.assertEquals(contactUs_Submission_Message.getText(), "Thank You for your Message!");
    }
}
