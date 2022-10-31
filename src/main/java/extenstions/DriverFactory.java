package extenstions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    public static WebDriver getBrowser() {

            String browserName = System.getProperty("browser");


        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/ChromeDriver/chromedriver.exe");
                WebDriver driverChrome = new ChromeDriver();
                return driverChrome;
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/YandexBrowser/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:/Users/karso/AppData/Local/Yandex/YandexBrowser/Application/browser.exe");
                WebDriver driverYandex = new ChromeDriver(options);
                return driverYandex;
            default: throw new RuntimeException("Invalid browser!");
        }
    }
}
