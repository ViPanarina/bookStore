package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.xml.sax.Locator;
import tests.TestBase;
import wait.Wait;

import java.awt.*;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class PageBase extends TestBase {

    public WebDriver driver;
    Wait wait;

    public PageBase(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement element ) {
       element.click();
    }

    public void fillField(WebElement field) {
        click(field);
        field.clear();
        field.sendKeys();
    }


    public void takeAndCompareScreenshot(String actualScreenshotName, WebElement element) throws IOException {
        String referenceImageFilePath = "reference/" + actualScreenshotName + ".png";
        String tmpFilePath = "reference/tmp" + actualScreenshotName + ".png";
        File tmp;
        if (element == null) {
            tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        } else {
            tmp = element.getScreenshotAs(OutputType.FILE);
        }
        Files.copy(tmp.toPath(), new File(tmpFilePath).toPath(), StandardCopyOption.REPLACE_EXISTING);

        File referenceImageFile = new File(referenceImageFilePath);
        if (!referenceImageFile.exists()) {
            throw new RuntimeException("Reference image file does not exist: " + referenceImageFile);
        }

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;

        double maxDiffPercent = 0.01 * screenWidth * screenHeight;

        ProcessBuilder pb = new ProcessBuilder("compare", "-metric", "AE", referenceImageFilePath, tmpFilePath, "null:");
        Process process = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        String line;
        double difference = 0;
        while ((line = reader.readLine()) != null) {
            difference = Integer.parseInt(line.trim());
        }
        reader.close();
        process.destroy();

        if (difference > maxDiffPercent) {
            throw new RuntimeException("Screenshots are different");
        }

        Files.deleteIfExists(new File(tmpFilePath).toPath());
    }
}
