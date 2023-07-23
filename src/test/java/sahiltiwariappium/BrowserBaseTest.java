package sahiltiwariappium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
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

public class BrowserBaseTest {

    public AndroidDriver driver;
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
        UiAutomator2Options options =new UiAutomator2Options();
        //Set device name
        options.setDeviceName("Pixel6Pro");

        //set chrome driver path
        options.setChromedriverExecutable("//Users//sahiltiwari//chromedriver_mac_arm64//chromedriver");
        // set chrome as browser
        options.setCapability("browserName","Chrome");

        // Set driver port to listen to appium server
        driver=new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
    }

    public Double getFormattedAmount(String amount)
    {
        Double price = Double.parseDouble(amount.substring(1));
        return price;
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
