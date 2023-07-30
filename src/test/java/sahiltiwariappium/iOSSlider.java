package sahiltiwariappium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class iOSSlider extends iOSBaseTest{

    @Test
    public void iOSSliderTest() throws InterruptedException {
        WebElement slider = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeSlider[`label == 'AppElem'`]"));
        slider.sendKeys("0%");
        System.out.println(slider.getAttribute("value"));
        Assert.assertEquals("0%",slider.getAttribute("value"));
        slider.sendKeys("1%");
        Assert.assertEquals("100%",slider.getAttribute("value"));


    }
}
