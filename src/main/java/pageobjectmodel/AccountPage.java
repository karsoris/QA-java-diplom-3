package pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy
    public WebElement editPasswordButton;
    @FindBy(xpath = ".//button[text()='Сохранить']")
    public WebElement saveProfileButton;
    @FindBy(xpath = ".//button[text()='Отмена']")
    public WebElement cancelProfileData;
    @FindBy(xpath = ".//a[text()='Профиль']")
    public WebElement profileButton;
    @FindBy(xpath = ".//a[text()='История заказов']")
    public WebElement orderHistoryButton;
    @FindBy(xpath = ".//button[text()='Выход']")
    public WebElement logoutButton;
    @FindBy(xpath = ".//p[text()='Конструктор']")
    public WebElement constructorButton;
    @FindBy(xpath = ".//div[@class='AppHeader_header__logo__2D0X2']")
    public WebElement constructorLogo;

    public void clickConstructorButton(){
        constructorButton.click();
    }
    public void clickConstructorLogo(){
        constructorLogo.click();
    }
    public void clickLogOutButton(){
        logoutButton.click();
    }
}
