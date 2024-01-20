package qtriptest.tests;

import qtriptest.DP;
import org.testng.annotations.Test;

public class testCase_01 {
    @Test(dataProvider = "dpM", dataProviderClass = DP.class)
    public void TestCase01(String username,String password) throws InterruptedException{
      //  TestCases tc=new TestCases();
        TestCases.testcase_01(username,password);
    }
    
}
