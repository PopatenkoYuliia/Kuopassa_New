package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    private static final long DEFAULT_TIMEOUT = 60;

    @FindBy(xpath = "//header[@id='header']")
    private WebElement header;

    @FindBy(xpath = "//img[@title='Demokauppa']")
    private WebElement logotip;

    @FindBy(xpath = "//div[@id='region']")
    private WebElement regionChange;

    @FindBy(xpath = "//input[@type='search']")
    private WebElement inputSearch;

    @FindBy(xpath = "//input[@type='email']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@value='Sign In']")
    private WebElement signIn;

    @FindBy(xpath = "//a[contains(text(),'New customers click here')]")
    private WebElement buttonForNewCustomer;

    @FindBy(xpath = "//div[contains(text(),'Shopping Cart')]")
    private WebElement shoppingCart;

    @FindBy(xpath = "//a[contains(text(),'Customer Service')]")
    private WebElement linkCustomerService;

    @FindBy(xpath = "//a[@title='Purple Duck']")
    private WebElement purpleDuck;

    @FindBy(xpath = "//div[@id='box-popular-products']//div[@class='product column shadow hover-light']")
    private List<WebElement> productList;

    @FindBy(xpath = "//div[@id='box-popular-products']//span[@class='price']")
    private List<WebElement> priceList;

    @FindBy(xpath = "//h1[@class='title']")
    private WebElement titleProduct;

    @FindBy(xpath = "//*[@id='box-product']/div[1]/div[3]/div[2]/span")
    private WebElement priceProduct;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }


    public void clickOnCustomerServiceLink() {
        linkCustomerService.click();
    }

    public void clickOnPurpleDuck() {
        purpleDuck.click();
    }

    public void clickOnLogotip() {
        logotip.click();
    }

    public int getSizeOfProductList() {
        int size = productList.size();
        return size;
    }

    public List getList() {
        List<WebElement> product = productList;
        return product;
    }

    public WebElement getFirst() {
        WebElement first = productList.get(0);
        return first;
    }

    public void clickOnFirst() {
        WebElement first = productList.get(0);
        first.click();
    }

    public String getTitle() {
        String title = titleProduct.getText();
        return title;
    }

    public String getPrice() {
        String price = priceProduct.getText();
        return price;
    }

    public List<String> getListOfPrice() {
        ArrayList<String> price = new ArrayList<String>();
        for (int i = 0; i < priceList.size(); i++) {
            price.add(priceList.get(i).getText());
        }
        return price;
    }


}
