package com.baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base {
    public static Properties prop;
    public static WebDriver driver;

    @BeforeTest
    public static void loadConfig() {
        try {
            prop = new Properties();
            FileInputStream fi = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/Config.properties");
            prop.load(fi);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void launchApp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        String browserName = prop.getProperty("browser");
        if (browserName == null) {
            throw new RuntimeException("Browser name is not specified in Config.properties file.");
        }
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
            Thread.sleep(5000);
        } else if (browserName.equalsIgnoreCase("FireFox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("IE")) {
            driver = new InternetExplorerDriver();
        } else {
            throw new RuntimeException("Invalid browser name specified in Config.properties file: " + browserName);
        }
    }

    public void captureScreenshot() {
        try {
            File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage img = ImageIO.read(screenshotFile);
            String screenshotPath = "screenshot.png";
            ImageIO.write(img, "png", new File(screenshotPath));
            System.out.println("Screenshot saved at: " + screenshotPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
