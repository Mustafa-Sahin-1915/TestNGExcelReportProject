package utilities.reporter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class RTest {
    private static int nextTestId=0;
    private int id;
    private String objective;

    private String group;

    private List<RPreCondition> RPreConditions;
    private List<RTestStep> RTestSteps;
    private RStatus testRStatus = RStatus.TODO;
    private String timeStamp;
    public RTest() {
        initTest();
    }

    private void initTest() {
        nextTestId++;
        this.id = nextTestId;
        RPreConditions = new ArrayList<>();
        RTestSteps = new ArrayList<>();
        setTimeStamp();
    }

    public RTest(String objective) {
        this();
        this.objective = objective;
    }
    public RTest(String objective, String group) {
        this();
        this.objective = objective;
        this.group = group;
    }
    public RTestStep addTestStep(RTestStep RTestStep){
        RTestSteps.add(RTestStep);
        return RTestStep;
    }
    public RTestStep addTestStep(String description, String testData, String expectedData, String actualData){
        RTestStep RTestStep = new RTestStep(description, testData, expectedData, actualData);
        RTestSteps.add(RTestStep);
        return RTestStep;
    }
    public RTestStep addTestStep(String description, String testData, String expectedData, String actualData, RStatus status){
        RTestStep RTestStep = new RTestStep(description, testData, expectedData, actualData,status);
        RTestSteps.add(RTestStep);
        return RTestStep;
    }
    public RTestStep addPassTestStep(String description, String testData, String expectedData, String actualData){
        return addTestStep(description, testData, expectedData, actualData, RStatus.PASS);
    }
    public RTestStep addFailTestStep(String description, String testData, String expectedData, String actualData){
        return addTestStep(description, testData, expectedData, actualData, RStatus.FAIL);
  }
    public RTestStep addSkipTestStep(String description, String testData, String expectedData, String actualData){
        return addTestStep(description, testData, expectedData, actualData, RStatus.SKIP);
    }
    public RTestStep removeTestStep(RTestStep RTestStep){
        RTestSteps.remove(RTestStep);
        return RTestStep;
    }
    public void removeAllTestSteps(){
        RTestSteps.clear();
    }
    public RPreCondition addPreCondition(RPreCondition RPreCondition){
        RPreConditions.add(RPreCondition);
        return RPreCondition;
    }
    public RPreCondition addPreCondition(String description){
        RPreCondition RPreCondition = new RPreCondition(description);
        RPreConditions.add(RPreCondition);
        return RPreCondition;
    }
    public RPreCondition removePreCondition(RPreCondition RPreCondition){
        RPreConditions.remove(RPreCondition);
        return RPreCondition;
    }
    public void removeAllPreconditions(){
        RPreConditions.clear();
    }

    public RStatus getTestStatus() {
        calculateTestRStatus();
        return testRStatus;
    }

    public void setTestStatus(RStatus testRStatus) {
        this.testRStatus = testRStatus;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public List<RPreCondition> getPreConditions() {
        return RPreConditions;
    }

    public List<RTestStep> getTestSteps() {
        return RTestSteps;
    }

    private void setTestRStatus(RStatus testRStatus) {
        this.testRStatus = testRStatus;
    }
    private void calculateTestRStatus() {
        boolean statusPass = true;
        if (RTestSteps.size()>0) {
            for (RTestStep testStep : RTestSteps) {
                if (testStep.getTestStepStatus() != RStatus.PASS) {
                    statusPass = false;
                }
            }
        }
        if (statusPass){
            this.testRStatus = RStatus.PASS;
        }else{
            this.testRStatus = RStatus.FAIL;
        }
    }
    public String getTimeStamp() {
        return timeStamp;
    }

    private void setTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.timeStamp = timeStamp.toString();
    }
}
