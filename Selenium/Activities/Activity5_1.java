package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        System.out.println("Page Title is: "+driver.getTitle());
        WebElement inputCheckbox=driver.findElement(By.xpath("//div[@id='dynamicCheckbox']/input"));
        System.out.println("Checkbox input element displayed?: "+inputCheckbox.isDisplayed());
        WebElement removeCheckbox=driver.findElement(By.id("toggleCheckbox"));
        removeCheckbox.click();
        System.out.println("Checkbox input element displayed?: "+inputCheckbox.isDisplayed());
        driver.close();

    }
}
