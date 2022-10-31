package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    WebDriver driver;
    @FindBy(xpath = ".//input[@name='name']")
    WebElement emailField;
    @FindBy(xpath = ".//button[text()='Восстановить']")
    WebElement recoverButton;
    @FindBy(xpath = ".//a[@href='/login']")
    WebElement signInButton;

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickSignInButton(){
        signInButton.click();
    }
}
