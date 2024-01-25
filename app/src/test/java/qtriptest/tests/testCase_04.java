package qtriptest.tests;

import qtriptest.DP;
import org.testng.annotations.Test;

public class testCase_04 {
    @Test(dataProvider = "dpM", dataProviderClass = DP.class,groups = {"Reliability Flow"},priority = 4)
    public void TestCase04(String NewUserName,String Password,String dataset1,String dataset2, String dataset3) throws InterruptedException{
        //  TestCases tc=new TestCases();
        TestCases.testcase_04(NewUserName, Password, dataset1, dataset2, dataset3);
    
    }
}
