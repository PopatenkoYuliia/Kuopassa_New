package manager;


import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public CustomerServicePage getCustomerServicePage() {

        return new CustomerServicePage(driver);
    }

    public ProductPage getProductPage() {

        return new ProductPage(driver);
    }

    public SearchPage getSearchPage() {

        return new SearchPage(driver);
    }
    public ShoppingCartPage getShoppingCartPage() {
        return new ShoppingCartPage(driver);
    }
    public FilterPage getFilterPage() {
        return new FilterPage(driver);
    }
}
