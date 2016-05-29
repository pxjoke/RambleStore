package com.pxjoke.tables;

public enum OrdersTable implements AbstractTable {
    ORDER_ID("id"),
    USER_ID("user_id"),
    SALE_DATE("sale_date");


    private final String columnName;

    OrdersTable(final String columnName) {
        this.columnName = columnName;
    }

    @Override
    public final String getColumnName() {
        return columnName;
    }
}
