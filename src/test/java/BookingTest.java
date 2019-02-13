import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobjects.HomePage;

public class BookingTest extends BaseTest {

    @DataProvider
    public Object[][] testData() {
        //retrive data from
        return new Object[][] {
                //from, to
                {"Киев","Львов"},
                {"Киев","Одесса"},
                {"Киев","Харьков"},
                {"Киев","Мариуполь"}
        };
    }
@Severity(SeverityLevel.CRITICAL)
@Feature("TestCity")
@Issue("GEN-1710")
    @Test
    public void testOpenSite() throws InterruptedException {
        driver.get("https://booking.uz.gov.ua/ru/?from=2200001&to=2218000&date=2019-02-09&time=00%3A00&url=train-list");
        HomePage homePage = new HomePage(driver);
//        homePage.setFrom("Киев");
//        homePage.setTo("Львов");
//        homePage.submit();
        homePage.getTrains().get(2).clickOnTitle();
        Thread.sleep(3000);
    }
    @Flaky
    @Epic(value = "Kyc epic")
    @Test
    public void secondTest() throws InterruptedException {
        driver.get("https://booking.uz.gov.ua/ru/?from=2200001&to=2218000&date=2019-02-09&time=00%3A00&url=train-list");
        HomePage homePage = new HomePage(driver);
//        homePage.setFrom("Киев");
//        homePage.setTo("Львов");
//        homePage.submit();
        homePage.getTrains().get(2).clickOnTitle();
        Thread.sleep(3000);
    }
}
