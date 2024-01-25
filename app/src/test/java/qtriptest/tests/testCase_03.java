package qtriptest.tests;

import qtriptest.DP;
import org.testng.annotations.Test;

public class testCase_03 {

   @Test(dataProvider = "dpM", dataProviderClass = DP.class,groups = {"Booking and Cancellation Flow"},priority = 3)
    public void TestCase03(String NewUserName,String Password,String SearchCity,String AdventureName, String GuestName, String Date,String count) throws InterruptedException{
        //  TestCases tc=new TestCases();
        TestCases.testcase_03(NewUserName, Password, SearchCity, AdventureName, GuestName, Date, count);
      }
}
