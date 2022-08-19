package utilities.reporter;

import java.util.List;

public interface IReportOutputter {

    public void createReport(List<RTestSuite> suites);

    public void reportTests(List<RTest> tests);
    public void reportTest(RTest test);
    public void reportTestSteps(List<RTestStep> RTestSteps);
    public void reportTestStep(RTestStep RTestStep);
    public void reportPreConditions(List<RPreCondition> RPreConditions);
    public void reportPreCondition(RPreCondition RPreCondition);

}