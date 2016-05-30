package com.pxjoke.enums;

public enum UserRole {
    ROLE_USER("ROLE_USER"),
    ROLE_OPERATOR("ROLE_OPERATOR"),
    ROLE_ADMINISTRATOR("ROLE_ADMINISTRATOR");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public final String getRole() {
        return role;
    }
}
