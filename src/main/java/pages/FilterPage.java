package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FilterPage extends BasePage{
    @FindBy(xpath = "//span[@class='btn btn-default active']")
    private WebElement filterByPrice;

    @FindBy(xpath = "//span[@class='price']")
    private List<WebElement> priceOfProducts;



    public FilterPage(WebDriver driver) {
        super(driver);
    }
    public void openFilterPage(String url) {
        driver.get(url);
    }
    public void clickOnFilterByPrice(){
        filterByPrice.click();
    }
    public ArrayList<String> getListOfPrice(){
        ArrayList<String> priceNoFilter = new ArrayList<String>();
        for (int i = 0; i < priceOfProducts.size(); i++) {
            priceNoFilter.add(priceOfProducts.get(i).getText());

        }
        return priceNoFilter;
    }
}
