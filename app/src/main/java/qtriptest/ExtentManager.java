// package qtriptest;

// import java.io.File;
// import com.relevantcodes.extentreports.ExtentReports;

// public class ExtentManager {
    
//     public static ExtentReports extentreport;
//     public static ExtentReports ExtentReports;
//     final static String reportpath=System.getProperty("user.dir")+File.separator+"reports"+File.separator+"qTripTestReport.html";
    
//     public static synchronized ExtentReports gReports(){
//         if(extentreport==null){
//             extentreport=new ExtentReports(reportpath);
//             extentreport.loadConfig(new File(System.getProperty("user.dir")+"/extent_customization_configs.xml"));
//         }

//         return extentreport;
//     }

// }
