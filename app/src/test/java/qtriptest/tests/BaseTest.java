// package qtriptest.tests;

// import qtriptest.DriverSingleton;
// import qtriptest.ExtentManager;
// import qtriptest.ExtentTestManager;
// import qtriptest.SeleniumUtils;
// import java.io.IOException;
// import java.lang.reflect.Method;
// import java.net.MalformedURLException;
// import com.relevantcodes.extentreports.LogStatus;
// import org.openqa.selenium.remote.RemoteWebDriver;
// import org.testng.ITestResult;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.AfterSuite;
// import org.testng.annotations.AfterTest;
// import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.BeforeSuite;
// import org.testng.annotations.BeforeTest;

// public class BaseTest {
//      protected static RemoteWebDriver driver;

//      @BeforeSuite(alwaysRun = true)
//      public void setup() throws MalformedURLException{
//       //   driver=DriverSingleton.getInstance("CHROME");
//       ExtentManager.extentreport= ExtentManager.gReports();

//      }

//      @BeforeTest(alwaysRun = true)
//      public void beforeTest(Method m) throws MalformedURLException{
//           driver=DriverSingleton.getInstance("CHROME");

//           ExtentTestManager.startTest(m.getName());
//      }

//      // @AfterTest
//      // public void afterTest(ITestResult result) throws IOException{

//      //      if(result.getStatus() == ITestResult.SUCCESS){
//      //           ExtentTestManager.testLogger(LogStatus.PASS, "Test is passes");
//      //      }
//      //      else if(result.getStatus() == ITestResult.FAILURE){
//      //           ExtentTestManager.testLogger(LogStatus.FAIL, "Test is failed");
//      //           ExtentTestManager.getTest().addScreenCapture(SeleniumUtils.capture(driver));
//      //      }
//      //      else{
//      //           ExtentTestManager.testLogger(LogStatus.SKIP, "Test is skipped");
//      //      }
//      //      ExtentTestManager.endTest();
//      //      DriverSingleton.closeInstance();

//      // }


//      @AfterSuite
//      public void closeBrowser(){
//          	//driver.quit();
// 		//DriverSingleton.closeInstance();
//           ExtentManager.gReports().flush();
//      }
// }