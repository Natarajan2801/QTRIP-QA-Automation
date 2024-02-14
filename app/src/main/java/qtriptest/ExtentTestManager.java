// package qtriptest;

// import java.util.HashMap;
// import java.util.Map;
// import com.relevantcodes.extentreports.ExtentReports;
// import com.relevantcodes.extentreports.ExtentTest;
// import com.relevantcodes.extentreports.LogStatus;

// public class ExtentTestManager {
//     static ExtentReports extentreport=ExtentManager.gReports();
//     static Map<Object,Object> extentmap=new HashMap<>();

//     public static ExtentTest startTest(String testName){
//         ExtentTest extentTest=extentreport.startTest(testName);
//         extentmap.put((int)(long)Thread.currentThread().getId(), extentTest);
//         return extentTest;
//     }

//     public static ExtentTest getTest(){
//             return (ExtentTest)  extentmap.get((int)(long)Thread.currentThread().getId());
//     }

//     public static void testLogger(LogStatus status,String description){
//         getTest().log(status, description);
//     }

//     public static void endTest(){
//         extentreport.endTest(getTest());
//     }
    
// }
