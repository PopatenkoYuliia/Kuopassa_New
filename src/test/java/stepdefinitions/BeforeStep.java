package stepdefinitions;

import configurations.Constants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BeforeStep {
    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;

//    @Before
//    public void testsSetUp() {
//        chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        pageFactoryManager = new PageFactoryManager(driver);
//    }
//
//    @And("User opens home page")
//    public void openPage() {
//        homePage = pageFactoryManager.getHomePage();
//        homePage.openHomePage(Constants.KUOPASSA_URL);
//    }
//  @After
//    public void tearDown() {
//        driver.close();
//    }
}
