package com.portfolio.elearning.entity.enums;

public enum RoleType {
    ADMIN("ROLE_ADMIN"),
    INSTRUCTOR("ROLE_INSTRUCTOR"),
    STUDENT("ROLE_STUDENT");

    private final String authority;

    RoleType(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
