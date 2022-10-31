import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.*;
import pageobjectmodel.*;

import java.util.concurrent.TimeUnit;

public class PositiveLoginTest extends MainPageBase {
    String email = RandomStringUtils.randomAlphanumeric(5) + "@test.com";
    String password = RandomStringUtils.randomAlphanumeric(6);
    String name = RandomStringUtils.randomAlphanumeric(5);

    @Before
    public void init() {
        driver = driverFactory.getBrowser();
        this.mainPage = new MainPage(driver);
        this.loginPage = new LoginPage(driver);
        this.signUpPage = new SignUpPage(driver);
        this.accountPage = new AccountPage(driver);
        this.forgotPasswordPage = new ForgotPasswordPage(driver);
        driver.get(pageUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        new MainPage(driver);
        mainPage.clickAccountButton();
        new LoginPage(driver);
        loginPage.clickSignUpButton();
        signUpPage.createUser(email, password, name);
        signUpPage.clickSignUpButton();
    }


    @DisplayName("Login user on sign in button")
    @Test
    public void loginTestSignInButton() {
        driver.get(pageUrl);

        mainPage.clickSignInButton();
        loginPage.loginUser(email, password);
        loginPage.clickSignInButton();
        mainPage.clickAccountButton();

        boolean actual = accountPage.profileButton.isDisplayed();
        Assert.assertTrue(actual);
    }

    @DisplayName("Login user on sign account button")
    @Test
    public void loginTestAccountButton() {
        driver.get(pageUrl);
        mainPage.clickAccountButton();
        loginPage.loginUser(email, password);
        loginPage.clickSignInButton();
        mainPage.clickAccountButton();

        boolean actual = accountPage.profileButton.isDisplayed();
        Assert.assertTrue(actual);

    }


    @DisplayName("Login user on sign after sing in button")
    @Test
    public void loginTestAfterSignIn() {

        driver.get(pageUrl + "login");
        loginPage.loginUser(email, password);
        loginPage.clickSignInButton();
        mainPage.clickAccountButton();


        boolean actual = accountPage.profileButton.isDisplayed();
        Assert.assertTrue(actual);
    }

    @DisplayName("Login user on sign Recover button")
    @Test
    public void loginTestArterRecoverPassword() {
        driver.get(pageUrl);
        mainPage.clickAccountButton();
        loginPage.clickRecoverPasswordButton();
       // driver.get(pageUrl+"forgot-password"); // без этой строки не вводился логин пароль. Причины понять не смог. В дебаге все нормально вводится.
        forgotPasswordPage.clickSignInButton();
        loginPage.loginUser(email, password);
        loginPage.clickSignInButton();
        mainPage.clickAccountButton();

        boolean actual = accountPage.profileButton.isDisplayed();
        Assert.assertTrue(actual);
    }
}

