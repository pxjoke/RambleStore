package com.pxjoke.services;

import com.pxjoke.dao.ItemsDAO;
import com.pxjoke.dao.UsersDAO;
import com.pxjoke.entities.ItemEntity;
import com.pxjoke.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService extends AbstractService<UserEntity> {

    @Autowired
    private UsersDAO usersDAO;

    public final List<UserEntity> search(){
        return usersDAO.search();
    }

    public final UserEntity get(Long id){
        return usersDAO.get(id);
    }

    public final Long create(UserEntity user) {
        return usersDAO.create(user);
    }


}
