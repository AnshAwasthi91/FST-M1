package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        System.out.println("Page Title is: "+driver.getTitle());
        WebElement inputText=driver.findElement(By.xpath("//div[@id='dynamicText']/input"));
        System.out.println("Input Text element enabled?: "+inputText.isEnabled());
        WebElement enableInput=driver.findElement(By.id("toggleInput"));
        enableInput.click();
        System.out.println("Input Text element enabled?: "+inputText.isEnabled());
        driver.close();

    }
}
