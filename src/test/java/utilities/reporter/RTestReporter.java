package utilities.reporter;

import java.util.ArrayList;
import java.util.List;

public class RTestReporter {
    private List<IReportOutputter> outputters;
    private List<RTestSuite> suites;

    public RTestReporter() {
        initTestReporter();
    }

    private void initTestReporter() {
        suites = new ArrayList<>();
        outputters = new ArrayList<>();
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

    public void reportAll(){
        if (outputters.size()>0){
            for (IReportOutputter outputter: outputters) {
                outputter.createReport(suites);
            }
        }
    }
}
