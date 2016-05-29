package com.pxjoke.tables;

public enum ItemsTable implements AbstractTable {
    ITEM_ID("id"),
    ITEM_RELEASE_DATE("release_date"),
    ITEM_GENRE("genre"),
    ITEM_DESCRIPTION("description"),
    ITEM_IMG("img"),
    ITEM_COMPANY("company"),
    ITEM_PRICE("price"),
    ITEM_TITLE("title");

    private final String columnName;

    ItemsTable(final String columnName) {
        this.columnName = columnName;
    }

    @Override
    public final String getColumnName() {
        return columnName;
    }
}
