package sahiltiwariappium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class iOSScrollTest extends iOSBaseTest{

    @Test
    public void iOSScrollTestDemo() throws InterruptedException {
        WebElement ele = driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label == 'Web View'`]"));
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element",((RemoteWebElement)ele).getId());
        driver.executeScript("mobile:scroll",params);
        driver.findElement(AppiumBy.accessibilityId("Web View")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name='UIKitCatalog']")).click();

        // option picker
        driver.findElement(AppiumBy.accessibilityId("Picker View")).click();
        driver.findElement(AppiumBy.accessibilityId("Red color component value")).sendKeys("80");
        driver.findElement(AppiumBy.accessibilityId("Green color component value")).sendKeys("220");
        driver.findElement(AppiumBy.iOSNsPredicateString("label== 'Blue color component value'")).sendKeys("105");
        String BlueNumber = driver.findElement(AppiumBy.iOSNsPredicateString("label== 'Blue color component value'")).getText();
        Assert.assertEquals(BlueNumber,"105");
    }
}
