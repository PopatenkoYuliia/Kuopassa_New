package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void implicitWait(long timeToWait) {
        driver.manage().timeouts().implicitlyWait(timeToWait, TimeUnit.SECONDS);
    }

    public void waitForPageLoadComplete(Duration timeToWait) {
        new WebDriverWait(driver, timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitVisibilityOfElement(Duration timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitVisibilityOfElements(Duration timeToWait, List<WebElement> elements) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }
//    public void waitVisibilityOfText(Duration timeToWait, WebElement elements, String text) {
//        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
//        wait.until(ExpectedConditions.invisibilityOfElementWithText(text));
//    }

    public enum PagesName {
        BASE_PAGE("basePage"),
        CUSTOMER_SERVICE_PAGE("https://kuopassa.net/litecart/en/customer-service-s-0"),
        PRODUCT_PAGE("https://kuopassa.net/litecart/en/rubber-ducks-c-1/purple-duck-p-5"),
        SEARCH_PAGE("https://kuopassa.net/litecart/en/rubber-ducks-c-1/"),
        HOME_PAGE("http://kuopassa.net/litecart/en/");


        private final String name;

        PagesName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        public String getName() {
            return name;
        }
    }
}


