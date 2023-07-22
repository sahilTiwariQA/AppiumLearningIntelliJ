package sahiltiwariappium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MiscellaneousAppiumActions extends BaseTest{

    @Test
    public void Miscellaneous() throws MalformedURLException
    {
        //Locators appium supports: Xpath, id, accessibilityId, className, androidUIAutomator
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
        driver.findElement(By.id("android:id/checkbox")).click();
        //Rotate device to horizontal view
        DeviceRotation landscape=new DeviceRotation(0,0,90);
        driver.rotate(landscape);

        driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
        // Assert pop up title is "WiFi Settings"
        String alertText= driver.findElement(By.id("android:id/alertTitle")).getText();
        Assert.assertEquals(alertText,"WiFi settings");
        //copy paste
        //copy to clipboard - paste it
        driver.setClipboardText("Sahil WiFi");
        //send text in text box from clipboard
        driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
        // find multiple buttons on the page and get (1) and click that
        // Press Android system keys 'ENTER'
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

        // Press Android system keys
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        driver.pressKey(new KeyEvent(AndroidKey.HOME));

    }
}
