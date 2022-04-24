package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class Activity10_1 {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/input-events");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions actions=new Actions(driver);
        System.out.println("Page title:"+driver.getTitle());
        actions.click().perform();
        //Thread.sleep(4000);
        WebElement activeSide= driver.findElement(By.xpath("//div[starts-with(@id,'side') and @class='active']/h1"));
        System.out.println("Active Side is after left click:"+activeSide.getText());
        actions.doubleClick().perform();
        //Thread.sleep(4000);
        activeSide= driver.findElement(By.xpath("//div[starts-with(@id,'side') and @class='active']/h1"));
        System.out.println("Active Side is after double click:"+activeSide.getText());
        actions.contextClick().perform();
        //Thread.sleep(4000);
        activeSide= driver.findElement(By.xpath("//div[starts-with(@id,'side') and @class='active']/h1"));
        System.out.println("Active Side is after right click:"+activeSide.getText());
        driver.close();




    }
}
