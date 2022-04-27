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
import java.util.List;

public class Activity9 {

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
    public void verifyUserOnAccountPage(){
        WebElement myAccountItem=driver.findElement(By.linkText("My Account"));
        myAccountItem.click();
        WebElement accountPageHeading=driver.findElement(By.tagName("h1"));
        wait.until(ExpectedConditions.visibilityOf(accountPageHeading));
        Assert.assertEquals(accountPageHeading.getText().trim(),"My Account");
        Assert.assertEquals(driver.getTitle(),"My Account – Alchemy LMS");
        Reporter.log("Account Page title validation Passed");
    }

    @Test(dependsOnMethods = {"verifyUserOnAccountPage"})
    public void verifyUserLoggedIn(){
        WebElement loginBtn=driver.findElement(By.linkText("Login"));
        loginBtn.click();
        WebElement loginDiv=driver.findElement(By.xpath("//div[contains(text(),'Login')]"));
        Boolean loginBoxDsiplayed=wait.until(ExpectedConditions.visibilityOf(loginDiv)).isDisplayed();
        Assert.assertTrue(loginBoxDsiplayed,"Error login component not displayed in time..");
        WebElement loginId=driver.findElement(By.id("user_login"));
        WebElement password=driver.findElement(By.id("user_pass"));
        WebElement submit=driver.findElement(By.id("wp-submit"));
        loginId.sendKeys("root");
        password.sendKeys("pa$$w0rd");
        submit.submit();
        WebElement loginSuccessInd=driver.findElement(By.xpath("//li[@id='wp-admin-bar-my-account']/a//span"));
        String loggedInUsername=wait.until(ExpectedConditions.visibilityOf(loginSuccessInd)).getText();
        Assert.assertEquals(loggedInUsername,"root");
        Reporter.log("Login test passed");
    }

    @Test(dependsOnMethods = {"verifyUserLoggedIn"})
    public void verifyCourseProgressDetails(){
        WebElement allCourses=driver.findElement(By.linkText("All Courses"));
        allCourses.click();
        WebElement coursesHeading=driver.findElement(By.xpath("//h1[contains(text(),'All Courses')]"));
        Boolean coursesDisplayed=wait.until(ExpectedConditions.visibilityOf(coursesHeading)).isDisplayed();
        Assert.assertTrue(coursesDisplayed,"Error in displaying the courses page!");
        WebElement courseSection=driver.findElement(By.xpath("//div[@class='ld-course-list-items row']"));
        executor.executeScript("arguments[0].scrollIntoView(true);",courseSection);
        List<WebElement> coursesLinks=driver.findElements(By.xpath("//div[@class='ld-course-list-items row']//article//a[contains(text(),'See more')]"));
        System.out.println("Total number of available courses:"+coursesLinks.size());
        coursesLinks.get(0).click();
        WebElement courseContentHeading=driver.findElement(By.xpath("//h2[contains(text(),'Course Content')]"));
        executor.executeScript("arguments[0].scrollIntoView(true);",courseContentHeading);
        Boolean coursesContentDisplayed=wait.until(ExpectedConditions.visibilityOf(courseContentHeading)).isDisplayed();
        Assert.assertTrue(coursesContentDisplayed,"Error in displaying the courses content section!");
        WebElement chapter=driver.findElement(By.xpath("//div[contains(text(),'Developing Strategy')]/parent::a"));
        chapter.click();
        WebElement chapterDetails=driver.findElement(By.tagName("h1"));
        String chapterTitle=wait.until(ExpectedConditions.visibilityOf(chapterDetails)).getText();
        Assert.assertEquals(chapterTitle,"Developing Strategy");
        WebElement completionStatus=driver.findElement(By.xpath("//div/div[contains(@class,'ld-status-complete')]"));
        Assert.assertEquals(completionStatus.getText(),"COMPLETE");
        Reporter.log("Course Progress Completion test passed");
    }
}
