
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage {

    @FindBy(xpath = "//a[@class='next-dialog-close']")
    WebElement kupon;

    @FindBy(xpath = "//span[@class='next-breadcrumb-text activated']/span")
    WebElement result;

    @FindBy(xpath = "//span[@class='feature-wrap']/span[1]/label/span/input")
    WebElement freeDelivery;

    @FindBy(xpath = "//span[@class='sort-by-wrapper']/span[4]")
    WebElement sortByCosts;

    public SearchPage(){
        PageFactory.initElements(DriverWrapper.driver,this);
    }


    @Step("Закрытие купона")
    public void closeKupon(){
        new WebDriverWait(DriverWrapper.driver,10).until(ExpectedConditions.elementToBeClickable(kupon));
        kupon.click();
    }

    @Step("Сортировка")
    public void sortByCostWithFreeDelivery()  {
        while (!freeDelivery.isEnabled()){
            DriverWrapper.driver.navigate().refresh();
        }
        if(freeDelivery.getAttribute("aria-checked").equals("false")){
            freeDelivery.click();
        }
        while (sortByCosts.getAttribute("class").equals("sort-item") | !sortByCosts.getAttribute("ae_object_value").equals("price(highest)")){
            WebDriverWait wait = new WebDriverWait(DriverWrapper.driver,5);
            wait.until(ExpectedConditions.elementToBeSelected(freeDelivery));
            sortByCosts.click();
            wait.until(ExpectedConditions.elementToBeClickable(sortByCosts));
            wait.until(ExpectedConditions.attributeToBe(sortByCosts,"ae_object_value","price(highest)"));
        }

    }
    @Step("Результаты в консоль")
    public String GetResults(){
        String results = result.getText();
        if(freeDelivery.getAttribute("aria-checked").equals("true")){
            results += ", с бесплатной доставкой";
        }
        if(sortByCosts.getAttribute("class").equals("sort-item active")){
            results += ", цены указаны по возрастанию.";
        }
        return results;
    }

}
