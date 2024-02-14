package qtriptest.tests;

import qtriptest.DP;
import qtriptest.DriverSingleton;
import qtriptest.ReportSingleton;
import qtriptest.pages.AdventureDetailsPage;
import qtriptest.pages.AdventurePage;
import qtriptest.pages.HistoryPage;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import qtriptest.pages.RegisterPage;
import java.net.MalformedURLException;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class testCase_03 {
  public static RemoteWebDriver driver;


  @BeforeTest(alwaysRun = true)
  public void setup() throws MalformedURLException {
    driver = DriverSingleton.getDriver();
   // ReportSingleton.report= ReportSingleton.getReportInstance();
    
  }

  @Test(dataProvider = "dpM", dataProviderClass = DP.class,
      groups = {"Booking and Cancellation Flow"}, priority = 3)
  public void TestCase03(String NewUserName, String Password, String SearchCity,
      String AdventureName, String GuestName, String Date, String count)
      throws InterruptedException, MalformedURLException {
    // TestCases tc=new TestCases();
    // TestCases.testcase_03(NewUserName, Password, SearchCity, AdventureName, GuestName, Date,
    // count);

    ReportSingleton.test = ReportSingleton.report.startTest("Booking and Cancellation Flow");
    try {
    Assertion assertion = new Assertion();
    boolean status;
    logStatus("Page test", "navigation to register page", "started");
    HomePage home = new HomePage(driver);
    home.navigateToHomePage();
    home.ClickRegister();

    RegisterPage register = new RegisterPage(driver);
    Thread.sleep(3000);
    register.VerifyNavigationRegister();
    // assertion.assertTrue(status,"Not Moving to Register Page");
    String username = register.RegisterUser(NewUserName, Password, true);
    LoginPage login = new LoginPage(driver);
    Thread.sleep(2000);
    login.PerformLogin(username, Password);
    Thread.sleep(2000);
    status = home.isUserLoggedin();
    assertion.assertTrue(status, "User is not logged in");

    home.searchCity(SearchCity);
    Thread.sleep(2000);
    status = home.assertAutoCompleteText(SearchCity);
    assertion.assertTrue(status, "Places are not found");
    home.selectCity(SearchCity);

    AdventurePage adventurepg = new AdventurePage(driver);
    adventurepg.selectAdventure(AdventureName);

    AdventureDetailsPage adventureDetailspg = new AdventureDetailsPage(driver);
    adventureDetailspg.bookAdventure(GuestName, Date, count);
    Thread.sleep(4000);
    status = adventureDetailspg.isBookingSucessful();
    // status=home.assertAutoCompleteText(SearchCity);
      System.out.println(status);
    assertion.assertTrue(status, "Not Booked ");
    adventureDetailspg.ClickReservation();

    HistoryPage hp = new HistoryPage(driver);
    String TransactionID = hp.getReservation();
    hp.cancelReservation(TransactionID);
    Thread.sleep(4000);
    status = hp.checkTransactioIDPresent(TransactionID);
    assertion.assertTrue(status, "Reservation is failed to cancel");

   
   //   Assert.assertFalse(history.transactionId(), "Reservation Not canceled");
      ReportSingleton.test.log(LogStatus.PASS, ReportSingleton.test.addScreenCapture(ReportSingleton.capture(driver))+"Cancelation Successfull");
     } 
     catch (Exception e) {
      //TODO: handle exception
      ReportSingleton.test.log(LogStatus.FAIL, ReportSingleton.test.addScreenCapture(ReportSingleton.capture(driver))+"Cancelation Failed");
     }

  }


  public static void logStatus(String type, String message, String status) {
    System.out.println(String.format("%s |  %s  |  %s | %s",
        String.valueOf(java.time.LocalDateTime.now()), type, message, status));
  }

//   @AfterSuite
// public static void quitDriver() {
//     System.out.println("quit()");

//     driver.quit();
// }

@AfterTest(alwaysRun = true)
    public static void quitDriver() {
        System.out.println("quit()");
   //   driver.close();
      driver.quit();
      ReportSingleton.report.endTest(ReportSingleton.test);
      ReportSingleton.report.flush();
       
    }

}
