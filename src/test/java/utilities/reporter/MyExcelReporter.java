package utilities.reporter;

import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;

public class MyExcelReporter implements IReporter {

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites,
                               String outputDirectory) {

        //Iterating over each suite included in the test
        for (ISuite suite : suites) {

            //Following code gets the suite name
            String suiteName = suite.getName();
            //Getting the results for the said suite
            Map<String, ISuiteResult> suiteResults = suite.getResults();

            for (ISuiteResult sr : suiteResults.values()) {

                ITestContext tc = sr.getTestContext();
                System.out.println("Passed tests for suite '" + suiteName +
                        "' is:" + tc.getPassedTests().getAllResults().size());
                System.out.println("Failed tests for suite '" + suiteName +
                        "' is:" + tc.getFailedTests().getAllResults().size());
                System.out.println("Skipped tests for suite '" + suiteName +
                        "' is:" + tc.getSkippedTests().getAllResults().size());

                System.out.println("NAME:"+tc.getName());
                System.out.println(tc.getFailedTests().getAllResults());
                for (ITestResult tr: tc.getFailedTests().getAllResults()){
                    System.out.println("STATUS:"+tr.getStatus());
                    System.out.println("NAME:"+tr.getName());
                    System.out.println("TEST NAME:"+tr.getTestName());
                    System.out.println("TEST TIME:"+(tr.getEndMillis()-tr.getEndMillis()));
                    System.out.println("TEST METHOD NAME:"+tr.getMethod().getMethodName());
                    System.out.println("TEST METHOD DESC:"+tr.getMethod().getDescription());
                    System.out.println("TEST METHOD ID:"+tr.getMethod().getId());
                    System.out.println(tr.getThrowable().getMessage());
                    System.out.println(tr.getThrowable().toString());
                }
            }
        }
    }

}
