package sahiltiwariappium;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;

public class iOSBasics extends iOSBaseTest{

    @Test
    public void iOSBasicsTest()
    {
        //Xpath, classname, IOS, iosClassCHain, IOSPredicateString, accessibility id, id

        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
        //Xpath -XMl language- App source
        //	driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name='Text Entry']")).click();
        //iOS class chain string is used to find xpath and run natively, as xpath is based on xml and iOS doesn't support xml natively,
        // if we define xpath's, it might run the code slow
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`label =='Text Entry'`]")).click();
        driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeCell")).sendKeys("Hello World");
        driver.findElement(AppiumBy.accessibilityId("OK")).click();

        //With Predicate string you can use multiple expressions to find the exact element
        //driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value == 'Confirm / Cancel'"));

        //With predicate you can use regular expression, for eg: below we use BEGINSWITH and ENDSWITH (https://appium.github.io/appium-xcuitest-driver/4.19/ios-predicate/)
        //	driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value ENDSWITH[c] 'Cancel'"));
        driver.findElement(AppiumBy.iOSNsPredicateString("type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[c] 'Confirm'")).click();

        String text= driver.findElement(AppiumBy.iOSNsPredicateString("name BEGINSWITH[c] 'A message'")).getText();
        System.out.println(text);

        driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Confirm'")).click();

        //longpress, scroll, swipe, slides, dropdowns

    }
}
