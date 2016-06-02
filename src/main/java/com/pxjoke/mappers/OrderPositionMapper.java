package com.pxjoke.mappers;

import com.pxjoke.entities.ItemEntity;
import com.pxjoke.mappers.ItemsMapper;
import com.pxjoke.entities.OrderPositionEntity;
import com.pxjoke.tables.ItemsTable;
import com.pxjoke.tables.OrderPositionTable;

import java.sql.SQLException;

public class OrderPositionMapper extends AbstractMapper<OrderPositionEntity> {

    @Override
    public OrderPositionEntity map(Row row) throws SQLException {
        final OrderPositionEntity entity = new OrderPositionEntity();
        entity.item = new ItemEntity();

        entity.id      = row.getLong(OrderPositionTable.ORDER_POSITION_ID);
        entity.amount  = row.getLong(OrderPositionTable.AMOUNT);
        entity.itemID  = row.getLong(OrderPositionTable.ITEM_ID);
        entity.orderID = row.getLong(OrderPositionTable.ORDER_ID);
        entity.price   = row.getDouble(OrderPositionTable.PRICE);
        entity.item.id           = row.getLong  (ItemsTable.ITEM_ID);
        entity.item.company      = row.getString(ItemsTable.COMPANY);
        entity.item.description  = row.getString(ItemsTable.DESCRIPTION);
        entity.item.release_date = row.getDate  (ItemsTable.RELEASE_DATE);
        entity.item.title        = row.getString(ItemsTable.TITLE);
        entity.item.genre        = row.getString(ItemsTable.GENRE);
        entity.item.price        = row.getDouble(ItemsTable.PRICE);
        entity.item.img          = row.getString(ItemsTable.IMG);

        return entity;
    }
}
