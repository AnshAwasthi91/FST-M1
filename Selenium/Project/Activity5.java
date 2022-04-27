package project_activities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity5 {

    WebDriver driver;
    WebDriverWait wait;
    String url="https://alchemy.hguy.co/lms/";

    @BeforeTest
    public void init(){
        driver=new FirefoxDriver();
        Reporter.log("Webdriver Intantiated..");
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);
        Reporter.log(url+" Launched");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Reporter.log("Page loaded..");
    }

    @AfterTest
    public void teardown(){
        driver.close();
    }

    @Test
    public void verifyMenuItemTitle(){
        WebElement myAccountItem=driver.findElement(By.linkText("My Account"));
        myAccountItem.click();
        WebElement accountPageHeading=driver.findElement(By.tagName("h1"));
        wait.until(ExpectedConditions.visibilityOf(accountPageHeading));
        Assert.assertEquals(accountPageHeading.getText().trim(),"My Account");
        Assert.assertEquals(driver.getTitle(),"My Account – Alchemy LMS");
        Reporter.log("Account Page title validation Passed");
    }
}
