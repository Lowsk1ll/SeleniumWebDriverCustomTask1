import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GeneralTest {
    DriverWrapper driverWrapper = new DriverWrapper();

    @BeforeMethod
    void setUp(){
        driverWrapper.init();
    }
    @Test
    void Test() throws InterruptedException {
        MainPage mainPage = new MainPage(driverWrapper.driver);
        SearchPage searchPage = new SearchPage(driverWrapper.driver);
        mainPage.skip(driverWrapper.driver);
        mainPage.setUp(driverWrapper.driver);
        mainPage.Find(driverWrapper.driver,"клавиатура");
        searchPage.skipKupon();
        System.out.println(searchPage.getResults());
        searchPage.setUpFilters(driverWrapper.driver);
        System.out.println(searchPage.getResults());
    }
    @AfterMethod
    void end(){
        driverWrapper.close();
    }
}
