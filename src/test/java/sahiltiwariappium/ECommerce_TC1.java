package sahiltiwariappium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ECommerce_TC1 extends BaseTest{

    @Test
    public void FillForm() throws InterruptedException {
        Thread.sleep(5000);
        //Submit without entering mandatory field and get Toast error message and assert them.
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        Assert.assertEquals(toastMessage,"Please enter your name");
        Thread.sleep(2000);

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


    }
}
