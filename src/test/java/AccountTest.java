import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pageobjectmodel.*;

import java.util.concurrent.TimeUnit;

public class AccountTest extends MainPageBase {
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
        driver.get(pageUrl);

        mainPage.clickSignInButton();
        loginPage.loginUser(email, password);
        loginPage.clickSignInButton();

    }

    @DisplayName("Check open account")
    @Test
    public void checkAccountButton() {
        mainPage.clickAccountButton();

        boolean actual = accountPage.profileButton.isDisplayed();
        Assert.assertTrue(actual);
    }
}
