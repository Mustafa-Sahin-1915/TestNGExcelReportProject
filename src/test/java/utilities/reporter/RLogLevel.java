package utilities.reporter;

public enum RLogLevel {
    //ALL<DEBUG<INFO<WARN<ERROR<FATAL<OFF

    ALL(10),
    DEBUG(100),
    INFO(200),
    WARN(300),
    ERROR(400),
    FATAL(500),
    OFF(600);

    private int value;

    RLogLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
