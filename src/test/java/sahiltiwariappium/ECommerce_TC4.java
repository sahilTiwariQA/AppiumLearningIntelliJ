package sahiltiwariappium;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ECommerce_TC4 extends BaseTest{

    @Test
    public void HybridAutomation() throws InterruptedException {
        Thread.sleep(5000);
        //Fill the form
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Sahil");
        //hide the keyboard option so that all elements are visible
        driver.hideKeyboard();

        driver.findElement(By .id("com.androidsample.generalstore:id/radioMale")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        Thread.sleep(2000);
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        // Wait until page title turns to Cart from Product
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));

        List<WebElement> productPrices =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count = productPrices.size();
        double totalSum =0;
        for(int i =0; i< count; i++)
        {
            String amountString =productPrices.get(i).getText();
            Double price = getFormattedAmount(amountString); // getFormattedAmount method created in Base test to make it re usable
            totalSum = totalSum + price;  //160.97 + 120 =280.97

        }
        String displaySum =driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayFormattedSum = getFormattedAmount(displaySum);
        Assert.assertEquals(totalSum, displayFormattedSum); // Assert Total sum and sum label

        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(ele);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(6000);

        //get contexts for native app and in-app browser
        Set<String> contexts =driver.getContextHandles();
        for(String contextName :contexts)
        {
            System.out.println(contextName);
        }

        //once you have browser context, switch to browser context
        driver.context("WEBVIEW_com.androidsample.generalstore");//chrome driver

//        Open terminal
//        Navigate to path where your chromedriver file is located
//        Execute the below command to bypass “chromedriver” can’t be opened because Apple cannot check it for malicious software." Error
//        xattr -d com.apple.quarantine <name-of-executable>

        Thread.sleep(5000);
        //Unresolved issue...cannot click on the accept all button
        driver.findElement(By.xpath("(android.widget.Button)[2]")).click();
        driver.findElement(By.xpath("(android.widget.Button)[0]")).click();
        driver.findElement(By.name("q")).sendKeys("Sahil");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        //switching back to native app context
        driver.context("NATIVE_APP");
    }
}
