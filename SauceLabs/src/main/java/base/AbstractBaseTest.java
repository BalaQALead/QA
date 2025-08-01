package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AbstractBaseTest {
    public static AndroidDriver driver;

    @BeforeClass
    public void setup() throws MalformedURLException {
    	
        DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("deviceName", "emulator-5554"); 
		caps.setCapability("platformVersion", "14.0");
		//       caps.setCapability("app", os.path.abspath("C:\\Users\\wonba\\Downloads\\app-dev-release.apk", false));
		caps.setCapability("automationName", "UiAutomator2");
		caps.setCapability("appPackage", "com.fpowrd.f_powrd");
		caps.setCapability("appActivity", "com.fpowrd.f_powrd.MainActivity");
		caps.setCapability("noReset", false);
		// To Initialize the AndroidDriver
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);
		System.out.println("Launched successfully");  
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Launched successfully");
		
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
