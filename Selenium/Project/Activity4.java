package project_activities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity4 {

    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor executor;
    String url="https://alchemy.hguy.co/lms/";

    @BeforeTest
    public void init(){
        driver=new FirefoxDriver();
        executor=(JavascriptExecutor)driver;
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
    public void verifyPopularCourseTitle(){
        WebElement courseTitle=driver.findElement(By.xpath("//article[@id='post-71']//h3"));
        executor.executeScript("arguments[0].scrollIntoView(true);",courseTitle);
        Assert.assertEquals(courseTitle.getText(),"Email Marketing Strategies");
        Reporter.log("Course title validation Passed");
    }
}
