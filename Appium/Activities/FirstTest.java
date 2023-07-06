package examples;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;

public class FirstTest {

    WebDriver driver;

    @BeforeClass

    public void setUp() throws MalformedURLException {
        //desired capabilities
        UiAutomator2Options caps = new UiAutomator2Options();
        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.android.bbkcalculator");
        caps.setAppWaitActivity(".Calculator");
        caps.noReset();

        //appium server url
        URL serverURL = new URL("http://localhost:4723/wd/hub");


        //initialize android driver

        driver = new AndroidDriver(serverURL, caps);
    }
    @Test

        public void multiplicationTest()
    {

            driver.findElement(AppiumBy.id("com.android.bbkcalculator:id/digit5")).click();
            //find multiply and tap it
        driver.findElement(AppiumBy.accessibilityId("multiply")).click();

        //find digit 2 and tap it

        driver.findElement(AppiumBy.id("com.android.bbkcalculator:id/digit2")).click();


        //find equals and tap it
        driver.findElement(AppiumBy.accessibilityId("equals")).click();

        //assertions

        String result = driver.findElement(By.id("com.android.bbkcalculator:id/result_text")).getText();

        assertEquals(result,"=10");

    }

    public static void takeScreenshot(WebDriver driver)throws IOException{

        File tempImg = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        File screenshot = new File("src/test/resources/screenshot.jpg");

        FileUtils.copyFile(tempImg, screenshot);

        String imgPath = "../" + screenshot;
        String  imgHTML = "<img src="+ imgPath +" />";
        Reporter.log(imgHTML);

    }
    @AfterClass

    public void tearDown(){

        //close the app

        driver.quit();


    }


    }

