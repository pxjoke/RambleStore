package com.pxjoke.mappers;

import com.pxjoke.entities.UserEntity;
import com.pxjoke.enums.UserRole;
import com.pxjoke.tables.UsersTable;

import java.sql.SQLException;

public class UsersMapper extends AbstractMapper<UserEntity> {

    @Override
    public UserEntity map(Row row) throws SQLException {
        final UserEntity entity = new UserEntity();

        entity.id       = row.getLong(UsersTable.USER_ID);
        entity.eMail    = row.getString(UsersTable.EMAIL);
        entity.password = row.getString(UsersTable.PASSWORD);
        entity.role     = row.getEnum(UsersTable.ROLE, UserRole.class);
//        entity.role     = row.getString(UsersTable.ROLE);

        return entity;
    }
}
