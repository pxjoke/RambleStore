package com.pxjoke.dao;

import com.pxjoke.entities.ItemEntity;
import com.pxjoke.entities.UserEntity;
import com.pxjoke.enums.UserRole;
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
    private String createQuery;
    private String deleteQuery;
    private String updateQuery;

    public UsersDAO() {
        super(new UsersMapper());
    }

    public final List<UserEntity> search(){
        return search(searchQuery, null);
    }

    public final UserEntity get(Long id){
        return get(getByIDQuery, new Arguments(UsersTable.USER_ID, id));
    }

    public final Long create(UserEntity user) {
        final Arguments arguments = new Arguments();
//        arguments.add(UsersTable.ROLE,     UserRole.USER);
        arguments.add(UsersTable.EMAIL,    user.eMail);
        arguments.add(UsersTable.PASSWORD, user.password);

        return insert(createQuery, arguments);
    }

    public final Boolean delete(final Long id) {
        return update(deleteQuery, new Arguments(UsersTable.USER_ID, id));
    }

    public final Boolean update(Long id, UserEntity user) {
        final Arguments arguments = new Arguments();

        arguments.add(UsersTable.USER_ID,  id);
        arguments.add(UsersTable.PASSWORD, user.password);
        arguments.add(UsersTable.ROLE,     user.role.toString());

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
