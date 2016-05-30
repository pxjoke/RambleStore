package com.pxjoke.dao;

import com.pxjoke.entities.ItemEntity;
import com.pxjoke.entities.UserEntity;
import com.pxjoke.mappers.ItemsMapper;
import com.pxjoke.mappers.UsersMapper;
import com.pxjoke.special.Arguments;
import com.pxjoke.tables.ItemsTable;
import com.pxjoke.tables.UsersTable;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class UsersDAO extends AbstractDAO<UserEntity> {
    private String searchQuery;
    private String getByIDQuery;

    public UsersDAO() {
        super(new UsersMapper());
    }

    public final List<UserEntity> search(){
        return search(searchQuery, null);
    }

    public final UserEntity get(Long id){
        return get(getByIDQuery, new Arguments(UsersTable.USER_ID, id));
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
