package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        System.out.println("Page Title is: "+driver.getTitle());
        driver.findElement(By.xpath("//label[text()='First Name']/following-sibling::input")).sendKeys("Anshumaan");
        driver.findElement(By.xpath("//label[text()='Last Name']/following-sibling::input")).sendKeys("Awasthi");
        driver.findElement(By.xpath("//input[@placeholder='abc@xyz.com']")).sendKeys("test@email.com");
        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("1234567890");
        driver.findElement(By.xpath("//label[text()='Message']/following-sibling::textarea"))
                .sendKeys("This is a test message!!");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@value='submit']")).submit();
        driver.close();

    }
}
