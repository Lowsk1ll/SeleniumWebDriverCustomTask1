import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GeneralTest {
    DriverWrapper driverWrapper = new DriverWrapper();

    @BeforeMethod
    void setUp(){
        driverWrapper.init();
    }

    @Test(invocationCount = 1)
    void Test() throws InterruptedException {
        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();
        mainPage.closeNotifiacationSuggestions();
        mainPage.changeCountryLanguageCurrencySettings();
        mainPage.closeKupon();
        mainPage.find("клавиатура");
        searchPage.closeKupon();
        System.out.println(searchPage.getResults());
        searchPage.sortByCostWithFreeDelivery();
        System.out.println(searchPage.getResults());

    }
    @AfterMethod
    void end(){
        driverWrapper.close();
    }
}
