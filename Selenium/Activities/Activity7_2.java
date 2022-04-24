package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://training-support.net/selenium/dynamic-attributes");
        WebElement userName = driver.findElement(By.xpath("//div[contains(@class,'vertical')]/following::div[@id='dynamic-attributes-form']//label[text()='Username']/following-sibling::input"));
        WebElement password = driver.findElement(By.xpath("//div[contains(@class,'vertical')]/following::div[@id='dynamic-attributes-form']//label[text()='Password']/following-sibling::input"));
        WebElement confirmPassword=driver.findElement(By.xpath("//label[text()='Confirm Password']/following-sibling::input"));
        WebElement email=driver.findElement(By.xpath("//input[@type='email']"));
        WebElement signUp=driver.findElement(By.xpath("//button[contains(text(),'Sign')]"));

        userName.sendKeys("Anshuman");
        password.sendKeys("password");
        confirmPassword.sendKeys("password");
        email.sendKeys("test@xyz.com");
        signUp.click();

        String signUpMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))).getText();
        System.out.println("Login message: " + signUpMessage);

        driver.close();

    }
}
