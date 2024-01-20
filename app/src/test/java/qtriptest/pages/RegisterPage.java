package qtriptest.pages;

import java.util.UUID;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
public class RegisterPage {

    RemoteWebDriver driver;
    String URL = "https://qtripdynamic-qa-frontend.vercel.app/pages/register/";


    @FindBy(name = "email")
    WebElement Email_box;

    @FindBy(name = "password")
    WebElement Password_box;
    @FindBy(name = "confirmpassword")
    WebElement ConfirmPassword_box;

    @FindBy(css = ".btn-login")
    WebElement Register_btn;

    // @FindBy(className = "button")
    // WebElement Email_box;


    public RegisterPage(RemoteWebDriver driver) {
        this.driver = driver;

        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public void navigateToRegisterPage() {
        if (!driver.getCurrentUrl().equals(URL)) {
            driver.get(URL);
        }
    }

    public boolean VerifyNavigationRegister(){
        //System.err.print(driver.getCurrentUrl()+"----------");
        if (!driver.getCurrentUrl().equals(URL)) {
           return false;
        }
        return true;
    }

    public String RegisterUser(String userName, String Password,boolean generateRandomUsername){
       
        if (generateRandomUsername == true){
            // String a="testuser@gmail.com";
             int ind=userName.indexOf("@");
            // String r=a.substring(0,ind)+"---"+a.substring(ind);
            // userName = userName+UUID.randomUUID().toString();
            // userName+="@gmail.com";
            userName=userName.substring(0,ind)+UUID.randomUUID().toString()+userName.substring(ind);
        }

        Email_box.click();
        Email_box.sendKeys(userName);
        Password_box.click();
        Password_box.sendKeys(Password);
        ConfirmPassword_box.click();
        ConfirmPassword_box.sendKeys(Password);
        Register_btn.click();
        return userName;
    }
}
