import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    @FindBy(xpath = "//img[@class='_24EHh']")
    WebElement closeNotificationSuggestions;

    @FindBy(xpath = "//a[@class='switcher-info notranslate']")
    WebElement countryLanguageCurrency;

    @FindBy(xpath = "//div[@data-role='switch-country']/a")
    WebElement switchCountry;

    @FindBy(xpath = "//span[@class='shipping-text']")
    WebElement country;

    @FindBy(xpath = "//div[@data-role='language-container']")
    WebElement switchLanguage;

    @FindBy(xpath = "//span[@data-role='language-input']/a")
    WebElement language;

    @FindBy(xpath = "//div[@data-role='switch-currency']/span")
    WebElement switchCurrency;

    @FindBy(xpath = "//div[@data-role='switch-currency']/span/a")
    WebElement currency;

    @FindBy(xpath = "//div/button[@data-role='save']")
    WebElement saveButton;

    @FindBy(xpath = "//div/input[@name='SearchText']")
    WebElement searchString;

    @FindBy(xpath = "//div/input[@type='submit']")
    WebElement findButton;

    @FindBy(xpath = "//img[@class='btn-close']")
    WebElement skipKupon;



    public MainPage() {
        PageFactory.initElements(DriverWrapper.driver,this);
    }
    public void closeKupon(){
        WebDriverWait wait = new WebDriverWait(DriverWrapper.driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(skipKupon));
        skipKupon.click();

    }
    @Step("Закрытие предложения об уведомлениях")
    public void closeNotifiacationSuggestions(){
        WebDriverWait wait = new WebDriverWait(DriverWrapper.driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(closeNotificationSuggestions));
        closeNotificationSuggestions.click();
    }
    @Step("Настройка языка,валюты,региона")
    public void changeCountryLanguageCurrencySettings()  {
        countryLanguageCurrency.click();
        String needCountry = "United States";
        String needLanguage = "Русский";
        String needCurrency = "UAH";
        WebDriverWait wait = new WebDriverWait(DriverWrapper.driver,5);
        String country = this.country.getText();
        if (!country.equals(needCountry)) {
            wait.until(ExpectedConditions.elementToBeClickable(switchCountry));
            switchCountry.click();

            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='address-select']/ul/li[@data-name='"+needCountry+"']")));
            DriverWrapper.driver.findElement(By.xpath("//div[@class='address-select']/ul/li[@data-name='"+needCountry+"']")).click();
        }
        String language = this.language.getText();
        if (!language.equals(needLanguage)) {
            wait.until(ExpectedConditions.elementToBeClickable(switchLanguage));
            switchLanguage.click();

            wait.until(ExpectedConditions.attributeToBe(switchLanguage,"class","switcher-currency-c language-selector hover"));
            DriverWrapper.driver.findElement(By.xpath("//div[@data-role='language-container']/ul/li/a[text()='"+needLanguage+"']")).click();
        }

        String currency = this.currency.getText();
        if (!currency.contains(needCurrency)) {
            wait.until(ExpectedConditions.elementToBeClickable(switchCurrency));
            switchCurrency.click();

            wait.until(ExpectedConditions.attributeToBe(switchCurrency,"class","select-item chang-border"));
            DriverWrapper.driver.findElement(By.xpath("//div[@data-role='switch-currency']/ul/li/a[@data-currency='"+needCurrency+"']")).click();
        }
        wait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }
    @Step("Поиск по слову")
    public void find(String findWord){
        WebDriverWait wait = new WebDriverWait(DriverWrapper.driver,5);
        wait.until(ExpectedConditions.invisibilityOf(saveButton));
        searchString.sendKeys(findWord);
        findButton.click();
    }
}