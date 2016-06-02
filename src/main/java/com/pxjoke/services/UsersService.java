package com.pxjoke.services;

import com.pxjoke.dao.ItemsDAO;
import com.pxjoke.dao.UsersDAO;
import com.pxjoke.entities.ItemEntity;
import com.pxjoke.entities.UserEntity;
import com.pxjoke.utilities.Session;
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

    public final UserEntity getForAccount(){
        final Long id = Session.userID;

        return usersDAO.get(id);
    }

    public final Boolean delete(Long id) {
        return usersDAO.delete(id);
    }

    public final Boolean update(Long id, UserEntity user) {
        return usersDAO.update(id, user);
    }

    public final UserEntity login(String eMail, String password) {
        UserEntity user = usersDAO.login(eMail, password);
        if (user != null)
            Session.userID = user.id;
        return user;
    }

    public final Boolean updateForAccount(UserEntity user) {
        Long id = new Long(1);

        return usersDAO.update(id, user);
    }

    public final Long create(UserEntity user) {
        return usersDAO.create(user);
    }


}
