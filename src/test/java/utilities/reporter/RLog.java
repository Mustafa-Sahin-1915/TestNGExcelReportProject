package utilities.reporter;

public class RLog {

    private String description;
    private RLogLevel level;

    public RLog() {
        initRLog();
    }

    private void initRLog() {
        this.level = RLogLevel.DEBUG;
    }

    public RLog(String description) {
        this.description = description;
    }

    public RLog(String description, RLogLevel level) {
        this.description = description;
        this.level = level;
    }

    public String getDescription() {
        return description;
    }

    public RLogLevel getLevel() {
        return level;
    }
}
