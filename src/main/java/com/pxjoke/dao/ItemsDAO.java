package com.pxjoke.dao;

import com.pxjoke.entities.ItemEntity;
import com.pxjoke.mappers.ItemsMapper;
import com.pxjoke.requests.items.CreateItemRequestArguments;
import com.pxjoke.special.Arguments;
import com.pxjoke.tables.ItemsTable;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class ItemsDAO extends AbstractDAO<ItemEntity> {
    private String searchQuery;
    private String getByIDQuery;
    private String createItemQuery;

    public ItemsDAO() {
        super(new ItemsMapper());
    }

    public final List<ItemEntity> search() {
        return search(searchQuery, null);
    }

    public final ItemEntity get(Long id) {
        return get(getByIDQuery, new Arguments(ItemsTable.ITEM_ID, id));
    }

    public final Long create(final CreateItemRequestArguments itemRequestArguments) {
        final Arguments arguments = new Arguments();
        arguments.add(ItemsTable.TITLE,        itemRequestArguments.title);
        arguments.add(ItemsTable.COMPANY,      itemRequestArguments.company);
        arguments.add(ItemsTable.DESCRIPTION,  itemRequestArguments.description);
        arguments.add(ItemsTable.GENRE,        itemRequestArguments.genre);
        arguments.add(ItemsTable.IMG,          itemRequestArguments.img);
        arguments.add(ItemsTable.RELEASE_DATE, itemRequestArguments.releaseDate);
        arguments.add(ItemsTable.PRICE,        itemRequestArguments.price);

        return insert(createItemQuery, arguments);
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
    public void setCreateItemQuery(String createItemQuery) {
        this.createItemQuery = createItemQuery;
    }
}
