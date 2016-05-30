package com.pxjoke.mappers;

import com.pxjoke.entities.OrderEntity;
import com.pxjoke.tables.OrdersTable;

import java.sql.SQLException;

public class OrdersMapper extends AbstractMapper<OrderEntity> {

    @Override
    public OrderEntity map(Row row) throws SQLException {
        final OrderEntity entity = new OrderEntity();

        entity.id       = row.getLong(OrdersTable.ORDER_ID);
        entity.saleDate = row.getDate(OrdersTable.SALE_DATE);
        entity.userID   = row.getLong(OrdersTable.USER_ID);

        return entity;
    }
}
