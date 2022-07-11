package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


}
