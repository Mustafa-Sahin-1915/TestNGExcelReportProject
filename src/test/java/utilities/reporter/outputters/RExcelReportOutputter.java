package utilities.reporter.outputters;

import utilities.reporter.*;

import java.util.List;

public class RExcelReportOutputter implements IReportOutputter{
    @Override
    public void createReport(List<RTestSuite> suites) {
        if (suites.size()>0){
            for(RTestSuite suite:suites){
                System.out.println("SUITE DESCRIPTION:"+suite.getDescription());
                reportTests(suite.getTests());
            }
        }
    }

    @Override
    public void reportSuit(RTestSuite suite) {
        if (suite!=null) {
            System.out.println("SUITE DESCRIPTION:" + suite.getDescription());
            reportTests(suite.getTests());
        }
    }

    @Override
    public void reportTests(List<RTest> tests) {
        if (tests.size()>0){
            System.out.println("TESTS:");
            System.out.println("-------------------------------------");
            for(RTest test:tests){
                reportTest(test);
            }
            System.out.println("-------------------------------------");
        }
    }

    @Override
    public void reportTest(RTest test) {
        if (test!=null){
            System.out.println("TEST ID:"+test.getId());
            System.out.println("TEST OBJECTIVE:"+test.getObjective());
            System.out.println("TEST GROUP:"+test.getGroup());
            System.out.println("TEST STATUS:"+test.getTestStatus());
            reportPreConditions(test.getPreConditions());
            reportTestSteps(test.getTestSteps());
        }
    }

    @Override
    public void reportLogs(List<RLog> logs) {

    }

    @Override
    public void reportLog(RLog log) {

    }

    @Override
    public void reportTestSteps(List<RTestStep> RTestSteps) {
        if (RTestSteps.size()>0){
            System.out.println("TEST STEPS:");
            System.out.println("-------------------------------------");
            for(RTestStep RTestStep : RTestSteps){
                reportTestStep(RTestStep);
            }
            System.out.println("-------------------------------------");
        }
    }

    @Override
    public void reportTestStep(RTestStep RTestStep) {
        if (RTestStep !=null){
            System.out.println("TEST STEP-"+ RTestStep.getId());
            System.out.println("TEST STEP DESC:"+ RTestStep.getDescription());
            System.out.println("TEST STEP TEST DATA:"+ RTestStep.getTestData());
            System.out.println("TEST STEP EXPECTED:"+ RTestStep.getExpectedData());
            System.out.println("TEST STEP ACTUAL:"+ RTestStep.getActualData());
            System.out.println("TEST STEP STATUS:"+ RTestStep.getTestStepStatus());
        }
    }

    @Override
    public void reportPreConditions(List<RPreCondition> RPreConditions) {

        if (RPreConditions.size()>0){
            System.out.println("PRE CONDITIONS:");
            System.out.println("-------------------------------------");
            for(RPreCondition RPreCondition : RPreConditions){
                reportPreCondition(RPreCondition);
            }
            System.out.println("-------------------------------------");
        }
    }

    @Override
    public void reportPreCondition(RPreCondition RPreCondition) {
        if (RPreCondition != null) {
            System.out.println("PRECONDITION-" + RPreCondition.getId() + ":" + RPreCondition.getDescription());
        }
    }
}
