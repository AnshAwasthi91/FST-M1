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

public class Activity7 {

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
    public void verifyCourseDetails(){
        WebElement allCourses=driver.findElement(By.linkText("All Courses"));
        allCourses.click();
        WebElement coursesHeading=driver.findElement(By.xpath("//h1[contains(text(),'All Courses')]"));
        Boolean coursesDisplayed=wait.until(ExpectedConditions.visibilityOf(coursesHeading)).isDisplayed();
        Assert.assertTrue(coursesDisplayed,"Error in displaying the courses page!");
        WebElement courseSection=driver.findElement(By.xpath("//div[@class='ld-course-list-items row']"));
        executor.executeScript("arguments[0].scrollIntoView(true);",courseSection);
        List<WebElement> courses=driver.findElements(By.xpath("//div[@class='ld-course-list-items row']//article//h3"));
        System.out.println("Total number of available courses:"+courses.size());
        for (WebElement course:
             courses) {
            System.out.println("Course title is:"+course.getText());
        }
        Reporter.log("Course details test passed");
    }
}
