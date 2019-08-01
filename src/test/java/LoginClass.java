import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginClass {
    String username;
    String password;
    FindElements findElements=new FindElements();

    void goToSignInForm(WebDriver webDriver, WebElement webElement){
        WebDriverWait webDriverWait=new WebDriverWait(webDriver,10);
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("signin_button")));
        webElement.click();
    }
    void signInToPage(WebDriver driver,String username,String password){
        WebElement usernameInput=findElements.findElement(By.id("user_login"),driver);
        WebElement passwordInput=findElements.findElement(By.id("user_password"),driver);
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        WebElement submitButton=findElements.findElement(By.className("btn-primary"),driver);
        submitButton.click();
    }
}
