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

public class testCase_04  {

  public static RemoteWebDriver driver ;
//  String lastGeneratedUsername ;
 
  @BeforeTest(alwaysRun = true)
     public void setup() throws MalformedURLException
     {
         driver = DriverSingleton.getDriver();
        // ReportSingleton.report= ReportSingleton.getReportInstance();
     }
     
  @Test(dataProvider = "dpM", dataProviderClass = DP.class, groups = {"Reliability Flow"},
      priority = 4)
  public void TestCase04(String NewUserName, String Password, String dataset1, String dataset2,
      String dataset3) throws InterruptedException {
   
    Assertion assertion = new Assertion();
    boolean status;
    logStatus("Page test", "navigation to register page", "started");
    HomePage home = new HomePage(driver);
    home.navigateToHomePage();
    home.ClickRegister();

    RegisterPage register = new RegisterPage(driver);
    Thread.sleep(1000);
    register.VerifyNavigationRegister();
    // assertion.assertTrue(status,"Not Moving to Register Page");
    String username = register.RegisterUser(NewUserName, Password, true);
    LoginPage login = new LoginPage(driver);
    Thread.sleep(2000);
    login.PerformLogin(username, Password);
    Thread.sleep(2000);
    status = home.isUserLoggedin();
    assertion.assertTrue(status, "User is not logged in");

    tc04Execution(dataset1, home);
    tc04Execution(dataset2, home);
    tc04Execution(dataset3, home);

    home.ClickReservation();
    Thread.sleep(2000);
    HistoryPage hp = new HistoryPage(driver);

    Thread.sleep(2000);
    int c = hp.getTransactionCount();
 //   assertion.assertEquals(c, 3, "Transaction count is invalid");


  }

  public static void tc04Execution(String Dataset, HomePage home) throws InterruptedException {
    try {
      Assertion assertion = new Assertion();
      boolean status;
      String[] data = Dataset.split(";");
      String SearchCity = data[0];
      String SearchAdventure = data[1];
      String guestName = data[2];
      String date = data[3];
      String count = data[4];
      Thread.sleep(1000);
      home.searchCity(SearchCity);
      Thread.sleep(3000);
      status = home.assertAutoCompleteText(SearchCity);
      assertion.assertTrue(status, "Places are not found");
      Thread.sleep(1000);
      home.selectCity(SearchCity);

      AdventurePage adventurepg = new AdventurePage(driver);
      adventurepg.selectAdventure(SearchAdventure);

      AdventureDetailsPage adventureDetailspg = new AdventureDetailsPage(driver);
      adventureDetailspg.bookAdventure(guestName, date, count);
      Thread.sleep(2000);
      status = adventureDetailspg.isBookingSucessful();
      assertion.assertTrue(status, "Not Booked ");
      home.navigateToHomePage();
     // try {
        ReportSingleton.test.log(LogStatus.PASS, ReportSingleton.test.addScreenCapture(ReportSingleton.capture(driver))+" Successfully  verified  booking history");
        //Assert.assertTrue(history.verifyNumberofReservationCount()  , ReportSingleton.test.addScreenCapture(ReportSingleton.capture(driver))+"Failed to verify records of reservation ");
      } catch (Exception e) {
        //TODO: handle exception
        ReportSingleton.test.log(LogStatus.FAIL, ReportSingleton.test.addScreenCapture(ReportSingleton.capture(driver))+" Failed to verify booking history");
      }

    // } catch (Exception e) {
    //   home.navigateToHomePage();
    // }
  }

  public static void logStatus(String type, String message, String status) {
    System.out.println(String.format("%s |  %s  |  %s | %s",
        String.valueOf(java.time.LocalDateTime.now()), type, message, status));
  }

  // @AfterSuite
  // public static void quitDriver() {
  //     System.out.println("quit()");
  //     driver.quit();
  
  //     ReportSingleton.report.endTest(ReportSingleton.test);
  //     ReportSingleton.report.flush();
  
  // }

  @AfterTest(alwaysRun = true)
    public static void quitDriver() {
        System.out.println("quit()");
    //  driver.close();
      driver.quit();
      ReportSingleton.report.endTest(ReportSingleton.test);
      ReportSingleton.report.flush();
       
    }


}
