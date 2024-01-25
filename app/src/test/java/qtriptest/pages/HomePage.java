package qtriptest.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
   
    @FindBy(css ="#autocomplete")
    WebElement search_box;

    @FindBy(xpath =" //ul[@id='results']/h5 | //ul[@id='results']//li")
    WebElement result_box;

    @FindBy(xpath = "//a[text()='Reservations']")
    WebElement ReservationBtn;

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
      //WebElement Logout_button=driver.findElement(By.xpath("//div[text()='Logout']"));
        Logout_button.click();
    }

    public void searchCity(String city){
        search_box.click();
        search_box.clear();
        search_box.sendKeys(city);
    }

    public void selectCity(String city){
        try{
        result_box.click();
        }
        catch(Exception e){
            search_box.sendKeys(Keys.SPACE);
            result_box.click();
        }
    }

    public boolean assertAutoCompleteText(String city){
        String res="";
        try{
         res=result_box.getText();
        }
        catch(Exception e){
                search_box.sendKeys(Keys.SPACE);
                res=result_box.getText();
        }
        if(res.equalsIgnoreCase(city)){
                return true;
        }
        return false;
    }

    public void ClickReservation(){
        ReservationBtn.click();
    }

}
