package com.pxjoke.tables;

public enum ItemsTable implements AbstractTable {
    ITEM_ID("id"),
    RELEASE_DATE("release_date"),
    GENRE("genre"),
    DESCRIPTION("description"),
    IMG("img"),
    COMPANY("company"),
    PRICE("price"),
    TITLE("title");

    private final String columnName;

    ItemsTable(final String columnName) {
        this.columnName = columnName;
    }

    @Override
    public final String getColumnName() {
        return columnName;
    }
}
