package by.user.domain;

import com.fasterxml.jackson.annotation.JsonValue;

public enum FilterOperator {
    IN("in"),
    LIKE("like"),
    GT("gt"),
    LT("lt"),
    EQ("eq");

    FilterOperator(String value) {
        this.value = value;
    }

    private String value;

    @JsonValue
    public String getValue() {
        return value;
    }
}
