package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Activity9_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/selects");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement selectElement = driver.findElement(By.id("multi-select"));
        WebElement selectedOption = driver.findElement(By.id("multi-value"));
        Select select=new Select(selectElement);
        if(select.isMultiple()){
            select.selectByVisibleText("Javascript");
            System.out.println(selectedOption.getText());
            select.selectByValue("node");
            System.out.println(selectedOption.getText());
            for(int i=4;i<=6;i++){
                select.selectByIndex(i);
                System.out.println(selectedOption.getText());
            }
            select.deselectByValue("node");
            System.out.println(selectedOption.getText());
            select.deselectByIndex(7);
            System.out.println(selectedOption.getText());

            System.out.println("First Selected Option:"+select.getFirstSelectedOption().getText());

            List<WebElement> options=select.getOptions();
            for(WebElement option:options){
                System.out.println("Select option:"+option.getText());
            }

            select.deselectAll();
            System.out.println(selectedOption.getText());
        }

        driver.close();

    }
}
