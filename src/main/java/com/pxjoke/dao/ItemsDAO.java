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

    public ItemsDAO() {
        super(new ItemsMapper());
    }

    public final List<ItemEntity> search(){
        return search(searchQuery, null);
    }

    public final ItemEntity get(Long id){
        return get(getByIDQuery, new Arguments(ItemsTable.ITEM_ID, id));
    }

    @Required
    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    @Required
    public void setGetByIDQuery(String getByIDQuery) {
        this.getByIDQuery = getByIDQuery;
    }


}
