package com.pxjoke.mappers;

import com.pxjoke.entities.OrderPositionEntity;
import com.pxjoke.tables.OrderPositionTable;

import java.sql.SQLException;

public class OrderPositionMapper extends AbstractMapper<OrderPositionEntity> {

    @Override
    public OrderPositionEntity map(Row row) throws SQLException {
        final OrderPositionEntity entity = new OrderPositionEntity();

        entity.id      = row.getLong(OrderPositionTable.ORDER_POSITION_ID);
        entity.amount  = row.getLong(OrderPositionTable.AMOUNT);
        entity.itemID  = row.getLong(OrderPositionTable.ITEM_ID);
        entity.orderID = row.getLong(OrderPositionTable.ORDER_ID);
        entity.price   = row.getDouble(OrderPositionTable.PRICE);

        return entity;
    }
}
