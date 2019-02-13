import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected AppiumDriver<MobileElement> driver;
    @BeforeSuite
    public void setEnvironment() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setPlatform(Platform.ANDROID);
        caps.setBrowserName(BrowserType.CHROME);
        caps.setVersion("8.1");
        caps.setCapability("deviceName", "Android");

        driver = new AndroidDriver<MobileElement>
                (
                        new URL("http://0.0.0.0:4723/wd/hub"), caps);
    }

}
