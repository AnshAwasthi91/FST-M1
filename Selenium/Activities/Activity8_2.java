package SeleniumActivities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.List;

public class Activity8_2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/tables");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement sortableTable = driver.findElement(By.xpath("//*[@id='sortableTable']/tbody"));
        List<WebElement> sortableTableRows=sortableTable.findElements(By.tagName("tr"));
        List<WebElement> sortableTableCols=sortableTableRows.get(0).findElements(By.tagName("td"));
        WebElement nameSort=driver.findElement(By.xpath("//*[@id='sortableTable']/thead//th[text()='Name']"));
        List<WebElement> sortableTableFooterElements = driver.findElements(By.xpath("//*[@id='sortableTable']/tfoot//th"));

        System.out.println("Number of rows of sortable table:"+sortableTableRows.size());
        System.out.println("Number of columns of sortable table:"+sortableTableCols.size());

        System.out.println("Printing values of 2rd row of the sortable table:");
        WebElement secondRowSecondColSortableTable=sortableTableRows.get(1).findElements(By.tagName("td")).get(1);
        System.out.println("2nd row,2nd col value:"+secondRowSecondColSortableTable.getText());

        nameSort.click();

        System.out.println("Again Printing values of 3rd row of the sortable table:");
        sortableTable = driver.findElement(By.xpath("//*[@id='sortableTable']/tbody"));
        sortableTableRows=sortableTable.findElements(By.tagName("tr"));
        secondRowSecondColSortableTable=sortableTableRows.get(1).findElements(By.tagName("td")).get(1);
        System.out.println("2nd row,2nd col value:"+secondRowSecondColSortableTable.getText());

        System.out.println("Printing the footer table elements:");
        for(int i=0;i<sortableTableFooterElements.size();i++){
            System.out.println((i+1)+"th col value:"+sortableTableFooterElements.get(i).getText());
        }

        driver.close();

    }
}
