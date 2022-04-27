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

public class Activity8 {

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


    @Test()
    public void contactTest(){
        WebElement contactBtn=driver.findElement(By.linkText("Contact"));
        contactBtn.click();
        WebElement contactHeading=driver.findElement(By.xpath("//h1[contains(text(),'Need Help?')]"));
        Boolean loginBoxDsiplayed=wait.until(ExpectedConditions.visibilityOf(contactHeading)).isDisplayed();
        Assert.assertTrue(loginBoxDsiplayed,"Error contact component not displayed in time..");
        WebElement contactFormHeader=driver.findElement(By.xpath("//h2[contains(text(),'Send us a message')]"));
        executor.executeScript("arguments[0].scrollIntoView(true);",contactFormHeader);

        WebElement fullName=driver.findElement(By.xpath("//input[contains(@id,'field_0')]"));
        WebElement email=driver.findElement(By.xpath("//input[contains(@id,'field_1')]"));
        WebElement subject=driver.findElement(By.xpath("//input[contains(@id,'field_3')]"));
        WebElement message=driver.findElement(By.xpath("//textarea[contains(@id,'field_2')]"));
        WebElement submit=driver.findElement(By.xpath("//button[contains(@id,'submit-8')]"));

        fullName.sendKeys("Anshuman Awasthi");
        email.sendKeys("test@xyz.com");
        subject.sendKeys("Test Subject");
        message.sendKeys("Test message content");
        submit.submit();

        WebElement requestSuccessInd=driver.findElement(By.xpath("//div[@id='wpforms-confirmation-8']/p"));
        String responseConfirmationMsg=wait.until(ExpectedConditions.visibilityOf(requestSuccessInd)).getText();
        Assert.assertNotNull(responseConfirmationMsg);
        System.out.println("Confrimation Message from Team:\n"+responseConfirmationMsg);
        Reporter.log("Contact test passed");
    }
}
