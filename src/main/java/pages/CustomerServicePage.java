package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomerServicePage extends BasePage {

    @FindBy(xpath = "//form[@name='contact_form']")
    private WebElement formContactUs;
    @FindBy(xpath = "//input[@name='name']")
    private WebElement inputName;
    @FindBy(xpath = "//input[@name='email']")//переробити
    private WebElement inputEmail;
    @FindBy(xpath = "//input[@name='subject']")
    private WebElement inputSubject;
    @FindBy(xpath = "//textarea[@name='message']")
    private WebElement textArea;
    @FindBy(xpath = "//button[@name='send']")
    private WebElement buttonSend;
    @FindBy(xpath = "//a[contains(text(),'About Us')]")
    private WebElement linkAboutUs;

    public CustomerServicePage(WebDriver driver) {
        super(driver);
    }


}
