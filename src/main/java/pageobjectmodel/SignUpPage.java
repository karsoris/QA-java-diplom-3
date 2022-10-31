package pageobjectmodel;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//label[text()='Имя']//following-sibling::input")
    WebElement nameField;
    @FindBy(xpath = "//label[text()='Email']//following-sibling::input")
    WebElement emailField;
    @FindBy(xpath = "//label[text()='Пароль']//following-sibling::input")
    WebElement passwordField;
    @FindBy(xpath = "//button[text()='Зарегистрироваться']")
    WebElement signUpButton;
    @FindBy(xpath = "//a[@href='/login']")
    WebElement signInButton;
    @FindBy(xpath = "//p[text()='Некорректный пароль']")
    WebElement passwordErrorMessage;

    public void setEmailField(String email) {
        emailField.sendKeys(email);
    }
    public void setPasswordField(String password) {
        passwordField.sendKeys(password);
    }
    public void setNameField(String name) {
        nameField.sendKeys(name);
    }
    public void createUser(String email,String password,String name){
        setEmailField(email);
        setPasswordField(password);
        setNameField(name);
    }
    public void clickSignUpButton(){
        signUpButton.click();
    }
    public boolean getPasswordErrorMessage() {
        return passwordErrorMessage.isDisplayed();
    }
}
