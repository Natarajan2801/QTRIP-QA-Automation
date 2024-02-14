// package qtriptest;

// import qtriptest.tests.BaseTest;
// import java.io.IOException;
// import com.relevantcodes.extentreports.LogStatus;
// import org.testng.ITestContext;
// import org.testng.ITestListener;
// import org.testng.ITestResult;

// public class Listener extends BaseTest implements ITestListener {

//     @Override  
//     public void onTestStart(ITestResult result) {  
//         // TODO Auto-generated method stub  
          
//     }  
  
//     @Override  
//     public void onTestSuccess(ITestResult result) {  
//         // TODO Auto-generated method stub  
//         ExtentTestManager.testLogger(LogStatus.PASS, "Test is passes");
//         try {
//             ExtentTestManager.getTest().addScreenCapture(SeleniumUtils.capture(driver));
//         } catch (IOException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         }
//         System.out.println("Success of test cases and its details are : "+result.getName());  
//     }  
  
//     @Override  
//     public void onTestFailure(ITestResult result) {  
//         // TODO Auto-generated method stub  
//         System.out.println("Failure of test cases and its details are : "+result.getName());  

//         ExtentTestManager.testLogger(LogStatus.FAIL, "Test is failed");
//         try {
//             ExtentTestManager.getTest().addScreenCapture(SeleniumUtils.capture(driver));
//         } catch (IOException e) {
//             // TODO Auto-generated catch block
//             e.printStackTrace();
//         }
//     }  
  
//     @Override  
//     public void onTestSkipped(ITestResult result) {  
//         // TODO Auto-generated method stub  
//         ExtentTestManager.testLogger(LogStatus.SKIP, "Test is skipped");
//         System.out.println("Skip of test cases and its details are : "+result.getName());  
//     }  
  
//     @Override  
//     public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
//         // TODO Auto-generated method stub  
//         System.out.println("Failure of test cases and its details are : "+result.getName());  
//     }  
  
//     @Override  
//     public void onStart(ITestContext context) {  
//         // TODO Auto-generated method stub  
          
//     }  
  
//     @Override  
//     public void onFinish(ITestContext context) {  
//         // TODO Auto-generated method stub  
          
//     }  



// }
