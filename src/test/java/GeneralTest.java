import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GeneralTest {
    DriverWrapper driverWrapper = new DriverWrapper();

    @BeforeMethod
    void setUp(){
        driverWrapper.Init();
    }

    @Test(invocationCount = 1)
    void Test() throws InterruptedException {
        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();
        mainPage.closeNotifiacationSuggestions();
        mainPage.changeCountryLanguageCurrencySettings();
        mainPage.Find("клавиатура");
        searchPage.closeKupon();
        System.out.println(searchPage.GetResults());
        //Assert.assertTrue(searchPage.freeDelivery.isEnabled());
        searchPage.sortByCostWithFreeDelivery();
        System.out.println(searchPage.GetResults());

    }
    @AfterMethod
    void end(){
        driverWrapper.Close();
    }
}
