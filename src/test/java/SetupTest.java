import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SetupTest {
    WebDriver webDriver;
   public  WebDriver setUpChromeDriver(){
       ChromeDriverManager.getInstance().version("75.0.3770.140").setup();
       webDriver=new ChromeDriver();
       webDriver.manage().window().maximize();
       return webDriver;
    }
    public void goToPage(String url,WebDriver webDriver){
        webDriver.get(url);
        webDriver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    }


}
