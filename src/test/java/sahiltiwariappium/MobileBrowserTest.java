package sahiltiwariappium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest{

    @Test
    public void browserTest() throws InterruptedException {
        Thread.sleep(2000);
//        driver.get("http://google.com");
//        driver.findElement(By.name("q")).sendKeys("Sahil");
//        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
        driver.findElement(By.cssSelector("a[routerlink*='products']")).click();
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)", "");	//Scroll
        String text = driver.findElement(By.cssSelector("a[href*='products/3']")).getText();
        Assert.assertEquals(text, "Devops");
    }

}
