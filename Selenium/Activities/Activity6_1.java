package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        WebElement inputCheckbox=driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input"));
        WebElement removeCheckbox=driver.findElement(By.id("toggleCheckbox"));

        System.out.println("Page Title is: "+driver.getTitle());
        System.out.println("Checkbox input element displayed?: "+inputCheckbox.isDisplayed());
        removeCheckbox.click();
        wait.until(ExpectedConditions.invisibilityOf(inputCheckbox));
        System.out.println("Checkbox input element displayed?: "+inputCheckbox.isDisplayed());
        removeCheckbox.click();
        wait.until(ExpectedConditions.visibilityOf(inputCheckbox));
        System.out.println("Checkbox input element displayed?: "+inputCheckbox.isDisplayed());

        driver.close();

    }
}
