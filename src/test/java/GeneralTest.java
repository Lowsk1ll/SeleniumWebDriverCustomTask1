import io.qameta.allure.AllureResultsWriter;
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
    void Test()  {
        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();
        mainPage.skip();
        mainPage.setUp();
        mainPage.Find("клавиатура");
        searchPage.skipKupon();
        System.out.println(searchPage.getResults());
        searchPage.setUpFilters();
        System.out.println(searchPage.getResults());

    }
    @AfterMethod
    void end(){
        driverWrapper.close();
    }
}
