package tests;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.HomePage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver driver;

    protected void init() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://demoqa.com/books");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    protected void stop() {
        driver.quit();
    }

    public String takeScreenshot() throws IOException {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File screenshot = new File("reference/screen" + System.currentTimeMillis() + ".png");

        Files.copy(tmp, screenshot);
        return screenshot.getAbsolutePath();
    }

}
