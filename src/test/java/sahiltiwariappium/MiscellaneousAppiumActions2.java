package sahiltiwariappium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MiscellaneousAppiumActions2 extends BaseTest{

    @Test
    public void Miscellaneous2() throws MalformedURLException
    {
        //App package and App activity
        //find app package and app activity using below command in terminal. Open the screen you want to be on in emulator
        //adb shell dumpsys window | grep -E 'mCurrentFocus'
        Activity activity =new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        driver.startActivity(activity);
        //Using above code app will directly open the page we were on while collecting app activity element in our emulator.
        // Hence removing below 2 steps of clicking preference and preference dependencies
//        driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
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
