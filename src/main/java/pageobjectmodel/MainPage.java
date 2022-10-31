package pageobjectmodel;


import org.openqa.selenium.*;
import org.openqa.selenium.support.*;


public class MainPage {
    WebDriver driver;


    public MainPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);


    }



    @FindBy(xpath = ".//h1[text()='Соберите бургер']")
    public WebElement burgerConstructorHeader;

    @FindBy(xpath = ".//button[text()='Войти в аккаунт']")
    public WebElement signInButton;

    @FindBy(xpath = ".//p[text()='Личный Кабинет']")
    public WebElement accountButton;
    @FindBy(xpath = ".//span[text()='Булки']")
    public WebElement bunsTab;
    @FindBy(xpath = ".//h2[text()='Булки']")
    public WebElement bunsHeader;
    @FindBy(xpath = ".//span[text()='Соусы']")
    public WebElement sauceTab;
    @FindBy(xpath = ".//h2[text()='Соусы']")
    public WebElement sauceHeader;
    @FindBy(xpath = ".//span[text()='Начинки']")
    public WebElement fillingsTab;
    @FindBy(xpath = ".//h2[text()='Начинки']")
    public WebElement fillingsHeader;

    public void clickAccountButton() {
        accountButton.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickOnBunsSectionButton() {
        bunsTab.click();
    }

    public void clickOnSaucesSectionButton() {
        sauceTab.click();
    }

    public void clickOnFillingsSectionButton() {
        fillingsTab.click();
    }




}
