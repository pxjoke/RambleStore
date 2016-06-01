package com.pxjoke.mappers;


import com.pxjoke.entities.ItemEntity;
import com.pxjoke.tables.ItemsTable;

import java.sql.SQLException;

public class ItemsMapper extends AbstractMapper<ItemEntity> {

    @Override
    public ItemEntity map(Row row) throws SQLException {
        final ItemEntity entity = new ItemEntity();

        entity.id           = row.getLong  (ItemsTable.ITEM_ID);
        entity.company      = row.getString(ItemsTable.COMPANY);
        entity.description  = row.getString(ItemsTable.DESCRIPTION);
        entity.release_date = row.getDate  (ItemsTable.RELEASE_DATE);
        entity.title        = row.getString(ItemsTable.TITLE);
        entity.genre        = row.getString(ItemsTable.GENRE);
        entity.price        = row.getDouble(ItemsTable.PRICE);
        entity.img          = row.getString(ItemsTable.IMG);

        return entity;
    }
}
