package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdrver.gecko.driver", "C:/Users/Lulu/.wdm/drivers/geckodriver.exe");

        System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "NULL");
        WebDriver driver = new FirefoxDriver();
Actions builder = new Actions(driver);
        //Open a page

        driver.get("https://www.training-support.net/selenium/drag-drop");

        //find the football and dropzones

        WebElement football = driver.findElement(By.id("draggable"));
        WebElement dropzone1 = driver.findElement(By.id("droppable"));
        WebElement dropzone2 = driver.findElement(By.id("dropzone2"));

        builder.dragAndDrop(football, dropzone1).build().perform();

        String message = driver.findElement(By.xpath("//div[@id='droppable']/p")).getText();
        System.out.println(message);

        builder.dragAndDrop(football, dropzone2).build().perform();

         message = driver.findElement(By.xpath("//div[@id='dropzone2']/p")).getText();
        System.out.println(message);
        driver.quit();




    }
    }
