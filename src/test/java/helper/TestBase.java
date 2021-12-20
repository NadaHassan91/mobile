package helper;

import cucumber.api.testng.AbstractTestNGCucumberTests;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TestBase extends AbstractTestNGCucumberTests {

    public static AndroidDriver<WebElement> driver;
    @BeforeSuite()
    public void startDriver() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"11");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        String appPath = System.getProperty("user.dir")+"/Application/Multi-action_Home_Button_base.apk";
        caps.setCapability(MobileCapabilityType.APP,appPath);
        driver = new AndroidDriver<WebElement>(new URL("http://0.0.0.0:4723/wd/hub"),caps);




    }

    @AfterSuite()
    public void stopDriver() {
        driver.quit();

    }
}
