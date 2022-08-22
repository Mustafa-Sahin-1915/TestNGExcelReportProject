package utilities.reporter.outputters;

import org.openqa.selenium.Keys;
import utilities.reporter.*;

import java.util.List;

public class RXMLReportOutputter implements IReportOutputter{
    private RLogLevel logLevel;
    private int tablevel=0;


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
    private void addTab(){
        for(int i=0;i<tablevel;i++){
            builder.append("\t");
        }
    }

    @Override
    public void createReport(List<RTestSuite> suites) {
        if (suites.size()>0){
            builder.append("<suites>");builder.append("\n");
            tablevel++;
            for(RTestSuite suite:suites){
                reportSuit(suite);
            }
            builder.append("</suites>");builder.append("\n");
        }
        writeReportToFile();
    }
    @Override
    public void reportSuit(RTestSuite suite) {
        if (suite!=null) {
            addTab();
            builder.append("<suite>");builder.append("\n");
            tablevel++;
            reportTests(suite.getTests());
            builder.append("</suite>");builder.append("\n");
            tablevel--;
        }
    }
    @Override
    public void reportTests(List<RTest> tests) {
        if (tests.size()>0){
            addTab();
            builder.append("<tests>");builder.append("\n");
            tablevel++;
            for(RTest test:tests){
                reportTest(test);
            }
            builder.append("</tests>");builder.append("\n");
            tablevel--;
        }
    }

    @Override
    public void reportTest(RTest test) {
        if (test!=null){
            addTab();
            builder.append("<test>");builder.append("\n");
            tablevel++;
            addTab();builder.append("<id>");builder.append("\n");
            addTab();builder.append(test.getId());builder.append("\n");
            addTab();builder.append("</id>");builder.append("\n");
            addTab();builder.append("<objective>");builder.append("\n");
            addTab();builder.append(test.getObjective());builder.append("\n");
            addTab();builder.append("</objective>");builder.append("\n");
            addTab();builder.append("<group>");builder.append("\n");
            addTab();builder.append(test.getGroup());builder.append("\n");
            addTab();builder.append("</group>");builder.append("\n");
            addTab();builder.append("<status>");builder.append("\n");
            addTab();builder.append(test.getTestStatus().getValue());builder.append("\n");
            addTab();builder.append("</status>");builder.append("\n");
            reportPreConditions(test.getPreConditions());
            reportTestSteps(test.getTestSteps());
            addTab();builder.append("</test>");builder.append("\n");
            tablevel--;
        }
    }

    @Override
    public void reportLogs(List<RLog> logs) {
        if (logs.size()>0){
            addTab();
            builder.append("<logs>");builder.append("\n");
            tablevel++;
            for(RLog log : logs){
                reportLog(log);
            }
            addTab();builder.append("</logs>");builder.append("\n");
            tablevel--;
        }
    }

    @Override
    public void reportLog(RLog log) {
        if (log != null && log.getLevel().getValue()>=logLevel.getValue()) {
            addTab();
            builder.append("<log>");builder.append("\n");
            tablevel++;
            addTab();builder.append("<level>");builder.append("\n");
            addTab();builder.append(log.getLevel().getValue());builder.append("\n");
            addTab();builder.append("</level>");builder.append("\n");
            addTab();builder.append("<description>");builder.append("\n");
            addTab();builder.append(log.getDescription());builder.append("\n");
            addTab();builder.append("</description>");builder.append("\n");
            tablevel--;
            addTab();builder.append("</log>");builder.append("\n");
            tablevel--;
        }
    }

    @Override
    public void reportTestSteps(List<RTestStep> RTestSteps) {
        if (RTestSteps.size()>0){
            addTab();builder.append("<teststeps>");builder.append("\n");
            tablevel++;
            for(RTestStep teststep : RTestSteps){
                reportTestStep(teststep);
                reportLogs(teststep.getLogs());
            }
            addTab();builder.append("</teststeps>");builder.append("\n");
            tablevel--;
        }
    }

    @Override
    public void reportTestStep(RTestStep RTestStep) {
        if (RTestStep !=null){

            addTab(); builder.append("<teststep>");builder.append("\n");
            tablevel++;
            addTab();builder.append("<id>");builder.append("\n");
            addTab();builder.append(RTestStep.getId());builder.append("\n");
            addTab();builder.append("</id>");builder.append("\n");
            addTab();builder.append("<description>");builder.append("\n");
            addTab();builder.append(RTestStep.getDescription());builder.append("\n");
            addTab();builder.append("</description>");builder.append("\n");
            addTab();builder.append("<testdata>");builder.append("\n");
            addTab();builder.append(RTestStep.getTestData());builder.append("\n");
            addTab();builder.append("</testdata>");builder.append("\n");
            addTab();builder.append("<expectedvalue>");builder.append("\n");
            addTab();builder.append(RTestStep.getExpectedData());builder.append("\n");
            addTab();builder.append("</expectedvalue>");builder.append("\n");
            addTab();builder.append("<actualvalue>");builder.append("\n");
            addTab();builder.append(RTestStep.getActualData());builder.append("\n");
            addTab();builder.append("</actualvalue>");builder.append("\n");
            addTab();builder.append("<status>");builder.append("\n");
            addTab();builder.append(RTestStep.getTestStepStatus().getValue());builder.append("\n");
            addTab();builder.append("</status>");builder.append("\n");
            tablevel--;
            addTab();builder.append("</teststep>");builder.append("\n");
            tablevel--;
        }
    }

    @Override
    public void reportPreConditions(List<RPreCondition> RPreConditions) {

        if (RPreConditions.size()>0){
            addTab();
            builder.append("<preconditions>");builder.append("\n");
            tablevel++;
            for(RPreCondition RPreCondition : RPreConditions){
                reportPreCondition(RPreCondition);
            }
            addTab();builder.append("</preconditions>");builder.append("\n");
            tablevel--;
        }
    }

    @Override
    public void reportPreCondition(RPreCondition RPreCondition) {
        if (RPreCondition != null) {
            addTab();
            builder.append("<precondition>");builder.append("\n");
            tablevel++;
            addTab();builder.append("<id>");builder.append("\n");
            addTab();builder.append(RPreCondition.getId());builder.append("\n");
            addTab();builder.append("</id>");builder.append("\n");
            addTab();builder.append("<description>");builder.append("\n");
            addTab();builder.append(RPreCondition.getDescription());builder.append("\n");
            addTab();builder.append("</description>");builder.append("\n");
            tablevel--;
            addTab();builder.append("</precondition>");builder.append("\n");
            tablevel--;
        }
    }
    private void writeReportToFile(){
        System.out.println(builder.toString());
    }
}
