package examples;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static examples.W3ActionBase.doSwipe;
import static org.testng.AssertJUnit.assertEquals;
public class ActionTest {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass

    public void setUp() throws MalformedURLException {
        //desired capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppWaitActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        //appium server url
        URL serverURL = new URL("http://localhost:4723/wd/hub");


        //driver initialization

        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));


        driver.get("https://www.training-support.net/selenium");




    }

    @Test
    public void webAppTest() throws InterruptedException {
        Dimension dims = driver.manage().window().getSize();

        //wait until page loads
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.Button[@text=['Get Started!']")));
        //scroll to end of the page

        Point start = new Point((int) (dims.width * 5.0), (int) (dims.height * 0.8));
        Point end = new Point((int) (dims.width * 0.5), (int) (dims.height * 0.6));
        doSwipe(driver, start, end, 200);


        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='To-Do List']"))).click();

        //to-do list app actions

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']")));

        //find elements on page

        WebElement addTaskInput = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@resource-id='taskInput']"));

        WebElement addTaskButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add Task']"));

        //enter tasks
        addTaskInput.sendKeys("Add tasks to list");
        addTaskButton.click();
        Thread.sleep(1000);
        addTaskButton.sendKeys("Get number of tasks");
        addTaskButton.click();
        Thread.sleep(1000);
        addTaskButton.sendKeys("Clear the list");
        addTaskButton.click();
        Thread.sleep(1000);




    }

    @AfterClass

    public void afterClass()
    {
        driver.quit();
    }
    }
