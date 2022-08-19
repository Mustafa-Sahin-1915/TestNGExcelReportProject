package utilities.reporter.outputters;

import org.openqa.selenium.Keys;
import utilities.reporter.*;

import java.util.List;

public class RXMLReportOutputter implements IReportOutputter{
    private RLogLevel logLevel;

    public RXMLReportOutputter(RLogLevel logLevel) {
        this.logLevel = logLevel;
    }

    private StringBuilder builder;

    public RXMLReportOutputter() {
        initRXMLReportOutputter();
    }

    private void initRXMLReportOutputter() {
        builder = new StringBuilder();
        logLevel = RLogLevel.DEBUG;
    }

    @Override
    public void createReport(List<RTestSuite> suites) {
        if (suites.size()>0){
            builder.append("<suites>");builder.append(Keys.ENTER);

            for(RTestSuite suite:suites){
                builder.append("<suite>");builder.append(Keys.ENTER);
                System.out.println("SUITE DESCRIPTION:"+suite.getDescription());
                reportTests(suite.getTests());
                builder.append("</suite>");builder.append(Keys.ENTER);
            }
            builder.append("</suites>");builder.append(Keys.ENTER);
        }
        writeReportToFile();
    }

    @Override
    public void reportTests(List<RTest> tests) {
        if (tests.size()>0){
            builder.append("<tests>");builder.append(Keys.ENTER);
            System.out.println("TESTS:");
            for(RTest test:tests){

                reportTest(test);
            }
            builder.append("</tests>");builder.append(Keys.ENTER);

        }
    }

    @Override
    public void reportTest(RTest test) {
        if (test!=null){
            builder.append("<test>");builder.append(Keys.ENTER);
            builder.append("<id>");builder.append(Keys.ENTER);
            builder.append(test.getId());builder.append(Keys.ENTER);
            builder.append("</id>");builder.append(Keys.ENTER);
            builder.append("<objective>");builder.append(Keys.ENTER);
            builder.append(test.getObjective());builder.append(Keys.ENTER);
            builder.append("</objective>");builder.append(Keys.ENTER);
            builder.append("<group>");builder.append(Keys.ENTER);
            builder.append(test.getGroup());builder.append(Keys.ENTER);
            builder.append("</group>");builder.append(Keys.ENTER);
            builder.append("<status>");builder.append(Keys.ENTER);
            builder.append(test.getTestStatus().getValue());builder.append(Keys.ENTER);
            builder.append("</status>");builder.append(Keys.ENTER);

            reportPreConditions(test.getPreConditions());
            reportTestSteps(test.getTestSteps());

            builder.append("</test>");builder.append(Keys.ENTER);
        }
    }

    @Override
    public void reportLogs(List<RLog> logs) {
        if (logs.size()>0){
            builder.append("<logs>");builder.append(Keys.ENTER);
            for(RLog log : logs){
                reportLog(log);
            }
            builder.append("</logs>");builder.append(Keys.ENTER);
        }
    }

    @Override
    public void reportLog(RLog log) {
        if (log != null && log.getLevel().getValue()>=logLevel.getValue()) {
            builder.append("<log>");builder.append(Keys.ENTER);
            builder.append("<level>");builder.append(Keys.ENTER);
            builder.append(log.getLevel().getValue());builder.append(Keys.ENTER);
            builder.append("</level>");builder.append(Keys.ENTER);
            builder.append("<description>");builder.append(Keys.ENTER);
            builder.append(log.getDescription());builder.append(Keys.ENTER);
            builder.append("</description>");builder.append(Keys.ENTER);
            builder.append("</log>");builder.append(Keys.ENTER);
        }
    }

    @Override
    public void reportTestSteps(List<RTestStep> RTestSteps) {
        if (RTestSteps.size()>0){
            builder.append("<teststeps>");builder.append(Keys.ENTER);
            for(RTestStep RTestStep : RTestSteps){
                reportTestStep(RTestStep);
            }
            builder.append("</teststeps>");builder.append(Keys.ENTER);
        }
    }

    @Override
    public void reportTestStep(RTestStep RTestStep) {
        if (RTestStep !=null){
            builder.append("<teststep>");builder.append(Keys.ENTER);
            builder.append("<id>");builder.append(Keys.ENTER);
            builder.append(RTestStep.getId());builder.append(Keys.ENTER);
            builder.append("</id>");builder.append(Keys.ENTER);
            builder.append("<description>");builder.append(Keys.ENTER);
            builder.append(RTestStep.getDescription());builder.append(Keys.ENTER);
            builder.append("</description>");builder.append(Keys.ENTER);
            builder.append("<testdata>");builder.append(Keys.ENTER);
            builder.append(RTestStep.getTestData());builder.append(Keys.ENTER);
            builder.append("</testdata>");builder.append(Keys.ENTER);
            builder.append("<expectedvalue>");builder.append(Keys.ENTER);
            builder.append(RTestStep.getExpectedData());builder.append(Keys.ENTER);
            builder.append("</expectedvalue>");builder.append(Keys.ENTER);
            builder.append("<actualvalue>");builder.append(Keys.ENTER);
            builder.append(RTestStep.getActualData());builder.append(Keys.ENTER);
            builder.append("</actualvalue>");builder.append(Keys.ENTER);
            builder.append("<status>");builder.append(Keys.ENTER);
            builder.append(RTestStep.getTestStepStatus().getValue());builder.append(Keys.ENTER);
            builder.append("</status>");builder.append(Keys.ENTER);
            builder.append("</teststep>");builder.append(Keys.ENTER);
        }
    }

    @Override
    public void reportPreConditions(List<RPreCondition> RPreConditions) {

        if (RPreConditions.size()>0){
            builder.append("<preconditions>");builder.append(Keys.ENTER);
            for(RPreCondition RPreCondition : RPreConditions){
                reportPreCondition(RPreCondition);
            }
            builder.append("</preconditions>");builder.append(Keys.ENTER);
        }
    }

    @Override
    public void reportPreCondition(RPreCondition RPreCondition) {
        if (RPreCondition != null) {
            builder.append("<precondition>");builder.append(Keys.ENTER);
            builder.append("<id>");builder.append(Keys.ENTER);
            builder.append(RPreCondition.getId());builder.append(Keys.ENTER);
            builder.append("</id>");builder.append(Keys.ENTER);
            builder.append("<description>");builder.append(Keys.ENTER);
            builder.append(RPreCondition.getDescription());builder.append(Keys.ENTER);
            builder.append("</description>");builder.append(Keys.ENTER);
            builder.append("</precondition>");builder.append(Keys.ENTER);
        }
    }
    private void writeReportToFile(){
        System.out.println(builder.toString());
    }
}
