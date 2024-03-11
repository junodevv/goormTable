package com.goormTable.common.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
    USER("ROLE_USER","일반사용자"),
    ADMIN("ROLE_ADMIN","일반관리자"),
    MASTER("ROLE_MASTER","마스터관리자");
    private final String key;
    private final String title;
}
