package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverSingleton;
import qtriptest.ReportSingleton;
import qtriptest.pages.AdventurePage;
import qtriptest.pages.HomePage;
import java.net.MalformedURLException;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


public class testCase_02{
  public static RemoteWebDriver driver;
  @BeforeTest(alwaysRun = true)
  public void setup() throws MalformedURLException {
      driver = DriverSingleton.getDriver();
      ReportSingleton.report= ReportSingleton.getReportInstance();
  }

  @Test(dataProvider = "dpM", dataProviderClass = DP.class, priority = 2,
      groups = {"Search and Filter flow"})
  public void TestCase02(String CityName, String Category_Filter, String DurationFilter,
      String ExpectedFilteredResults, String ExpectedUnFilteredResults)
      throws InterruptedException {
    
    Assertion assertion = new Assertion();
    boolean status;
    // logStatus("Page test", "navigation to register page", "started");
    ReportSingleton.test=ReportSingleton.report.startTest( "Verify that search and filter Work fine ");
    try {
    HomePage home = new HomePage(driver);
    home.navigateToHomePage();
    Thread.sleep(2000);
    home.searchCity("chennai");
    Thread.sleep(2000);
    status = home.assertAutoCompleteText("chennai");
    assertion.assertFalse(status, "Places found");
    Thread.sleep(2000);
    home.searchCity(CityName);
    Thread.sleep(2000);
    status = home.assertAutoCompleteText(CityName);
    assertion.assertTrue(status, "Places are not found");
    home.selectCity(CityName);

    AdventurePage adventurepg = new AdventurePage(driver);

    adventurepg.selectDuration_dropdown(DurationFilter);
    adventurepg.selectCategory_dropdown(Category_Filter);
    // status= adventurepg.VerifyFilterData();
    // assertion.assertTrue(status,"Appropriate data is not there");
    String expectedFilterReslut1 = adventurepg.getResultCount();
    assertion.assertEquals(ExpectedFilteredResults, expectedFilterReslut1,
        "Result values are not equal");
    adventurepg.clearCategory();
    adventurepg.clearDuration();
    String expectedUnFilterReslut1 = adventurepg.getResultCount();
    assertion.assertEquals(ExpectedUnFilteredResults, expectedUnFilterReslut1,
        "Result values are not equal");

     
         // Assert.assertEquals(adventurePage.getResultCount(), expectedFiltercount);
          ReportSingleton.test.log(LogStatus.PASS,ReportSingleton.test.addScreenCapture(ReportSingleton.capture(driver))+ "Succesfully  Verify Search and Filter flow ");
} catch (Exception e) {
//TODO: handle exception
ReportSingleton.test.log(LogStatus.FAIL,ReportSingleton.test.addScreenCapture(ReportSingleton.capture(driver))+ "Failed to Verify Search and Filter flow ");

}


}

@AfterTest(alwaysRun = true)
    public static void quitDriver() {
        System.out.println("quit()");
    //  driver.close();
      driver.quit();
      ReportSingleton.report.endTest(ReportSingleton.test);
      ReportSingleton.report.flush();
       
    }

  }