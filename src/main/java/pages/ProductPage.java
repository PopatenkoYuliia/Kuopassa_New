package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//input[@name='quantity']")
    private WebElement inputQuantityOfProduct;

    @FindBy(xpath = "//button[@name='add_cart_product']")
    private WebElement buttonAddToCart;

    @FindBy(xpath = "//span[@class='quantity']")
    private WebElement shoppingCart;

    @FindBy(xpath = "//a[@class='logotype']")
    private WebElement logotip;

    @FindBy(xpath = "//a[contains(text(),'Customer Service')]")
    private WebElement linkCustomerService;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLogotip() {
        logotip.click();
    }

    public void clickAddToCartButton() throws InterruptedException {
        buttonAddToCart.click();
        Thread.sleep(1000);
    }

    public void setInputQuantityProduct(final String quantity) {
        inputQuantityOfProduct.clear();
        inputQuantityOfProduct.sendKeys(quantity);
    }

    public String getShoppingCartText() throws InterruptedException {
        waitVisibilityOfElement(60,shoppingCart);
        waitForPageLoadComplete(60);
        Thread.sleep(600);
        String scText = shoppingCart.getText();
        return scText;
    }

    public void clickOnCustomerServiceLink() {
        linkCustomerService.click();
    }

    public void clickOnCart(){
        shoppingCart.click();
    }

}
