import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
       driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        MainPage mainpage = new MainPage(driver);
        SearchPage searchpage = new SearchPage(driver);

        String site = "https://aliexpress.ru/";
        driver.get(site);
        driver.manage().window().maximize();

        mainpage.skip(driver);
        mainpage.setUp(driver);
        mainpage.Find(driver,"клавиатура");
        searchpage.skipKupon();
        System.out.println(searchpage.getResults());
        searchpage.setUpFilters(driver);
        System.out.println(searchpage.getResults());
        //System.out.println((searchpage.getResults().replaceAll("[^0-9,]","")));




    }
}
