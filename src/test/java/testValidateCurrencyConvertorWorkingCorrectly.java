import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class testValidateCurrencyConvertorWorkingCorrectly {

    private WebDriver webDriver;
    SetupTest setupTest;
    LoginClass loginClass;
    FindElements findElements;
    @BeforeTest
    public void beforeTest() throws InterruptedException {
        setupTest=new SetupTest();
        loginClass=new LoginClass();
        findElements=new FindElements();
        webDriver=setupTest.setUpChromeDriver();
        setupTest.goToPage("http://zero.webappsecurity.com/",webDriver);
        loginClass.goToSignInForm(webDriver,findElements.findElement(By.id("signin_button"),webDriver));
        loginClass.signInToPage(webDriver,"username","password");
        findElements.clickOnElement(By.id("pay_bills_tab"),webDriver);
        findElements.clickOnElement(By.linkText("Purchase Foreign Currency"),webDriver);
        //this has to sleep to load the data in the ddl currency
        Thread.sleep(5000);
        WebElement currencyDDL=findElements.findElement(By.id("pc_currency"),webDriver);
        currencyDDL.click();
        findElements.clickOnListItemOption(By.tagName("option"),"Canada (dollar)",currencyDDL);
        findElements.sendKeys(findElements.findElement(By.id("pc_amount"),webDriver),"100");
        findElements.clickOnElement(By.id("pc_inDollars_true"),webDriver);
        findElements.clickOnElement(By.id("pc_calculate_costs"),webDriver);
    }
    @Test
    public void canadianDollarsWorkCorrectlyTest(){
            WebElement conversionAmount=findElements.findElement(By.id("pc_conversion_amount"),webDriver);
        Assert.assertEquals("94.19 dollar (CAD) = 100.00 U.S. dollar (USD)",conversionAmount.getText());
    }
}
