package utilities;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();
        WebDriver driver = ((tests.BaseTest) currentClass).getDriver();

        if (driver != null) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = result.getName() + "_" + timeStamp + ".png";
            File dest = new File("screenshots/" + screenshotName);

            try {
                FileUtils.copyFile(src, C:/Users/wonba/downloads);
                System.out.println("Screenshot saved for failed test: " + screenshotName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
