package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;

public class Activity10_3 {

    public static void main(String[] args) throws InterruptedException, IOException, UnsupportedFlavorException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/drag-drop");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions actions=new Actions(driver);
        System.out.println("Page title:"+driver.getTitle());
        WebElement dragObj= driver.findElement(By.id("draggable"));
        WebElement dropZone1=driver.findElement(By.id("droppable"));
        WebElement dropZone2=driver.findElement(By.id("dropzone2"));
        actions.dragAndDrop(dragObj,dropZone1).build().perform();
        if(dropZone1.findElement(By.tagName("p")).getText().equalsIgnoreCase("Dropped!")){
            System.out.println("Ball dropped successfully to zone 1");
        }
        else{
            System.out.println("Ball dropped failed to zone 1");
        }

        actions.dragAndDrop(dragObj,dropZone2).build().perform();
        if(dropZone2.findElement(By.tagName("p")).getText().equalsIgnoreCase("Dropped!")){
            System.out.println("Ball dropped successfully to zone 2");
        }
        else{
            System.out.println("Ball dropped failed to zone 2");
        }

        driver.close();

    }
}
