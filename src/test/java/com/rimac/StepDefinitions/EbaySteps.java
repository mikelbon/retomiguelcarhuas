package com.rimac.StepDefinitions;

import com.rimac.BaseClass;
import com.rimac.EbayPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class EbaySteps extends BaseClass {
    public static String nameProductMoreExpensive = "";
    public static String nameProductCurrent = "";
    public static Double priceProductMoreExpensive = 0.0;
    public static String sPriceProductCurrent = "";
    public static Double priceProductCurrent = 0.0;

    @Before
    public void setup() {
        setDriver();
    }

    @After
    public void tearDown() {
        closeDriver();
    }

    @Given("I access the ebay website")
    public void i_access_the_ebay_website() {
        navigateToHome();
    }

    @When("I find sneaker {string}")
    public void i_find_sneaker(String shoe) {
        EbayPage.findProduct(shoe);
    }

    @When("I filter by {word} and {word} color")
    public void i_filter_by_blanco_and_rojo_color(String color1, String color2) throws InterruptedException {

    }

    @When("brand is")
    public void brand_is(DataTable brands) throws InterruptedException {
        List<Map<String, String>> brand = brands.asMaps(String.class, String.class);
        String brand1 = brand.get(0).get("brands");
        String brand2 = brand.get(1).get("brands");
        System.out.println("marcas");
        nameProductCurrent = EbayPage.selectBrand(brand1).toString().replace("{", "").replace("}", "");
        sPriceProductCurrent = nameProductCurrent.substring(nameProductCurrent.lastIndexOf("=") + 1);
        priceProductCurrent = Double.parseDouble(sPriceProductCurrent);
        if (priceProductCurrent > priceProductMoreExpensive) {
            priceProductMoreExpensive = priceProductCurrent;
            nameProductMoreExpensive = nameProductCurrent;
        }
        nameProductCurrent = EbayPage.selectBrand(brand2).toString().replace("{", "").replace("}", "");
        sPriceProductCurrent = nameProductCurrent.substring(nameProductCurrent.lastIndexOf("=") + 1);
        priceProductCurrent = Double.parseDouble(sPriceProductCurrent);
        if (priceProductCurrent > priceProductMoreExpensive) {
            priceProductMoreExpensive = priceProductCurrent;
            nameProductMoreExpensive = nameProductCurrent;
        }
    }

    @Then("I get the price of the third shoe")
    public void i_get_the_price_of_the_third_shoe() {
        System.out.println("****************************");
        System.out.println("***  ZAPATILLA MAS CARA  ***");
        System.out.println("PRODUCTO: " + nameProductMoreExpensive);
        System.out.println("PRECIO: " + priceProductMoreExpensive + " EUR");
        System.out.println("****************************");
    }


    @When("buyer goes to {string}")
    public void buyer_goes_to(String optionMenu) throws InterruptedException {
        if (optionMenu.equals("House and Garden")) {
            EbayPage.selectHouseGarden();
        } else if (optionMenu.equals("materiales de bricolaje")) {
            EbayPage.selectBricolaje();
        } else if (optionMenu.equals("Puertas de Garage")) {
            EbayPage.selectPuertasGarage();
        }
    }

    @When("buyer select {word} option")
    public void buyer_select_ditec_option(String string) throws InterruptedException {
        EbayPage.selectDitec();
    }

    @Then("price should be {string}")
    public void price_should_be(String string) throws InterruptedException {
        String price = EbayPage.getPriceDitec();
        Assert.assertEquals(price,"19,00 EUR");
    }
}
