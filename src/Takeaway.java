import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.*;

public class Takeaway {

    WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\qa\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.takeaway.com/bg");
    }

    @Test
    public void searchAddress() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement searchBox = driver.findElement(By.id("combobox-input_0"));
        searchBox.click();
        searchBox.sendKeys("улица Спас Соколов, Sofia");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.titleIs("Доставка на храна в София-град София | Takeaway.com"));
        WebElement clickText = driver.findElement(By.cssSelector("h1[data-qa=find-restaurants-section-hero-heading-time-to-order]"));
        // click outside searchBox, so that search button is visible
        clickText.click();


//        WebElement searchButton = driver.findElement(By.cssSelector("button[data-qa=location-panel-search-button]"));
        WebElement searchButton = driver.findElement(By.xpath("*[@id=\"page\"]/div[2]/section/section[1]/div/div/div[1]/div/div[2]/div/div/div[1]/div/div/span/button/span"));
        assertEquals(searchButton.isDisplayed(), true);
        searchButton.click();
    }

    @Test
    public void searchResults() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // return list of all restaurants for the location
        List<WebElement> searchResults = (List<WebElement>) driver.findElement(By.cssSelector("h3[data-qa=restaurant-info-name]"));

        String searchValue = "Wok to Walk";
        boolean restaurantFound = false;

        for (WebElement element : searchResults) {
            String elementValue = element.getAttribute("value");
            System.out.println(elementValue);
            if (elementValue.equals(searchValue)) {
                restaurantFound = true;
                break;
            }
        }
        assertTrue(restaurantFound);
    }


//    @AfterTest
//    public void tearDown() {
//
//        driver.quit();
//    }

}

