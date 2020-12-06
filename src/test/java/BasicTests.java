import org.testng.annotations.*;

public class BasicTests {
    DriverWrapper driverWrapper = new DriverWrapper();

    @BeforeMethod
    void setUp(){
        driverWrapper.init();
    }

    @Test   (description = "заходит на сайт")
    void Test1(){
        MainPage mainPage =new MainPage(driverWrapper.driver);
        mainPage.skip(driverWrapper.driver);
    }

    @Test   (description = "заходит на сайт и закрывает всплывающие окно")
    void Test2() throws InterruptedException {
        MainPage mainPage =new MainPage(driverWrapper.driver);
        mainPage.skip(driverWrapper.driver);
        mainPage.setUp(driverWrapper.driver);
    }
    @Test   (description = "заходит на сайт закрывает всплывающие окно и совершает поиск")
    void Test3() throws InterruptedException {
        MainPage mainPage = new MainPage(driverWrapper.driver);
        mainPage.skip(driverWrapper.driver);
        mainPage.setUp(driverWrapper.driver);
        mainPage.Find(driverWrapper.driver,"клавиатура");

    }

    @AfterMethod
    void end(){
        driverWrapper.close();
    }
}
