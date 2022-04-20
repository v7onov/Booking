package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookingResultsPage extends BasePage {

    @FindBy(xpath = "//div[text()='Crowne Plaza Yas Island, an IHG Hotel']/ancestor::div[@data-testid='property-card']//div[@data-testid='review-score']/div[1]")
    private WebElement score;

    @FindBy(xpath = "(//div[@data-testid='title'])[1]")
    private WebElement firstHotelName;



    public BookingResultsPage(WebDriver driver) {
        super(driver);
    }

    public String getHotelName(){
        return firstHotelName.getText();
    }

    public String getHotelScore(){
        return score.getText();
    }


}
