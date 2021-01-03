import org.testng.annotations.*;

public class BasicTests {
    DriverWrapper driverWrapper = new DriverWrapper();

    @BeforeMethod
    void setUp(){
        driverWrapper.Init();
    }

    @Test  (description = "заходит на сайт")
    void Test1(){
        MainPage mainPage =new MainPage();
        mainPage.Skip();
    }

    @Test   (description = "заходит на сайт и закрывает всплывающие окно")
    void Test2() {
        MainPage mainPage =new MainPage();
        mainPage.Skip();
        mainPage.SetUp();
    }
    @Test   (description = "заходит на сайт закрывает всплывающие окно и совершает поиск")
    void Test3(){
        MainPage mainPage = new MainPage();
        mainPage.Skip();
        mainPage.SetUp();
        mainPage.Find("клавиатура");

    }

    @AfterMethod
    void end(){
        driverWrapper.Close();
    }
}
