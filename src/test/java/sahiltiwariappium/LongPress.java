package sahiltiwariappium;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LongPress extends BaseTest{

    @Test
    public void LongPressGesture() throws MalformedURLException, InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        //storing element in web element
        WebElement ele= driver.findElement(By .xpath("//android.widget.TextView[@text='People Names']"));
        //execute long click gesture
        longPressAction(ele);
        Thread.sleep(2000);
        String LongPressMenuText = driver.findElement(By .id("android:id/title")).getText();
        //Assert Text
        Assert.assertEquals(LongPressMenuText,"Sample menu");
        //Assert if it is visible and true
        Assert.assertTrue(driver.findElement(By .id("android:id/title")).isDisplayed());


    }
}
