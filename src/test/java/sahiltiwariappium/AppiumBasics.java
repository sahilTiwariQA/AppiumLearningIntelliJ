package sahiltiwariappium;

import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppiumBasics extends BaseTest{

    @Test
    public void WiFiSettingsName() throws MalformedURLException
    {
        //Locators appium supports: Xpath, id, accessibilityId, className, androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        // Assert pop up title is "WiFi Settings"
        String alertText= driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertText,"WiFi settings");
        //send text in text box
        driver.findElement(By.id("android:id/edit")).sendKeys("Sahil Wifi");
        // find multiple buttons on the page and get (1) and click that
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();


    }
}
