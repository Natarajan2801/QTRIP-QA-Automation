package qtriptest.pages;



import java.sql.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AdventureDetailsPage {

    RemoteWebDriver driver;

    @FindBy(xpath = "//input[@name='name']")
    WebElement nameInput;

    @FindBy(xpath = "//input[@name='date']")
    WebElement dateInput;

    @FindBy(xpath = "//input[@name='person']")
    WebElement personInput;
    
    @FindBy(css = ".reserve-button")
    WebElement reserveButton;

    @FindBy(css = ".alert-success ")
    WebElement verificationPopup;


    //.alert-success 
    @FindBy(xpath = "//a[text()='Reservations']")
    WebElement ReservationBtn;

    public AdventureDetailsPage(RemoteWebDriver driver) {
        this.driver = driver;

        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public void bookAdventure(String name, String date,String count) throws InterruptedException{
      //  Thread.sleep(2000);
        nameInput.click();
        nameInput.sendKeys(name);
        
        dateInput.click();
        dateInput.sendKeys(date);
        
        personInput.click();
        personInput.sendKeys(count);

        reserveButton.click();

    }

    public boolean isBookingSucessful(){
        return verificationPopup.isDisplayed();
    }

    public void ClickReservation(){
        ReservationBtn.click();
    }


}