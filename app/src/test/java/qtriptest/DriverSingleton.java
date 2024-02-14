package qtriptest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.BrowserType;

public class DriverSingleton {
    private static RemoteWebDriver driver=null;

    private DriverSingleton(){

    }

    public static RemoteWebDriver getDriver() throws MalformedURLException{
        if(driver==null){
        final DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(BrowserType.CHROME);
        driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
       // System.out.println("createDriver()");
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
         driver.manage().window().maximize();
         System.out.println("driver");
            }
        return driver;
    }

    public static void closeInstance(){
        driver.quit();
    }
}