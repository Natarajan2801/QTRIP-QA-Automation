// package qtriptest;

// import java.io.File;
// import java.io.IOException;
// import org.apache.commons.io.FileUtils;
// import org.openqa.selenium.OutputType;
// import org.openqa.selenium.TakesScreenshot;
// import org.openqa.selenium.remote.RemoteWebDriver;

// public class SeleniumUtils {
//     public static String capture(RemoteWebDriver driver) throws IOException{
//         File srcFile=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//         File desFile= new File(System.getProperty("user.dir")+"/reports/"+System.currentTimeMillis()+".png");
//         String errorFilePath=desFile.getAbsolutePath();
//         FileUtils.copyFile(srcFile, desFile);
//         return errorFilePath;
//     }
// }
