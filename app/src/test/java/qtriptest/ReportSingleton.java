package qtriptest;

import java.io.File;
import java.io.IOException;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ReportSingleton {
    public static ExtentReports report;
    public static ExtentTest test;

    private ReportSingleton() {}

    public static ExtentReports getReportInstance() {
        if (report == null) {
            report = new ExtentReports(System.getProperty("user.dir") + "/extentReport.html");
            report.loadConfig(
                    new File(System.getProperty("user.dir") + "/extent_customization_configs.xml"));
        }
        return report;
    }


    public static String capture(RemoteWebDriver driver) {
        // TODO: Add all the components here


        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);


        File Dest = new File(System.getProperty("user.dir") + "/QKARTImages/"
                + System.currentTimeMillis() + ".png");


        String errflpath = Dest.getAbsolutePath();
        try {
            FileUtils.copyFile(scrFile, Dest);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return errflpath;

    }
}
