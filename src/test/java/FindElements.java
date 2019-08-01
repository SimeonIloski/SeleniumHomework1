import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElements {
public WebElement findElement(By by, WebDriver webDriver){
    return webDriver.findElement(by);
}
public void clickOnElement(By by,WebDriver webDriver){
    this.findElement(by,webDriver).click();
}
public void clickOnListItemOption(By by,String option, WebElement webElement){
    List<WebElement> ddl = webElement.findElements(by);
    clickWebOptionElementFromList(ddl,option);
    webElement.click();

}
public void clickWebOptionElementFromList(List<WebElement> ddl,String option){
    for (WebElement ddlOption : ddl) {
        String optionText = ddlOption.getText();
        if (optionText.contains(option)) {
            ddlOption.click();
            break;
        } }
}

public void sendKeys(WebElement webElement,String keys){
    webElement.sendKeys(keys);
}
}
