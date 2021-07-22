package com.beransantur.usermanagementapi.utils.enums;

public enum HttpStatusEnum {
    USER_NOT_FOUND("404-USER NOT FOUND"),
    INTERNAL_SERVER_ERROR("500-DATABASE ERROR");
    private final String name;

    HttpStatusEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
