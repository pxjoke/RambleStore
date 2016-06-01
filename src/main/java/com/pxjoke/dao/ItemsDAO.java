package com.pxjoke.dao;

import com.pxjoke.entities.ItemEntity;
import com.pxjoke.mappers.ItemsMapper;
import com.pxjoke.special.Arguments;
import com.pxjoke.tables.ItemsTable;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class ItemsDAO extends AbstractDAO<ItemEntity> {
    private String searchQuery;
    private String getByIDQuery;
    private String createQuery;

    public ItemsDAO() {
        super(new ItemsMapper());
    }

    public final List<ItemEntity> search() {
        return search(searchQuery, null);
    }

    public final ItemEntity get(Long id) {
        return get(getByIDQuery, new Arguments(ItemsTable.ITEM_ID, id));
    }

    public final Long create(final ItemEntity item) {
        final Arguments arguments = new Arguments();
        arguments.add(ItemsTable.TITLE,        item.title);
        arguments.add(ItemsTable.COMPANY,      item.company);
        arguments.add(ItemsTable.DESCRIPTION,  item.description);
        arguments.add(ItemsTable.GENRE,        item.genre);
        arguments.add(ItemsTable.IMG,          item.img);
        arguments.add(ItemsTable.RELEASE_DATE, item.release_date);
        arguments.add(ItemsTable.PRICE,        item.price);

        return insert(createQuery, arguments);
    }

    @Required
    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    @Required
    public void setGetByIDQuery(String getByIDQuery) {
        this.getByIDQuery = getByIDQuery;
    }

    @Required
    public void setCreateQuery(String createQuery) {
        this.createQuery = createQuery;
    }
}
