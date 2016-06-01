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
    private String deleteQuery;
    private String updateQuery;

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

    public final Boolean delete(final Long id) {
        return update(deleteQuery, new Arguments(ItemsTable.ITEM_ID, id));
    }

    public final Boolean update(Long id, ItemEntity item) {
        final Arguments arguments = new Arguments();

        arguments.add(ItemsTable.ITEM_ID,      id);
        arguments.add(ItemsTable.TITLE,        item.title);
        arguments.add(ItemsTable.COMPANY,      item.company);
        arguments.add(ItemsTable.DESCRIPTION,  item.description);
        arguments.add(ItemsTable.GENRE,        item.genre);
        arguments.add(ItemsTable.IMG,          item.img);
        arguments.add(ItemsTable.RELEASE_DATE, item.release_date);
        arguments.add(ItemsTable.PRICE,        item.price);

        return update(updateQuery, arguments);
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

    @Required
    public void setDeleteQuery(String deleteQuery) {
        this.deleteQuery = deleteQuery;
    }

    @Required
    public void setUpdateQuery(String updateQuery) {
        this.updateQuery = updateQuery;
    }
}
