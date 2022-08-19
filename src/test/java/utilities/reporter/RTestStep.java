package utilities.reporter;

import java.sql.Timestamp;

public class RTestStep {
    private static int nextStepId=0;
    private int id;
    private String description;
    private String testData;
    private String expectedData;
    private String actualData;
    private RStatus testStepRStatus = RStatus.TODO;

    private String timeStamp;

    public RTestStep() {
        initTestStep();
    }

    public RTestStep(String description, String testData, String expectedData, String actualData, RStatus testStepRStatus) {
        this();
        this.description = description;
        this.testData = testData;
        this.expectedData = expectedData;
        this.actualData = actualData;
        this.testStepRStatus = testStepRStatus;
    }
    public RTestStep(String description, String testData, String expectedData, String actualData) {
        this();
        this.description = description;
        this.testData = testData;
        this.expectedData = expectedData;
        this.actualData = actualData;
    }



    private void initTestStep() {
        nextStepId++;
        setId();
        setTimeStamp();
    }
    public String getTimeStamp() {
        return timeStamp;
    }

    private void setTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.timeStamp = timeStamp.toString();
    }
    private void setId() {
        this.id = nextStepId;
    }
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTestData() {
        return testData;
    }

    public void setTestData(String testData) {
        this.testData = testData;
    }

    public String getExpectedData() {
        return expectedData;
    }

    public void setExpectedData(String expectedData) {
        this.expectedData = expectedData;
    }

    public String getActualData() {
        return actualData;
    }

    public void setActualData(String actualData) {
        this.actualData = actualData;
    }

    public RStatus getTestStepStatus() {
        return testStepRStatus;
    }

    public void setTestStepStatus(RStatus testStepRStatus) {
        this.testStepRStatus = testStepRStatus;
    }
}
