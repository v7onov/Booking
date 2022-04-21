package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import staticdata.Hotels;
import staticdata.WebUrls;

import java.util.concurrent.TimeUnit;

public class HotelNameSteps {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("User is on search page")
    public void userIsOnSearchPage() {
        driver.get(WebUrls.BOOKING_SEARCH_PAGE);
    }

    @When("User enters Crowne Plaza Yas Island, an IHG Hotel text to Search field")
    public void userEntersHotelsName() {
        driver.findElement(By.name("ss")).sendKeys(Hotels.HOTEL_NAME);
        driver.findElement(By.xpath("//*[contains(text(),'Destination/property')]")).click();
    }

    @And("User clicks search button")
    public void userClicksSearchButton() {
        driver.findElement(By.xpath("//*/button/span[contains(text(),'Search')]")).click();
    }

    @Then("Crowne Plaza Yas Island, an IHG Hotel option presents and is first in the list")
    public void hotelIsFirstInTheListTest() {
        Assert.assertEquals(Hotels.HOTEL_NAME, driver.findElement(By.xpath("(//div[@data-testid='title'])[1]")).getText(), String.format("%s hotel isn't shown as first option", Hotels.HOTEL_NAME));
    }

    @Then("Hotel's rate is 8.1")
    public void checkHotelRateTest() {
        Assert.assertEquals(Hotels.HOTEL_SCORE, driver.findElement(By.xpath("(//div[@data-testid='title'])[1]/ancestor::div[@data-testid='property-card']//div[@data-testid='review-score']/div[1]")).getText(), String.format("%s rate is not correct", Hotels.HOTEL_SCORE));
    }
}

