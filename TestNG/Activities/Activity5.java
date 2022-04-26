package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.*;

public class Activity5 {

    WebDriver driver;
    String aboutUsId="about-link";

    @BeforeClass(alwaysRun = true)
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

    @Test(groups = {"HeaderTests"})
    public void headerTest(){
        WebElement thirdHeader=driver.findElement(By.id("third-header"));
        Assert.assertEquals(thirdHeader.getText(),"Third header");
        WebElement fifthHeader=driver.findElement(By.cssSelector("h5.green"));
        String rgbColor=fifthHeader.getCssValue("color");
        String hexColor= Color.fromString(rgbColor).asHex();
        System.out.println("RGB Color:"+rgbColor);
        System.out.println("Hexa Color:"+hexColor);
        Color fifthHeaderColor=Color.fromString(hexColor);
        Color fifthHeaderColor2=Color.fromString("rgba(33, 186, 69, 1)");
        Assert.assertEquals(fifthHeaderColor,fifthHeaderColor2);
    }

    @Test(groups = {"ButtonTests"})
    public void buttonTest(){
        WebElement oliveBtn=driver.findElement(By.cssSelector("button.olive"));
        Assert.assertEquals(oliveBtn.getText(),"Olive");
        WebElement brownBtn=driver.findElement(By.cssSelector("button.brown"));
        Color actualColor=Color.fromString(brownBtn.getCssValue("color"));
        Color expectedColor=Color.fromString("rgba(255, 255, 255, 1)");
        Assert.assertEquals(actualColor,expectedColor);
    }

    @AfterClass(alwaysRun = true)
    public void teardown() {
        driver.close();
    }
}
