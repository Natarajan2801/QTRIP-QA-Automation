package qtriptest;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumWrapper {


    public static RemoteWebDriver driver;

    // public SeleniumWrapper() {
    //     SeleniumWrapper.driver = driver;
    // }



    public static boolean click(WebElement e) throws MalformedURLException {
        // System.out.println("WebElement " + e + " is displaying" + e.isDisplayed());
        if (e.isDisplayed()) {
            Actions act = new Actions(DriverSingleton.getDriver());
            act.moveToElement(e).click().perform();
            return true;

        } else
            return false;
    }



    public static boolean sendKeys(WebElement inputBox, String keysToSend) {
        if (inputBox.isDisplayed()) {
            inputBox.clear();
            inputBox.sendKeys(keysToSend);
            return true;
        }

        else
            return false;

    }


    public static boolean navigate(WebDriver driver, String url) {
        boolean status;
        status = driver.getCurrentUrl().equals(url);
        if (!status) {
            driver.get(url);
        } else {
            return status;
        }
        return status;


    }

    public static WebElement findElementWithRetry(WebDriver driver, By by, int retryCount) {

        WebElement ele = null;
        for (int i = 0; i < retryCount; i++) {
            ele = driver.findElement(by);
        }
        return ele;

    }
}

