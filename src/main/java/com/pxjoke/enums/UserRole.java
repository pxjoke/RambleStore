package com.pxjoke.enums;

public enum UserRole {
    user("user"),
    admin("admin");

    private final String role;

    UserRole(String role) {
        this.role = role;
    }

    public final String getRole() {
        return role;
    }
}
