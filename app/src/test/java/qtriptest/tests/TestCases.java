package qtriptest.tests;

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
		final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName(BrowserType.CHROME);
		driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
       
		//driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
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
       status= register.VerifyNavigationRegister();
       assertion.assertTrue(status,"Not Moving to Register Page");
       String username=register.RegisterUser(usernameData, passwordData, true);
        LoginPage login=new LoginPage(driver);
		Thread.sleep(2000);
        login.PerformLogin(username, passwordData);
		Thread.sleep(2000);
		status=home.isUserLoggedin();
		assertion.assertTrue(status,"User is not logged in");
		home.logoutUser();

	}

	@AfterTest(enabled = true)
	public static void quitDriver() throws MalformedURLException {
	//	driver.close();
		driver.quit();
		logStatus("driver", "Quitting driver", "Success");
	}
}
