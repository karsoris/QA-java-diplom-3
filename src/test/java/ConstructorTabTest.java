import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobjectmodel.MainPage;

public class ConstructorTabTest extends MainPageBase{



    @Test
    public void checkTabBunTest(){
        mainPage.clickOnFillingsSectionButton();
        mainPage.clickOnBunsSectionButton();
        boolean actual = mainPage.bunsHeader.isDisplayed();
        Assert.assertTrue(actual);
    }

    @Test
    public void checkTabSauceTest(){
        mainPage.clickOnSaucesSectionButton();

        boolean actual = mainPage.sauceHeader.isDisplayed();
        Assert.assertTrue(actual);
    }
    @Test
    public void checkTabFillingsTest(){
        mainPage.clickOnFillingsSectionButton();

        boolean actual = mainPage.fillingsHeader.isDisplayed();
        Assert.assertTrue(actual);
    }

}
