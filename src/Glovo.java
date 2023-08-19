import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Glovo {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://glovoapp.com/bg");
    }

    @Test
    public void search1() {
        WebElement accessBiscuits = driver.findElement(By.id("onetrust-accept-btn-handler"));
        accessBiscuits.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleContains("Доставка"));
        WebElement location = driver.findElement(By.xpath("//div[@data-test-id='address-input-placeholder']"));
        location.click();

        String actual = driver.getTitle();
        String expected = "Доставка на Glovo, България: храна, хранителни стоки, продукти от аптеката. Поръчайте онлайн сега.";
        assertEquals(actual, expected);
    }

    @Test
    public void currentLocation() {
     //   WebElement location = driver.findElement(By.linkText(" Или задайте местоположението си на картата"));

//        WebElement clickOnCurrentLocation = driver.findElement(By.xpath("//div[@data-test-id='location-form-set-location']"));
//        clickOnCurrentLocation.click();

        WebElement location = driver.findElement(By.xpath("//div[@data-test-id='location-form-set-location']"));
        location.click();
    }
}
