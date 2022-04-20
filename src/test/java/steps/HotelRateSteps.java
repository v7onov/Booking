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
import staticdata.WebUrls;

import java.util.concurrent.TimeUnit;

public class HotelRateSteps {

    WebDriver driver;

    @Before
    public void setUp(){
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
    public void userIsOnMainScreen() {
        driver.get(WebUrls.BOOKING_SEARCH_PAGE);
    }

    @When("User enters {string} text to Search field")
    public void userFillsSearchField(String hotelName) {
        driver.findElement(By.name("ss")).sendKeys(hotelName);
        driver.findElement(By.xpath("//*[contains(text(),'Destination/property')]")).click();
    }

    @And("User click 'Search' button")
    public void userClicksSearchButton() {
        driver.findElement(By.xpath("//*/button/span[contains(text(),'Search')]")).click();
    }

    @Then("First hotel has {string} rate")
    public void hotelRate(String hotelRate) {
        Assert.assertEquals(hotelRate, driver.findElement(By.xpath("(//div[@data-testid='title'])[1]/ancestor::div[@data-testid='property-card']//div[@data-testid='review-score']/div[1]")).getText(), String.format("%s rate is not correct", hotelRate));
    }
}
