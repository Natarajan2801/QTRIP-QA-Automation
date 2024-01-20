package qtriptest.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePage {
    RemoteWebDriver driver;
    String URL = "https://qtripdynamic-qa-frontend.vercel.app/";


    @FindBy(css =".register")
    WebElement Register_button;

    @FindBy(xpath  ="//div[text()='Logout']")
    WebElement Logout_button;


    public HomePage(RemoteWebDriver driver) {
        this.driver = driver;

        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public void navigateToHomePage() {
        if (!driver.getCurrentUrl().equals(URL)) {
            driver.get(URL);
        }
    }

    public void ClickRegister() {
        Register_button.click();
    }

public Boolean isUserLoggedin() {
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    try {
        return Logout_button.isDisplayed();
    } catch (Exception e) {
        return false;
    }
}

    public void logoutUser() {
      //  WebElement Logout_button=driver.findElement(By.xpath("//div[text()='Logout']"));
    
        Logout_button.click();
    }

}
