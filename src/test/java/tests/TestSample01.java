package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.reporter.*;
import utilities.reporter.outputters.RXMLReportOutputter;

//@Listeners({MyExcelReporter.class})
public class TestSample01 {
    private static RTestReporter reporter;
    private static RTestSuite suite;
    @BeforeClass(alwaysRun = true)
    public void suiteSetUp() {

        reporter = new RTestReporter();
        reporter.addReportOutputter(new RXMLReportOutputter());
        suite = reporter.addTestSuite("This is first test suite");

    }
    @Test(description = "This is sample test1")
    public void testMethod1(){

        RTest test1=suite.addTest("This is sample test1");
        RTestStep step1 = test1.addTestStep("assertion test1","", "true", "true", RStatus.PASS);
        step1.info("info description");
        step1.warn("warn message");
        test1.addTestStep("assertion test2","", "true", "false", RStatus.FAIL);
    }
    @Test(description = "This is sample test2")
    public void testMethod2(){

        RTest test2=suite.addTest("This is sample test2");
        test2.addTestStep("assertion method2 step 1","", "true", "true", RStatus.PASS);
        test2.addTestStep("assertion method2 step 2","", "true", "false", RStatus.FAIL);
        test2.addTestStep("assertion method2 step 3","", "true", "true", RStatus.PASS);

    }
    @Test(description = "This is sample test3")
    public void testMethod3(){

        RTest test3=suite.addTest("This is sample test3");
        test3.addTestStep("assertion method2 step 1","", "true", "true", RStatus.PASS);
    }
    @AfterClass
    public void tearDownAfterClass(){

        reporter.reportAll();
    }

}
