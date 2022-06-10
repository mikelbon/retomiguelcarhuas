package com.rimac;

import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.Locale;

public class EbayPage extends BaseClass {

    // Search
    public static String txtProduct = "//input[@id=\"gh-ac\"]";
    public static String btnSubmit = "//input[@id=\"gh-btn\"]";

    // Filter
    public static String lnkVerTodos = "(//button[text()='ver todos'])[1]";
    public static String chkBlanco = "//input[@id=\"c3-subPanel-Color_Blanco-0_cbx\"]";
    public static String chkRojo = "//input[@id=\"c3-subPanel-Color_Rojo-0_cbx\"]";
    public static String marca = "//span[text()='Marca']";
    public static String adidas = "//input[@id=\"c3-subPanel-Marca_adidas-0_cbx\"]";
    public static String wilson = "//input[@id=\"c3-subPanel-Marca_Wilson-0_cbx\"]";
    public static String btnApply = "//button[@aria-label=\"Aplicar\"]";
    public static String lblThirdPrice = "(//li[@data-gr4=\"3\"]/descendant::div[@class='s-item__info clearfix']/div/div/span)[1]";
    public static String lblName = "//li[@data-gr4=\"3\"]/descendant::div[@class='s-item__info clearfix']/a/h3";
    public static String lnkClearAll = "//div[text()='Borrar todo']";
    public static String lnkHouseGarden ="(//a[text()='Casa y Jardín'])[2]";
    public static String lnkBricolaje= "//span[text()='Bricolaje']";
    public static String lnkMaterialsBricolaje="//a[text()='Materiales de bricolaje']";
    public static String lnkPuertasGarage= "//div[text()='Puertas de garage']";
    public static String lnkDitec= "//p[text()='Ditec']";
    public static String lnkDitecMandoPrice="(//h3[text()='Entrematic DITEC ZEN2C  - Mando a distancia ']//ancestor::a//following::div/div/span)[1]";

    public static void findProduct(String strProduct) {
        driver.findElement(By.xpath(txtProduct)).sendKeys(strProduct);
        driver.findElement(By.xpath(btnSubmit)).click();
    }

    public static void selectColors() throws InterruptedException {
        driver.findElement(By.xpath(lnkVerTodos)).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath(chkBlanco)).click();
        driver.findElement(By.xpath(chkRojo)).click();
        Thread.sleep(2000);
    }

    public static HashMap<String, Double> selectBrand(String brand) throws InterruptedException {
        selectColors();
        driver.findElement(By.xpath(marca)).click();
        Thread.sleep(5000);
        if (brand.toLowerCase().equals("adidas")) {
            driver.findElement(By.xpath(adidas)).click();
        } else if (brand.toLowerCase().equals("wilson")) {
            driver.findElement(By.xpath(wilson)).click();
        }
        driver.findElement(By.xpath(btnApply)).click();
        Thread.sleep(2000);
        String name = driver.findElement(By.xpath(lblName)).getText();
        double price = Double.parseDouble(driver.findElement(By.xpath(lblThirdPrice)).getText().replace(",", ".").replace(" EUR", ""));
        HashMap<String, Double> sneaker = new HashMap<String, Double>();
        sneaker.put(name, price);
        driver.findElement(By.xpath(lnkClearAll)).click();
        return sneaker;
    }

    public static void selectHouseGarden() throws InterruptedException {
        driver.findElement(By.xpath(lnkHouseGarden)).click();
        Thread.sleep(2000);
    }

    public static void selectBricolaje() throws InterruptedException {
        driver.findElement(By.xpath(lnkBricolaje)).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(lnkMaterialsBricolaje)).click();
    }
    public static void selectPuertasGarage() throws InterruptedException {
        driver.findElement(By.xpath(lnkPuertasGarage)).click();
        Thread.sleep(3000);
    }
    public static void selectDitec() throws InterruptedException {
        driver.findElement(By.xpath(lnkDitec)).click();
        Thread.sleep(2000);
    }
    public static String getPriceDitec() throws InterruptedException {
        String price=driver.findElement(By.xpath(lnkDitecMandoPrice)).getText();
        return price;
    }
}
