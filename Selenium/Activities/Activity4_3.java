package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_3 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
        System.out.println("Page Title is: "+driver.getTitle());
        WebElement thirdHeader=driver.findElement(By.xpath("//h3[@id='third-header']"));
        System.out.println("Button Text: "+thirdHeader.getText());
        WebElement fifthHeader=driver.findElement(By.xpath("//h5[contains(text(),'Fifth')]"));
        System.out.println("Fifth Header color : "+fifthHeader.getCssValue("color"));
        WebElement vButton=driver.findElement(By.xpath("//button[contains(text(),'Violet')]"));
        System.out.println("Class attributes of violet button are : "+vButton.getAttribute("class"));
        WebElement gButton=driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div/div/div[2]/div[3]/button[2]"));
        System.out.println("Button Text: "+gButton.getText());
        driver.close();

    }
}
