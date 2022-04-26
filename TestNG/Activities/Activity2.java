package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {

    WebDriver driver;
    String aboutUsId="about-link";

    @BeforeMethod
    public void init(){
        System.out.println("Initializing browser..");
        driver=new FirefoxDriver();
        System.out.println("Launching browser..");
        driver.get("https://www.training-support.net/selenium/target-practice/");
    }

    @Test
    public void pageTitleCheck(){
        System.out.println("Page Title:"+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Target Practice");
    }

    @Test
    public void blackBtnIncorrectCheck(){
        WebElement blackBtn=driver.findElement(By.cssSelector(".black"));
        Assert.assertEquals(blackBtn.getCssValue("color"),"rgba(33, 186, 69, 1)");
    }

    @Test(enabled = false)
    public void disabledMethodTest(){
        System.out.println("This method will be skipped w/o shwoing skipped..");
    }

    @Test
    public void skipMethodTest(){
        System.out.println("This method will be skipped and shown as Skipped..");
        throw new SkipException("Skipping Test..");
    }

    @AfterMethod
    public void teardown(){
        System.out.println("Closing browser..");
        driver.close();
    }
}
