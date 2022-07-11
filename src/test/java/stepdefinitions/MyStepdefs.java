package stepdefinitions;

import configurations.Constants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import manager.PageFactoryManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class MyStepdefs {

    public static final String KUOPASSA_URL = "http://kuopassa.net/litecart";
    private static final long DEFAULT_TIMEOUT = 60;
    private static final String EXP_TITLE_CUSTOMER_SERVICE = "Customer Service";
    WebDriver driver;
    HomePage homePage;
    BasePage basePage;
    CustomerServicePage customerServicePage;
    ProductPage productPage;
    SearchPage searchPage;

    PageFactoryManager pageFactoryManager;


    @Before
    public void testsSetUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens home page")
    public void openPage() {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(Constants.KUOPASSA_URL);
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @When("User click on link Customer Service")
    public void userClickOnLinkCustomerService() {
        homePage = pageFactoryManager.getHomePage();
        homePage.clickOnCustomerServiceLink();
    }

    @Then("The user sees new page with title Customer Service")
    public void theUserSeesNewPageWithTitleCustomerService() {
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(EXP_TITLE_CUSTOMER_SERVICE));
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @When("User click on first product")
    public void userClickOnFirstProduct() {
    }

    @When("User click on purple duck")
    public void userClickOnPurpleDuck() {
        homePage.clickOnPurpleDuck();
    }

    @And("User clicks add to cart")
    public void userClicksAddToCart() {
        productPage.clickAddToCartButton();
    }

    @And("The user set {string}")
    public void theUserSetQuantityOfProduct(final String quantity) {
        productPage = pageFactoryManager.getProductPage();
        productPage.setInputQuantityProduct(quantity);
    }

    @Then("The user sees {string}in shopping cart")
    public void theUserSeesOneProductInShoppingCart(final String EXP_Q) throws InterruptedException {
        String amountOfProduct = productPage.getShoppingCartText();
        org.junit.Assert.assertEquals(EXP_Q, amountOfProduct);
    }

}


