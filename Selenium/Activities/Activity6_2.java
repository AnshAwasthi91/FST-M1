package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://www.training-support.net/selenium/ajax");

        WebElement btnChangeContent=driver.findElement(By.xpath("//button[text()='Change Content']"));
        By helloTextLoc=By.xpath("//h1");
        By lateTextLoc=By.xpath("//h3[starts-with(text(),'I')]");

        System.out.println("Page Title is: "+driver.getTitle());
        btnChangeContent.click();
        String helloText=wait.until(ExpectedConditions.visibilityOfElementLocated(helloTextLoc)).getText();
        System.out.println("Text is : "+helloText);
        String lateText=wait.until(ExpectedConditions.visibilityOfElementLocated(lateTextLoc)).getText();
        System.out.println("Text is : "+lateText);

        driver.close();

    }
}
