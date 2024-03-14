package com.goormTable.member.entity;

import java.util.Arrays;
import java.util.List;

public enum Status {
    CONFIRM("confirm"),
    WAIT("wait"),
    CALL("call");

    private String stringValue;

    Status(String stringValue) {
        this.stringValue = stringValue;
    }

    public static List<String> waitAndCall(){
        return Arrays.asList(WAIT.stringValue, CALL.stringValue);
    }
}
