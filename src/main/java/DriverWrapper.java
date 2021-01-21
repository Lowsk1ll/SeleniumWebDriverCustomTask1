
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverWrapper {
    static WebDriver driver;
    String site = "https://aliexpress.ru/";
    public DriverWrapper() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe");

    }
    @Step("Запуск браузера")
    public void Init() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.get(site);
        driver.manage().window().maximize();
    }
    @Step("Закрытие браузера")
    public void Close() {
        driver.quit();
    }

    }

