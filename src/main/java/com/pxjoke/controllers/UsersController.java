package com.pxjoke.controllers;

import com.pxjoke.entities.ItemEntity;
import com.pxjoke.entities.UserEntity;
import com.pxjoke.services.ItemsService;
import com.pxjoke.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
