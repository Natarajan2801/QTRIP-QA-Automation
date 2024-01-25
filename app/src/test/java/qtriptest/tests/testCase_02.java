package qtriptest.tests;

import qtriptest.DP;
import org.testng.annotations.Test;


public class testCase_02 {
   
  @Test(dataProvider = "dpM", dataProviderClass = DP.class,priority = 2, groups={"Search and Filter flow"})
    public void TestCase02(String CityName,String Category_Filter,String DurationFilter,String ExpectedFilteredResults, String ExpectedUnFilteredResults) throws InterruptedException{
        //  TestCases tc=new TestCases();
        TestCases.testcase_02(CityName,Category_Filter,DurationFilter, ExpectedFilteredResults,ExpectedUnFilteredResults );

      }
}
