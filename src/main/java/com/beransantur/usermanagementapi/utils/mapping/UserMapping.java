package com.beransantur.usermanagementapi.utils.mapping;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum UserMapping {
    ID("ID", "id"),
    NAME("NAME", "name"),
    STATUS("STATUS", "status"),
    AGE("AGE", "age"),
    JOB("JOB", "job"),
    GENDER("GENDER", "gender"),
    PLACEOFBIRTH("PLACE_OF_BIRTH", "placeOfBirth"),
    CREATED_USER("CREATED_USER", "createdUser"),
    CREATED_DATE("CREATED_DATE", "createdDate"),
    MODIFIED_USER("MODIFIED_USER", "modifiedUser"),
    MODIFIED_DATE("MODIFIED_DATE", "modifiedDate");

    private final String columnName;
    private final String entityPropertyValue;

    public String getColumnName() {
        return columnName;
    }

    public String getEntityPropertyValue() {
        return entityPropertyValue;
    }

    UserMapping(String columnName, String entityPropertyValue) {
        this.columnName = columnName;
        this.entityPropertyValue = entityPropertyValue;
    }

    public static final Map<String, String> COLUMN_MAPPINGS = Stream.of(values()).collect(Collectors.toMap(UserMapping::getColumnName, UserMapping::getEntityPropertyValue));
}
