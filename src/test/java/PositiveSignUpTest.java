import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjectmodel.LoginPage;
import pageobjectmodel.MainPage;

@RunWith(Parameterized.class)
public class PositiveSignUpTest extends MainPageBase {
    private int length;
    private boolean expected;



    public PositiveSignUpTest(int length, boolean expected) {
        this.length = length;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {6,false},
                {7,false}
        };
    }

    @DisplayName("Successful sign up user")
    @Test
    public void signUpWithValidPasswordLength() {
        String email = RandomStringUtils.randomAlphanumeric(5) + "@test.com";
        String password = RandomStringUtils.randomAlphanumeric(length);
        String name = RandomStringUtils.randomAlphanumeric(5);
        new MainPage(driver);
        mainPage.clickAccountButton();
        new LoginPage(driver);
        loginPage.clickSignUpButton();
        signUpPage.createUser(email,password,name);
        signUpPage.clickSignUpButton();
        Boolean actual = loginPage.loginPageIsDisplayed();;

        Assert.assertNotEquals(expected,actual);
    }




}
