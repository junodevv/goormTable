package com.goormTable.member.entity;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;

@Getter
public enum Status {
    CONFIRM("confirm"),
    WAIT("wait"),
    CALL("call");

    private String smallValue;

    Status(String smallValue) {
        this.smallValue = smallValue;
    }

    public static List<String> waitAndCall(){
        return Arrays.asList(WAIT.smallValue, CALL.smallValue);
    }

}
