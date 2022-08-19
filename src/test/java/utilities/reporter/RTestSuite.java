package utilities.reporter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RTestSuite {
    private String description;
    private List<RTest> tests;
    private String timeStamp;
    public RTestSuite() {
        initTestSuite();
    }
    private void initTestSuite() {
        tests = new ArrayList<>();
        setTimeStamp();
    }

    public RTestSuite(String description) {
        this();
        this.description = description;
    }
    public String getTimeStamp() {
        return timeStamp;
    }

    private void setTimeStamp() {
        Timestamp ts = new Timestamp(System.currentTimeMillis());
        this.timeStamp = ts.toString();
    }

    public RTest addTest(RTest test){
        tests.add(test);
        return test;
    }
    public RTest addTest(String testObjective, String testGroup){
        RTest test  = new RTest(testObjective, testGroup);
        tests.add(test);
        return test;
    }
    public RTest addTest(String testObjective){
        RTest test = new RTest(testObjective);
        tests.add(test);
        return test;
    }
    public void removeTest(RTest test){
        tests.remove(test);
    }
    public void removeAllTests(){
        tests.clear();
    }

    public List<RTest> getTests() {
        return tests;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
