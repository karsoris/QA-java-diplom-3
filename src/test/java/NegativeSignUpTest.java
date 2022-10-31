import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import pageobjectmodel.LoginPage;
import pageobjectmodel.MainPage;

public class NegativeSignUpTest extends MainPageBase{

    @DisplayName("Unsuccessful sign up user")
    @Test
    public void signUpWithInValidPasswordLength() {
        new MainPage(driver);
        mainPage.clickAccountButton();
        new LoginPage(driver);
        loginPage.clickSignUpButton();
        signUpPage.createUser(RandomStringUtils.randomAlphanumeric(5) + "@test.com",RandomStringUtils.randomAlphanumeric(5),RandomStringUtils.randomAlphanumeric(5));
        signUpPage.clickSignUpButton();
        Boolean actual = signUpPage.getPasswordErrorMessage();

        Assert.assertTrue(actual);
    }
}
