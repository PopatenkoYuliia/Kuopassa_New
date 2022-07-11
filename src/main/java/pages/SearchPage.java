package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends BasePage {
    @FindBy(xpath = "//div[@class='col-xs-halfs col-sm-thirds col-md-fourths col-lg-fifths']")
    private List<WebElement> productList;

    public SearchPage(WebDriver driver) {
        super(driver);
    }
}
