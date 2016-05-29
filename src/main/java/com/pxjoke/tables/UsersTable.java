package com.pxjoke.tables;

public enum UsersTable implements AbstractTable {
    USER_ID("id"),
    EMAIL("email"),
    PASSWORD("password"),
    ROLE("role");

    private final String columnName;

    UsersTable(final String columnName) {
        this.columnName = columnName;
    }

    @Override
    public final String getColumnName() {
        return columnName;
    }
}
