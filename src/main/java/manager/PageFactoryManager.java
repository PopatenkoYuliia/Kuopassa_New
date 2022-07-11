package manager;


import org.openqa.selenium.WebDriver;
import pages.CustomerServicePage;
import pages.HomePage;
import pages.ProductPage;
import pages.SearchPage;

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
}
