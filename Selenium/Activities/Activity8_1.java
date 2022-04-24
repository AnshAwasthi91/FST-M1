package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Activity8_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/tables");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement staticTable = driver.findElement(By.xpath("//table[contains(@class,'striped')]/tbody"));
        List<WebElement> staticTableRows=staticTable.findElements(By.tagName("tr"));
        List<WebElement> staticTableCols=staticTableRows.get(0).findElements(By.tagName("td"));

        System.out.println("Number of rows of static table:"+staticTableRows.size());
        System.out.println("Number of columns of static table:"+staticTableCols.size());

        System.out.println("Printing values of 3rd row of the static table:");
        List<WebElement> thirdRowColsStaticTable=staticTableRows.get(2).findElements(By.tagName("td"));
        for(int i=0;i<thirdRowColsStaticTable.size();i++){
            System.out.println("3rd row,"+(i+1)+"th col value:"+thirdRowColsStaticTable.get(i).getText());
        }
        WebElement secondRowSecondColStaticTable=staticTableRows.get(1).findElements(By.tagName("td")).get(1);
        System.out.println("2nd row,2nd col value:"+secondRowSecondColStaticTable.getText());

        driver.close();

    }
}
