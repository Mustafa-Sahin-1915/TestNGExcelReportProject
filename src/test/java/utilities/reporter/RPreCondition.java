package utilities.reporter;

import java.sql.Timestamp;

public class RPreCondition {
    private static int nextPreConditionId=0;
    private int id;
    private String description;
    private String timeStamp;
    public RPreCondition() {
        initPreCondition();
    }

    public RPreCondition(String description) {
        this();
        this.description = description;
    }

    private void initPreCondition() {
        nextPreConditionId++;
        this.id =nextPreConditionId;
        setTimeStamp();
    }
    public String getTimeStamp() {
        return timeStamp;
    }

    private void setTimeStamp() {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        this.timeStamp = timeStamp.toString();
    }
    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
