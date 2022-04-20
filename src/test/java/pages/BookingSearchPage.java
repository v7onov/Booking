package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static staticdata.Hotels.HOTEL_NAME;
import static staticdata.WebUrls.BOOKING_SEARCH_PAGE;

public class BookingSearchPage extends BasePage {

    @FindBy(name = "ss")
    private WebElement searchDestinationField;

    @FindBy(xpath = "//*/button/span[contains(text(),'Search')]")
    private WebElement confirmSearchButton;

    @FindBy(xpath = "//div[text()='Crowne Plaza Yas Island, an IHG Hotel']/ancestor::div[@data-testid='property-card']//div[@data-testid='review-score']/div[1]")
    private WebElement score;

    @FindBy(xpath = "//*[contains(text(),'Destination/property')]")
    private WebElement searchHeader;




    public BookingSearchPage(WebDriver driver) {
        super(driver);
    }

    public void openSearchPage(){
        driver.get(BOOKING_SEARCH_PAGE);
    }

    public void sendHotelNameToSearchField(){
        searchDestinationField.sendKeys(HOTEL_NAME);
    }

    public void clickHeader(){
        searchHeader.click();
    }

    public void clickSearchButton(){
        confirmSearchButton.click();
    }



}
