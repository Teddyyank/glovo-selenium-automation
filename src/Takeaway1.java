import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Takeaway1 {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.takeaway.com/bg/porachai/hrana/strelbishche");
    }

    @Test
    public void findResturant() {
     //  WebElement text = driver.findElement(By.id("imysearchstring"));
        WebElement name =driver.findElement(By.cssSelector("[data-qa=\"restaurant-list-header\"]"));
        name.click();

        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Поръчай от 541 търговски обекта";

        Assert.assertEquals(ExpectedTitle, ActualTitle);



    }




//    @AfterTest
//    public void tearDown() {
//
//        driver.quit();
//    }


}
