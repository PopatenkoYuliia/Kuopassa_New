package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//*[@id='box-checkout-cart']/div")
    private WebElement tableResponsive;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public String getTextItem() {
        waitVisibilityOfElement(60, tableResponsive);
        String itemText = tableResponsive.getText();
        return itemText;
    }

}
