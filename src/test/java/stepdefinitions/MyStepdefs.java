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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MyStepdefs {

    public static int actualSizeOfProductList;
    public static String titleOfProduct;
    public static String priceOfProduct;

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
        assertTrue("", actualTitle.contains(Constants.EXP_TITLE_CUSTOMER_SERVICE));
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
        assertEquals("", EXP_Q, amountOfProduct);
    }

    @When("Get product list")
    public void getProductList() {
        homePage.getList();
    }

    @And("Check quantity equals expected")
    public void checkQuantityEqualsExpected() {
        actualSizeOfProductList = homePage.getSizeOfProductList();
        Assert.assertEquals("Expected number of products '%s' but actual is '%s'", Constants.EXP_PRODUCT_LIST_SIZE, actualSizeOfProductList);
    }

    @Then("Check that minimal quantity of product has expected price")
    public void checkThatMinimalQuantityOfProductHasExpectedPrice() {
        List<String> prices = homePage.getListOfPrice();
        int expPrice = 0;
        for (String p : prices
        ) {
            if (p.contains(Constants.EXP_PRICE)) expPrice++;
        }
        assertTrue("The given quantity of the product does not correspond to the specification", expPrice >= 2);
    }

    @Then("Get title and price of product")
    public void getTitleAndPriceFirstProduct() {
        titleOfProduct = homePage.getTitle();
        priceOfProduct = homePage.getPrice();
        System.out.println(titleOfProduct);
        System.out.println(priceOfProduct);
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
        Assert.assertTrue("Title of product does not match the product added to the cart", textOfItem.contains(titleOfProduct));
        Assert.assertTrue("Price of product does not match the product added to the cart", textOfItem.contains(priceOfProduct));
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


    @Then("Check that at least {string} have {string}")
    public void checkThatAtLeastNumberOfProductsHaveExpectedPrice(final String numberOfProduct, final String expectedPrice) {
        List<String> prices = homePage.getListOfPrice();
        int expPrice = 0;
        for (String p : prices
        ) {
            if (p.contains(expectedPrice)) expPrice++;
        }
        int number = Integer.parseInt(numberOfProduct);
        Assert.assertTrue("Least number of product does not have expected price", expPrice >= number);
    }

    @When("Get {string} on Product Page")
    public void getNumberOfProduct(final String numberOfProduct) {
        int number = Integer.parseInt(numberOfProduct);
        homePage.clickOnNumberOfProduct(number);
    }
}


