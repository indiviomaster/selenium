package ru.indivio.selenium.test;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class TestClass {

    private WebDriver driver;

    @BeforeSuite
    public void init() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    public void seleniumTest() {

        driver.get("http://127.0.0.1:8189/geekmarket/shop/");
        //String link ="/geekmarket/shop/cart/add/6";

        for (int i=0 ;i<3;i++){
        WebElement webElement = driver.findElement(By.cssSelector("a.btn.btn-primary"));
        webElement.click();
        }

        driver.get("http://127.0.0.1:8189/geekmarket/cart/");
        List<WebElement> webElementRow = driver.findElements(By.tagName("tr"));
        int rowCount = webElementRow.size();
        Assert.assertTrue(rowCount>0);

    }

    @AfterSuite
    public void shutdown() {
        this.driver.quit();
    }
}
