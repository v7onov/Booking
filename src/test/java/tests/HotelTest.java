package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookingResultsPage;
import pages.BookingSearchPage;
import staticdata.Hotels;


public class HotelTest extends BaseTest {


    @Test
    public void checkHotelNameTest(){

        BookingSearchPage bookingSearchPage = new BookingSearchPage(driver);
        bookingSearchPage.openSearchPage();
        bookingSearchPage.sendHotelNameToSearchField();
        bookingSearchPage.clickHeader();
        bookingSearchPage.clickSearchButton();
        BookingResultsPage bookingResultsPage = new BookingResultsPage(driver);
        Assert.assertEquals(bookingResultsPage.getHotelName(), Hotels.HOTEL_NAME);
    }

    @Test
    public void checkHotelRatingTest(){
        BookingSearchPage bookingSearchPage = new BookingSearchPage(driver);
        bookingSearchPage.openSearchPage();
        bookingSearchPage.sendHotelNameToSearchField();
        bookingSearchPage.clickHeader();
        bookingSearchPage.clickSearchButton();
        BookingResultsPage bookingResultsPage = new BookingResultsPage(driver);
        Assert.assertEquals(bookingResultsPage.getHotelScore(), Hotels.HOTEL_SCORE);


    }

}
