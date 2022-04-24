package SeleniumActivities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class Activity11_4 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/tab-opener");
        WebElement launch=driver.findElement(By.id("launcher"));
        String parentWinHandle=driver.getWindowHandle();

        System.out.println("Page Title is :"+driver.getTitle());
        System.out.println("Parent Window Handle is:"+parentWinHandle);
        launch.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> windowHandles = driver.getWindowHandles();
        for(String handles:windowHandles){
            System.out.println("Current Window handle is:"+handles);
            if(!handles.equalsIgnoreCase(parentWinHandle)){
                driver.switchTo().window(handles);
                wait.until(ExpectedConditions.titleIs("Newtab"));
                System.out.println("Current widow title is : "+driver.getTitle());
                WebElement anotherLaunch=driver.findElement(By.id("actionButton"));
                wait.until(ExpectedConditions.visibilityOf(anotherLaunch)).click();
                wait.until(ExpectedConditions.numberOfWindowsToBe(3));
                Set<String> windowHandlesMore = driver.getWindowHandles();
                for(String handlesAgain:windowHandlesMore){
                    System.out.println("Window Handles More:"+handlesAgain);
                }
            }
        }

        driver.quit();

    }
}
