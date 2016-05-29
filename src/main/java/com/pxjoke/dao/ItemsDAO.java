package com.pxjoke.dao;

import com.pxjoke.entities.ItemEntity;
import com.pxjoke.mappers.ItemsMapper;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class ItemsDAO extends AbstractDAO<ItemEntity> {
    private String searchQuery;

    public ItemsDAO() {
        super(new ItemsMapper());
    }

    public final List<ItemEntity> search(){
        return search(searchQuery, null);
    }

    @Required
    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }


}
