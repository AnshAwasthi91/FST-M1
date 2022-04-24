package SeleniumActivities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity11_3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        System.out.println("Page Title is :"+driver.getTitle());
        WebElement promptBtn=driver.findElement(By.cssSelector("#prompt"));
        promptBtn.click();
        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert text is:"+alert.getText());
        alert.sendKeys("Yes, you are!");
        alert.accept();
        driver.close();

    }
}
