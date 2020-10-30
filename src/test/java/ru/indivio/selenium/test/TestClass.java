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

        for (int i=0 ;i<3;i++){
        WebElement webElement = driver.findElement(By.cssSelector("a.btn.btn-primary"));
        webElement.click();
        }

        driver.get("http://127.0.0.1:8189/geekmarket/cart/");

        List<WebElement> webElementRow = driver
                .findElement(By.cssSelector(".product_line"))
                .findElements(By.cssSelector(".product_count"));
        //List<WebElement> webElementRow = driver.findElements(By.cssSelector(".product_title"));
        //List<WebElement> webElementRow = driver.findElements(By.tagName("tr"));
        for (WebElement obj: webElementRow) {
            String count = obj.getText();
            System.out.println(count);
        }

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int rowCount = webElementRow.size();

        Assert.assertTrue(rowCount>0);

    }

    @AfterSuite
    public void shutdown() {
        this.driver.quit();
    }
}
