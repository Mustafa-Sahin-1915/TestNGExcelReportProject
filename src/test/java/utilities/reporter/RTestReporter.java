package utilities.reporter;

import utilities.reporter.outputters.IReportOutputter;
import utilities.reporter.outputters.RConsoleReportOutputter;

import java.util.ArrayList;
import java.util.List;

public class RTestReporter {
    private List<IReportOutputter> outputters;
    private List<RTestSuite> suites;
    private RLogLevel logLevel;

    public RTestReporter() {
        initTestReporter();
    }

    private void initTestReporter() {
        suites = new ArrayList<>();
        outputters = new ArrayList<>();
        logLevel=RLogLevel.DEBUG;
        addReportOutputter(new RConsoleReportOutputter());
    }
    public RTestSuite addTestSuite(String description){
        RTestSuite suite = new RTestSuite(description);
        suites.add(suite);
        return suite;
    }
    public void addReportOutputter(IReportOutputter reportOutputter){
        outputters.add(reportOutputter);
    }

    public RLogLevel getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(RLogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public void reportAll(){
        if (outputters.size()>0){
            for (IReportOutputter outputter: outputters) {
                outputter.createReport(suites);
            }
        }
    }

}
