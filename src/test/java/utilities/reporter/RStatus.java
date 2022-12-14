package utilities.reporter;

public enum RStatus {
    PASS("PASS"),
    FAIL("FAIL"),

    SKIP("SKIP"),
    TODO("TODO");

    private String value;

    public String getValue() {
        return value;
    }

    RStatus(String value) {
        this.value = value;
    }
}
