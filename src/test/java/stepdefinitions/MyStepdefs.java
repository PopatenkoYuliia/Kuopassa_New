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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertTrue;

public class MyStepdefs {

    public static int actualSizeOfProductList;
    public static String titleOfFirstProduct;
    public static String priceOfFirstProduct;

    WebDriver driver;
    HomePage homePage;
    BasePage basePage;
    CustomerServicePage customerServicePage;
    ProductPage productPage;
    SearchPage searchPage;
    ShoppingCartPage shoppingCartPage;
    FilterPage filterPage;
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
        Assert.assertTrue(actualTitle.contains(Constants.EXP_TITLE_CUSTOMER_SERVICE));
    }

    @Given("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }


    @When("User click on purple duck")
    public void userClickOnPurpleDuck() {
        homePage.clickOnPurpleDuck();
    }

    @And("User clicks add to cart")
    public void userClicksAddToCart() throws InterruptedException {
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

    @When("Get product list")
    public void getProductList() {
        homePage.getList();
    }

    @And("Check quantity equals expected")
    public void checkQuantityEqualsExpected() {
        actualSizeOfProductList = homePage.getSizeOfProductList();
        Assert.assertEquals(Constants.EXP_PRODUCT_LIST_SIZE, actualSizeOfProductList);
    }

    @Then("Check that minimal quantity of product has expected price")
    public void checkThatMinimalQuantityOfProductHasExpectedPrice() {
        List<String> prices = homePage.getListOfPrice();
        int expPrice = 0;
        for (String p : prices
        ) {
            if (p.contains(Constants.EXP_PRICE)) expPrice++;
        }
        Assert.assertTrue(expPrice >= 2);
    }

    @When("Get first product")
    public void getFirstProduct() {
        homePage.clickOnFirst();
    }

    @Then("Get title and price first product")
    public void getTitleAndPriceFirstProduct() {
        titleOfFirstProduct = homePage.getTitle();
        priceOfFirstProduct = homePage.getPrice();
        System.out.println(titleOfFirstProduct);
        System.out.println(priceOfFirstProduct);
    }

    @And("Add product to cart")
    public void addProductToCart() throws InterruptedException {
        productPage = pageFactoryManager.getProductPage();
        productPage.clickAddToCartButton();
    }

    @And("Open cart")
    public void openCart() {
        productPage.clickOnCart();
    }

    @Then("Check this product in the cart")
    public void checkThisProductInTheCart() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        String textOfItem = shoppingCartPage.getTextItem();
        Assert.assertTrue(textOfItem.contains(titleOfFirstProduct));
        Assert.assertTrue(textOfItem.contains(priceOfFirstProduct));
    }

    @Given("User on filter page")
    public void userOnFilterPage() {
        filterPage = pageFactoryManager.getFilterPage();
        filterPage.openFilterPage(Constants.KUOPASSA_FILTER_URL);
    }

    @When("User click on filter by price")
    public void userClickOnFilterByPrice() {
        filterPage.clickOnFilterByPrice();
    }

    @Then("User sees that products are filtered")
    public void userSeesThatProductsAreFiltered() {
        String priceString;
        double oldPrice = 0;
        double priceOfProduct;
        for (WebElement price : filterPage.getListOfProduct()
        ) {
            priceString = price.getText().split(" ")[0].substring(1);
            priceOfProduct = Double.parseDouble(priceString.replace(',', '.'));
            assertTrue(priceOfProduct >= oldPrice);
            oldPrice = priceOfProduct;
        }
    }
}


