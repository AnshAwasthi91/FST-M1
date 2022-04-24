package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Activity9_1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/selects");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement selectElement = driver.findElement(By.id("single-select"));
        WebElement selectedOption = driver.findElement(By.id("single-value"));
        Select select=new Select(selectElement);
        select.selectByVisibleText("Option 2");
        System.out.println(selectedOption.getText());
        select.selectByIndex(3);
        System.out.println(selectedOption.getText());
        select.selectByValue("4");
        System.out.println(selectedOption.getText());
        List<WebElement> options=select.getOptions();
        for(WebElement option:options){
            System.out.println("Select option:"+option.getText());
        }

        driver.close();

    }
}
