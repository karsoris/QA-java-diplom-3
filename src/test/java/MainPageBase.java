import extenstions.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjectmodel.*;

import java.util.concurrent.TimeUnit;


public class MainPageBase extends DriverFactory {
    WebDriver driver;
    DriverFactory driverFactory;

    String browserName;
    public final String pageUrl = "https://stellarburgers.nomoreparties.site/";
    MainPage mainPage;

    LoginPage loginPage;
    SignUpPage signUpPage;
    AccountPage accountPage;
    ForgotPasswordPage forgotPasswordPage;

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
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}