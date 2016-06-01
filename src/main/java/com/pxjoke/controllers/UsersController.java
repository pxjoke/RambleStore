package com.pxjoke.controllers;

import com.pxjoke.entities.ItemEntity;
import com.pxjoke.entities.UserEntity;
import com.pxjoke.services.ItemsService;
import com.pxjoke.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersController extends AbstractController<UserEntity>{

    @Autowired
    UsersService usersService;

    @RequestMapping
    public Result<List<UserEntity>> search(){
        return run(() -> usersService.search());
    }

    @RequestMapping(value = "/{id}")
    public Result<UserEntity> get(@PathVariable Long id){
        return run(() -> usersService.get(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result<Long> create(@RequestBody UserEntity user) {
        return run(()->usersService.create(user));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result<Boolean> delete(@PathVariable Long id){
        return run(() -> usersService.delete(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result<Boolean> update(@PathVariable Long id, @RequestBody UserEntity user){
        return run(() -> usersService.update(id, user));
    }

}
