package qtriptest.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
    RemoteWebDriver driver;
    String URL = "https://qtripdynamic-qa-frontend.vercel.app/";

    @FindBy(name = "email")
    WebElement Email_box;

    @FindBy(name = "password")
    WebElement Password_box;

    @FindBy(css = ".btn-login")
    WebElement Register_btn;

    public LoginPage(RemoteWebDriver driver) {
        this.driver = driver;

        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public void PerformLogin(String username,String Password){
        Email_box.click();
        Email_box.sendKeys(username);
        Password_box.click();
        Password_box.sendKeys(Password);
        Register_btn.click();
    }
}
