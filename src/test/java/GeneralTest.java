import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GeneralTest {
    DriverWrapper driverWrapper = new DriverWrapper();

    @BeforeMethod
    void setUp(){
        driverWrapper.Init();
    }

    @Test(invocationCount = 2)
    void Test()  {
        MainPage mainPage = new MainPage();
        SearchPage searchPage = new SearchPage();
        mainPage.Skip();
        mainPage.SetUp();
        mainPage.Find("клавиатура");
        searchPage.SkipKupon();
        System.out.println(searchPage.GetResults());
        searchPage.setUpFilters();
        System.out.println(searchPage.GetResults());

    }
    @AfterMethod
    void end(){
        driverWrapper.Close();
    }
}
