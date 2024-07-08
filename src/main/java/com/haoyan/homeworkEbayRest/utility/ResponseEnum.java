package com.haoyan.homeworkEbayRest.utility;

public enum ResponseEnum {
    SUCCESS("success"),
    INVALID("invalid user to do this job"),
    FAILURE("failure");

    private final String message;
    ResponseEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
