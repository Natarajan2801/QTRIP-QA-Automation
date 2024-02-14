  package qtriptest.tests;

  import qtriptest.DP;
  import qtriptest.DriverSingleton;
  import qtriptest.ReportSingleton;
  import qtriptest.pages.HomePage;
  import qtriptest.pages.LoginPage;
  import qtriptest.pages.RegisterPage;
  import java.io.IOException;
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

  public class testCase_01  {

    public static RemoteWebDriver driver;
    @BeforeTest(alwaysRun = true)
    public void setup() throws IOException
    {
        driver = DriverSingleton.getDriver();
        ReportSingleton.report= ReportSingleton.getReportInstance();
    }



    @Test(dataProvider = "dpM", dataProviderClass = DP.class, priority = 1, groups = {"Login Flow"})
    public void TestCase01(String usernameData, String passwordData) throws InterruptedException {
      ReportSingleton.test=ReportSingleton.report.startTest( "Verify User Registration Login-Logout");
      Assertion assertion = new Assertion();
      boolean status;
      logStatus("Page test", "navigation to register page", "started");
      try {
      HomePage home = new HomePage(driver);
      home.navigateToHomePage();
      home.ClickRegister();

      RegisterPage register = new RegisterPage(driver);
      Thread.sleep(3000);
      register.VerifyNavigationRegister();
      // assertion.assertTrue(status,"Not Moving to Register Page");
      String username = register.RegisterUser(usernameData, passwordData, true);
      LoginPage login = new LoginPage(driver);
      Thread.sleep(2000);
      login.PerformLogin(username, passwordData);
      Thread.sleep(2000);


        Assert.assertTrue(home.isUserLoggedin());
        ReportSingleton.test.log(LogStatus.PASS, ReportSingleton.test.addScreenCapture(ReportSingleton.capture(driver))+ "Sucessfully Login");
        status = home.isUserLoggedin();
        assertion.assertTrue(status, "User is not logged in");
        home.logoutUser();
    } catch (Exception e) {
        //TODO: handle exception

        ReportSingleton.test.log(LogStatus.FAIL,  ReportSingleton.test.addScreenCapture(ReportSingleton.capture(driver))+" Failed To  Login");
        
    }
    
    }

    public static void logStatus(String type, String message, String status) {
      System.out.println(String.format("%s |  %s  |  %s | %s",
          String.valueOf(java.time.LocalDateTime.now()), type, message, status));
    }

    @AfterTest(alwaysRun = true)
    public static void quitDriver() {
        System.out.println("quit()");
     //   driver.close();
        driver.quit();
        ReportSingleton.report.endTest(ReportSingleton.test);
        ReportSingleton.report.flush();

    }

  }
