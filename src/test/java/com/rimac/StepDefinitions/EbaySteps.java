package com.rimac.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.Normal;

public class EbaySteps {
    private WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("I access the ebay website")
    public void i_access_the_ebay_website() {
        driver.get("https://www.ebay.es/");
    }

    @When("I find sneaker {string}")
    public void i_find_sneaker(String shoe) {
        driver.findElement(By.xpath("//input[@id=\"gh-ac\"]")).sendKeys(shoe);
        driver.findElement(By.xpath("//input[@id=\"gh-btn\"]")).click();


    }

    @When("I filter by {word} and {word} color")
    public void i_filter_by_blanco_and_rojo_color(String color1, String color2) throws InterruptedException {
        driver.findElement(By.xpath("(//button[text()='ver todos'])[1]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id=\"c3-subPanel-Color_" + color1 + "-0_cbx\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"c3-subPanel-Color_" + color2 + "-0_cbx\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Marca']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id=\"c3-subPanel-Marca_adidas-0_cbx\"]")).click();
        driver.findElement(By.xpath("//button[@aria-label=\"Aplicar\"]")).click();
        Thread.sleep(2000);
        String price1=driver.findElement(By.xpath("(//li[@data-gr4=\"3\"]/descendant::div[@class='s-item__info clearfix']/div/div/span)[1]")).getText();
        System.out.println(price1);

        driver.findElement(By.xpath("//div[text()='Borrar todo']")).click();
        // marca wilson
        driver.findElement(By.xpath("(//button[text()='ver todos'])[1]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id=\"c3-subPanel-Color_" + color1 + "-0_cbx\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"c3-subPanel-Color_" + color2 + "-0_cbx\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[text()='Marca']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id=\"c3-subPanel-Marca_Wilson-0_cbx\"]")).click();
        driver.findElement(By.xpath("//button[@aria-label=\"Aplicar\"]")).click();
        Thread.sleep(2000);
        String price2=driver.findElement(By.xpath("(//li[@data-gr4=\"3\"]/descendant::div[@class='s-item__info clearfix']/div/div/span)[1]")).getText();
        System.out.println(price2);


    }

    @When("brand is")
    public void brand_is(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

    @Then("I get the price of the third shoe")
    public void i_get_the_price_of_the_third_shoe() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
