package sahiltiwariappium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class iOSBaseTest {

    public IOSDriver driver;
    public AppiumDriverLocalService service;
    @BeforeClass
    public void configureAppium() throws MalformedURLException
    {
        //Code to start the appium server (so that we don't need to start from Terminal each time)
        service = new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        //Android Driver
        // Appium code -> Appium Server -> Mobile
        XCUITestOptions options=new XCUITestOptions();
        //Set device name
        options.setDeviceName("iPhone 14 Pro");

        // set app name
        options.setApp("//Users//sahiltiwari//Library//Developer//Xcode//DerivedData//UIKitCatalog-dflnpvkbmfpuzibbwbspvexudkbb//Build//Products//Debug-iphonesimulator//UIKitCatalog.app");
        options.setPlatformName("16.4");
        //Appium - Webdriver Agent -> iOS Apps
        options.setWdaLaunchTimeout(Duration.ofSeconds(2000));

        // Set driver port to listen to appium server
        driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown()
    {
        //Quitting app after execution
        driver.quit();
        // stopping appium server after execution
        service.stop();
    }
}
