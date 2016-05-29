package com.pxjoke.tables;

public enum OrderPositionTable implements AbstractTable {
    ORDER_POSITION_ID("id"),
    ITEM_ID("item_id"),
    ORDER_ID("order_id"),
    AMOUNT("amount"),
    PRICE("price");

    private final String columnName;

    OrderPositionTable(final String columnName) {
        this.columnName = columnName;
    }

    @Override
    public final String getColumnName() {
        return columnName;
    }
}
