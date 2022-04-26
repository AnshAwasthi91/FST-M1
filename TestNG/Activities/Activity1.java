package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {

    WebDriver driver;
    String aboutUsId="about-link";

    @BeforeMethod
    public void init(){
        System.out.println("Initializing browser..");
        driver=new FirefoxDriver();
        System.out.println("Launching browser..");
        driver.get("https://www.training-support.net/");
    }

    @Test
    public void openBrowser(){
        System.out.println("Page Title:"+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Training Support");
        driver.findElement(By.id(aboutUsId)).click();
        System.out.println("Page Title:"+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"About Training Support");

    }

    @AfterMethod
    public void teardown(){
        System.out.println("Closing browser..");
        driver.close();
    }
}
