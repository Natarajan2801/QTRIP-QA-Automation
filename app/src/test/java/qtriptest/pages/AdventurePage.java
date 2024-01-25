package qtriptest.pages;


import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class AdventurePage {

    RemoteWebDriver driver;

    @FindBy(xpath = "//select[@name='duration']")
    WebElement Duration_dropdown;

    @FindBy(xpath = "//select[@id='category-select']")
    WebElement Category_dropdown;

    @FindBy(xpath = "//select[@name='duration']/../div")
    WebElement Duration_dropdown_Clear;

    @FindBy(xpath = "//select[@id='category-select']/../div")
    WebElement Category_dropdown_Clear;
    
    @FindBy(css = ".category-filter")
    WebElement UICategory;

    @FindBy(css = ".category-banner")
    List<WebElement> UICategorybelow;

    
    @FindBy(css = "#search-adventures")
    WebElement AdventureInput;

    @FindBy(css = ".img-responsive")
    WebElement AdventureItem;

    public AdventurePage(RemoteWebDriver driver) {
        this.driver = driver;

        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
    }

    public void selectDuration_dropdown(String Duration) {
        Select s = new Select(Duration_dropdown);
        s.selectByVisibleText(Duration);

    }

    public void selectCategory_dropdown(String category) {
        Select s = new Select(Category_dropdown);
        s.selectByVisibleText(category);

    }

    public void clearDuration() {
        Duration_dropdown_Clear.click();
    }

    public void clearCategory() {
        Category_dropdown_Clear.click();
    }

    public boolean VerifyFilterData() {
        String data = UICategory.getText();

        for (int i = 0; i < UICategorybelow.size(); i++) {
            if (!data.equals(UICategorybelow.get(i).getText())) {
                return false;
            }
        }
        return true;

    }

    public String getResultCount() {

        return  Integer.toString(UICategorybelow.size());
    }

    public void selectAdventure(String adventure) throws InterruptedException{
        AdventureInput.click();
        AdventureInput.sendKeys(adventure);
        AdventureInput.sendKeys(Keys.SPACE);
        Thread.sleep(3000);
        AdventureItem.click();

    }


}
