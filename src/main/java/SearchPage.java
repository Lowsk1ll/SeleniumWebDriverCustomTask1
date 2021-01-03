
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {
    @FindBy(xpath = "//div/a[@class='next-dialog-close']")
    WebElement CloseKupon;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div/div[1]/div[1]/div/div[2]/span/span")
    WebElement Result;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div/div[1]/div[2]/div[1]/span[3]/span[1]/label/span[1]/input")
    WebElement Sale;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/div/div[1]/div[2]/div[2]/div[1]/span/span[4]")
    WebElement SortByCosts;

    public SearchPage(){
        PageFactory.initElements(DriverWrapper.driver,this);
    }

    @Step("Закрытие купона после поиска")
    public void skipKupon(){
        CloseKupon.click();

    }
    @Step("Сортировка")
    public void setUpFilters()  {
        while (!Sale.isEnabled()){
            DriverWrapper.driver.navigate().refresh();
        }
        if(Sale.getAttribute("aria-checked").equals("false")){
            Sale.click();
            new WebDriverWait(DriverWrapper.driver,10).until(ExpectedConditions.elementToBeClickable(SortByCosts));
        }
        while (SortByCosts.getAttribute("class").equals("sort-item") || !SortByCosts.getAttribute("ae_object_value").equals("price(highest)")){
            SortByCosts.click();
            WebDriverWait wait = new WebDriverWait(DriverWrapper.driver,10);
            wait.until(ExpectedConditions.attributeToBe(SortByCosts,"ae_object_value","price(highest)"));
        }

    }
    @Step("Результаты в консоль")
    public String getResults(){
        String results = Result.getText();
        if(Sale.getAttribute("aria-checked").equals("true")){
            results += ", по акции";
        }
        if(SortByCosts.getAttribute("class").equals("sort-item active")){
            results += ", цены указаны по возрастанию.";
        }
        return results;
    }

}
