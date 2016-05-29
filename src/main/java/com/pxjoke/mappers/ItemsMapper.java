package com.pxjoke.mappers;


import com.pxjoke.entities.ItemEntity;
import com.pxjoke.tables.ItemsTable;

import java.sql.SQLException;

public class ItemsMapper extends AbstractMapper<ItemEntity> {

    @Override
    public ItemEntity map(Row row) throws SQLException {
        final ItemEntity entity = new ItemEntity();

        entity.id           = row.getLong  (ItemsTable.ITEM_ID);
        entity.company      = row.getString(ItemsTable.ITEM_COMPANY);
        entity.description  = row.getString(ItemsTable.ITEM_DESCRIPTION);
        entity.release_date = row.getDate  (ItemsTable.ITEM_RELEASE_DATE);
        entity.title        = row.getString(ItemsTable.ITEM_TITLE);
        entity.price        = row.getDouble(ItemsTable.ITEM_PRICE);
        entity.img          = row.getString(ItemsTable.ITEM_IMG);

        return entity;
    }
}
