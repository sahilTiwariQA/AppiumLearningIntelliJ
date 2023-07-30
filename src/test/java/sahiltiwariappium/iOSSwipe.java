package sahiltiwariappium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class iOSSwipe extends iOSBaseTest{

    @Test
    public void iOSSwipeTest()
    {
        // iOS uses bundle id to uniquely identify an app
        //here we are trying to open an already existing app in iOS
        Map<String,String> params = new HashMap<String,String>();
        params.put("bundleId","com.apple.mobileslideshow");
        driver.executeScript("mobile:launchApp",params);
        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'All Photos'")).click();
        List<WebElement> allPhotos = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeCell"));
        System.out.println(allPhotos.size());
        // swipe left from center of the screen (by default iOS swipes from centre of the screen)
        driver.findElement(By.xpath("XCUIElementTypeCell[1]")).click();

        for (int i=0; i<allPhotos.size();i++) {
            System.out.println(driver.findElement(By.xpath("//XCUIElementTypeNavigationBar")));
            Map<String, Object> params1 = new HashMap<String, Object>();
            params1.put("direction", "left");
            driver.executeScript("mobile:swipe", params1);
        }
        driver.navigate().back();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Albums'`]")).click();
    }
}
