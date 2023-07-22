package sahiltiwariappium;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ECommerce_TC2 extends BaseTest{

    @Test
    public void AddToCart() throws InterruptedException {
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
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));

        //once Jordan 6 Rings, we need to click on add to cart but on that screen we can have multiple 'add to cart' button showing up
        // To click on correct 'add to cart' button, collect all product names and you can iterate in for loop
        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for (int i=0;i<productCount;i++)
        {
            String productname = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();

            if (productname.equalsIgnoreCase("Jordan 6 Rings"))
            {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        // Wait until page title turns to Cart from Product
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")),"text","Cart"));
        //Assert the product we added actually added in cart
        String cartProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(cartProduct,"Jordan 6 Rings");



    }
}
