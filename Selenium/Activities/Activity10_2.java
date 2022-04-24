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
import java.io.*;
import java.time.Duration;

public class Activity10_2 {

    public static void main(String[] args) throws InterruptedException, IOException, UnsupportedFlavorException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/input-events");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions actions=new Actions(driver);
        System.out.println("Page title:"+driver.getTitle());
        WebElement keyPressed= driver.findElement(By.id("keyPressed"));
        actions.keyDown(Keys.LEFT_SHIFT)
                        .sendKeys("a")
                                .keyUp(Keys.LEFT_SHIFT)
                                        .build()
                                                .perform();
        actions.keyDown(Keys.LEFT_CONTROL)
                .sendKeys("a")
                .sendKeys("c")
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();
        String copiedTextFromWeb= (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
        File file = new File(System.getProperty("user.dir")+"//src//test//java//SeleniumActivities//testfile.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fs = new FileOutputStream(file,false);
        PrintWriter writer = new PrintWriter(fs);
        writer.write(copiedTextFromWeb);
        writer.flush();
        writer.close();
        fs.close();
        driver.close();





    }
}
