package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args) {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.training-support.net");
        System.out.println("Page Title is: "+driver.getTitle());
        WebElement aboutUsById=driver.findElement(By.id("about-link"));
        System.out.println("Text of the web element is: "+aboutUsById.getText());
        WebElement aboutUsByClassName=driver.findElement(By.className("green"));
        System.out.println("Text of the web element is: "+aboutUsByClassName.getText());
        WebElement aboutUsByLinkText=driver.findElement(By.linkText("About Us"));
        System.out.println("Text of the web element is: "+aboutUsByLinkText.getText());
        WebElement aboutUsByCssSelector=driver.findElement(By.cssSelector("a.green"));
        System.out.println("Text of the web element is: "+aboutUsByCssSelector.getText());
        driver.close();
    }
}
