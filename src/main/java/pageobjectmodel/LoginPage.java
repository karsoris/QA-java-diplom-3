package pageobjectmodel;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = ".//input[@name='name']")
    WebElement emailField;
    @FindBy(xpath = ".//input[@type='password']")
    WebElement passwordField;
    @FindBy(xpath = ".//button[text()='Войти']")
    WebElement signInButton;
    @FindBy(xpath = ".//a[@href='/register']")
    WebElement signUpButton;
    @FindBy(xpath = ".//a[@href='/forgot-password']")
    WebElement recoverPasswordButton;
    @FindBy(xpath = ".//h2[text()='Вход']")
    public WebElement signInHeader;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void loginUser(String email, String password){
        enterEmailField(email);
        enterPasswordField(password);
    }

    public void enterPasswordField(String password) {
        passwordField.sendKeys(password);
    }
    public void enterEmailField(String email){
        emailField.sendKeys(email);
    }
    public void clickSignUpButton() {
        signUpButton.click();
    }
    public void clickSignInButton() {
        signInButton.click();
    }
    public boolean loginPageIsDisplayed(){
       return signInButton.isDisplayed();
    }
    public void clickRecoverPasswordButton(){
        recoverPasswordButton.click();
    }


}
