// package qtriptest.tests;

// import qtriptest.DriverSingleton;
// import qtriptest.ExtentTestManager;
// import qtriptest.SeleniumUtils;
// import qtriptest.pages.AdventureDetailsPage;
// import qtriptest.pages.AdventurePage;
// import qtriptest.pages.HistoryPage;
// import qtriptest.pages.HomePage;
// import qtriptest.pages.LoginPage;
// import qtriptest.pages.RegisterPage;
// import java.io.IOException;
// import java.lang.reflect.Method;
// import java.net.MalformedURLException;
// import java.net.URL;
// import java.util.concurrent.TimeUnit;
// import com.relevantcodes.extentreports.LogStatus;
// import org.openqa.selenium.remote.BrowserType;
// import org.openqa.selenium.remote.DesiredCapabilities;
// import org.openqa.selenium.remote.RemoteWebDriver;
// import org.testng.ITestResult;
// import org.testng.annotations.AfterClass;
// import org.testng.annotations.AfterSuite;
// import org.testng.annotations.AfterTest;
// import org.testng.annotations.BeforeClass;
// import org.testng.annotations.BeforeSuite;
// import org.testng.annotations.BeforeTest;
// import org.testng.annotations.Test;
// import org.testng.asserts.Assertion;

// public class TestCases {
    // static RemoteWebDriver driver;

	// // Method to help us log our Unit Tests
	// public static void logStatus(String type, String message, String status) {
	// 	System.out.println(String.format("%s |  %s  |  %s | %s",
	// 			String.valueOf(java.time.LocalDateTime.now()), type, message, status));
	// }

	// Iinitialize webdriver for our Unit Tests
	// @BeforeSuite(alwaysRun = true, enabled = true)
	// public static void createDriver(Method m) throws MalformedURLException {
	// 	logStatus("driver", "Initializing driver", "Started");
	// 	driver=DriverSingleton.getInstance("CHROME");
	// 	ExtentTestManager.startTest(m.getName());

	// 	logStatus("driver", "Initializing driver", "Success");
	//}

	//@Test(description = "Verify Register and Login Functionalities", enabled = true)
	// public static void testcase_01(String usernameData,String passwordData) throws InterruptedException {
		

	// }

	// public static void testcase_02(String CityName,String Category_Filter,String DurationFilter,String ExpectedFilteredResults, String ExpectedUnFilteredResults) throws InterruptedException
	//  {
		
	// }

	// public static void testcase_03(String NewUserName,String Password,String SearchCity,String AdventureName, String GuestName,String Date,String count) throws InterruptedException
	// {
		
	// }

	// public static void testcase_04(String NewUserName,String Password,String dataset1,String dataset2, String dataset3) throws InterruptedException
	// {
		
	// }

	

	// @AfterSuite(enabled = true)
	// public static void quitDriver(ITestResult result) throws IOException {
	// 	//	driver.close();
	// 	//	driver.quit();
	// 	     if(result.getStatus() == ITestResult.SUCCESS){
    //            ExtentTestManager.testLogger(LogStatus.PASS, "Test is passes");
    //       }
    //       else if(result.getStatus() == ITestResult.FAILURE){
    //            ExtentTestManager.testLogger(LogStatus.FAIL, "Test is failed");
    //            ExtentTestManager.getTest().addScreenCapture(SeleniumUtils.capture(driver));
    //       }
    //       else{
    //            ExtentTestManager.testLogger(LogStatus.SKIP, "Test is skipped");
    //       }
    //       ExtentTestManager.endTest();
	// 	DriverSingleton.closeInstance();
	// 	logStatus("driver", "Quitting driver", "Success");
	// }
//}
