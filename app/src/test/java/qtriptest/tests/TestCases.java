package qtriptest.tests;

import qtriptest.DriverSingleton;
import qtriptest.pages.AdventureDetailsPage;
import qtriptest.pages.AdventurePage;
import qtriptest.pages.HistoryPage;
import qtriptest.pages.HomePage;
import qtriptest.pages.LoginPage;
import qtriptest.pages.RegisterPage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestCases {
    static RemoteWebDriver driver;

	// Method to help us log our Unit Tests
	public static void logStatus(String type, String message, String status) {
		System.out.println(String.format("%s |  %s  |  %s | %s",
				String.valueOf(java.time.LocalDateTime.now()), type, message, status));
	}

	// Iinitialize webdriver for our Unit Tests
	@BeforeTest(alwaysRun = true, enabled = true)
	public static void createDriver() throws MalformedURLException {
		logStatus("driver", "Initializing driver", "Started");
		driver=DriverSingleton.getInstance("CHROME");


		// final DesiredCapabilities capabilities = new DesiredCapabilities();
		// capabilities.setBrowserName(BrowserType.CHROME);
		// driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().window().maximize();

		logStatus("driver", "Initializing driver", "Success");
	}

	//@Test(description = "Verify Register and Login Functionalities", enabled = true)
	public static void testcase_01(String usernameData,String passwordData) throws InterruptedException {
		Assertion assertion = new Assertion();
        boolean status;
		logStatus("Page test", "navigation to register page", "started");
        HomePage home=new HomePage(driver);
        home.navigateToHomePage();
        home.ClickRegister();

        RegisterPage register=new RegisterPage(driver);
		Thread.sleep(3000);
       register.VerifyNavigationRegister();
       //assertion.assertTrue(status,"Not Moving to Register Page");
       String username=register.RegisterUser(usernameData, passwordData, true);
        LoginPage login=new LoginPage(driver);
		Thread.sleep(2000);
        login.PerformLogin(username, passwordData);
		Thread.sleep(2000);
		status=home.isUserLoggedin();
		assertion.assertTrue(status,"User is not logged in");
		home.logoutUser();

	}

	public static void testcase_02(String CityName,String Category_Filter,String DurationFilter,String ExpectedFilteredResults, String ExpectedUnFilteredResults) throws InterruptedException
	 {
		Assertion assertion = new Assertion();
        boolean status;
		//logStatus("Page test", "navigation to register page", "started");
        HomePage home=new HomePage(driver);
        home.navigateToHomePage();
		Thread.sleep(2000);
		home.searchCity("chennai");
		Thread.sleep(2000);
		status=home.assertAutoCompleteText("chennai");
		assertion.assertFalse(status,"Places found");
		Thread.sleep(2000);
		home.searchCity(CityName);
		Thread.sleep(2000);
		status=home.assertAutoCompleteText(CityName);
		assertion.assertTrue(status,"Places are not found");
		home.selectCity(CityName);

		AdventurePage adventurepg=new AdventurePage(driver);
	
		adventurepg.selectDuration_dropdown(DurationFilter);
		adventurepg.selectCategory_dropdown(Category_Filter);
		//status=	adventurepg.VerifyFilterData();
		//assertion.assertTrue(status,"Appropriate data is not there");
		String expectedFilterReslut1=adventurepg.getResultCount();
		assertion.assertEquals(ExpectedFilteredResults, expectedFilterReslut1, "Result values are not equal");
		adventurepg.clearCategory();
		adventurepg.clearDuration();
		String expectedUnFilterReslut1=adventurepg.getResultCount();
		assertion.assertEquals(ExpectedUnFilteredResults, expectedUnFilterReslut1, "Result values are not equal");
	
	}

	public static void testcase_03(String NewUserName,String Password,String SearchCity,String AdventureName, String GuestName,String Date,String count) throws InterruptedException
	{
		Assertion assertion = new Assertion();
        boolean status;
		logStatus("Page test", "navigation to register page", "started");
        HomePage home=new HomePage(driver);
        home.navigateToHomePage();
        home.ClickRegister();

        RegisterPage register=new RegisterPage(driver);
		Thread.sleep(3000);
       register.VerifyNavigationRegister();
      // assertion.assertTrue(status,"Not Moving to Register Page");
       String username=register.RegisterUser(NewUserName, Password, true);
        LoginPage login=new LoginPage(driver);
		Thread.sleep(2000);
        login.PerformLogin(username, Password);
		Thread.sleep(2000);
		status=home.isUserLoggedin();
		assertion.assertTrue(status,"User is not logged in");

		home.searchCity(SearchCity);
		Thread.sleep(2000);
		status=home.assertAutoCompleteText(SearchCity);
		assertion.assertTrue(status,"Places are not found");
		home.selectCity(SearchCity);

		AdventurePage adventurepg=new AdventurePage(driver);
		adventurepg.selectAdventure(AdventureName);

		AdventureDetailsPage adventureDetailspg=new AdventureDetailsPage(driver);
		adventureDetailspg.bookAdventure(GuestName, Date, count);
		Thread.sleep(4000);
		status=adventureDetailspg.isBookingSucessful();
	//	status=home.assertAutoCompleteText(SearchCity);
		
		assertion.assertTrue(status,"Not Booked ");
		adventureDetailspg.ClickReservation();

		HistoryPage hp=new HistoryPage(driver);
		String TransactionID=hp.getReservation();
		hp.cancelReservation(TransactionID);
		Thread.sleep(4000);
		status=hp.checkTransactioIDPresent(TransactionID);
		assertion.assertTrue(status,"Reservation is failed to cancel");
		
	}

	public static void testcase_04(String NewUserName,String Password,String dataset1,String dataset2, String dataset3) throws InterruptedException
	{
		Assertion assertion = new Assertion();
        boolean status;
		logStatus("Page test", "navigation to register page", "started");
        HomePage home=new HomePage(driver);
        home.navigateToHomePage();
        home.ClickRegister();

        RegisterPage register=new RegisterPage(driver);
		Thread.sleep(1000);
       register.VerifyNavigationRegister();
      // assertion.assertTrue(status,"Not Moving to Register Page");
       String username=register.RegisterUser(NewUserName, Password, true);
        LoginPage login=new LoginPage(driver);
		Thread.sleep(2000);
        login.PerformLogin(username, Password);
		Thread.sleep(2000);
		status=home.isUserLoggedin();
		assertion.assertTrue(status,"User is not logged in");
		tc04Execution(dataset1,home);
		tc04Execution(dataset2,home);
		tc04Execution(dataset3,home);

		home.ClickReservation();
		Thread.sleep(2000);
		HistoryPage hp=new HistoryPage(driver);

		Thread.sleep(2000);
		int c=hp.getTransactionCount();
		assertion.assertEquals(c, 3,"Transaction count is invalid");

	}

	public static void tc04Execution(String Dataset,HomePage home) throws InterruptedException
	{
		Assertion assertion = new Assertion();
        boolean status;
		String[] data=Dataset.split(";");
		String SearchCity=data[0];
		String SearchAdventure=data[1];
		String guestName=data[2];
		String date=data[3];
		String count=data[4];

		home.searchCity(SearchCity);
		Thread.sleep(1000);
		status=home.assertAutoCompleteText(SearchCity);
		assertion.assertTrue(status,"Places are not found");
		Thread.sleep(1000);
		home.selectCity(SearchCity);

		AdventurePage adventurepg=new AdventurePage(driver);
		adventurepg.selectAdventure(SearchAdventure);

		AdventureDetailsPage adventureDetailspg=new AdventureDetailsPage(driver);
		adventureDetailspg.bookAdventure(guestName, date, count);
		Thread.sleep(2000);
		status=adventureDetailspg.isBookingSucessful();
		assertion.assertTrue(status,"Not Booked ");
		home.navigateToHomePage();
	}

	@AfterTest(enabled = true)
	public static void quitDriver() throws MalformedURLException {
		//	driver.close();
		//	driver.quit();
		DriverSingleton.closeInstance();
		logStatus("driver", "Quitting driver", "Success");
	}
}
