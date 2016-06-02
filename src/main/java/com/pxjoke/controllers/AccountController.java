package com.pxjoke.controllers;

import com.pxjoke.entities.OrderEntity;
import com.pxjoke.entities.UserEntity;
import com.pxjoke.services.OrdersService;
import com.pxjoke.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController extends AbstractController<UserEntity>{

    @Autowired
    UsersService usersService;

    @Autowired
    OrdersService ordersService;

    @RequestMapping()
    public Result<UserEntity> getUser(){
        return run(() -> usersService.getForAccount());
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Result<Boolean> update(@RequestBody UserEntity user){
        return run(() -> usersService.updateForAccount(user));
    }

    @RequestMapping(value = "/orders")
    public Result<List<OrderEntity>> searchOrders(){
        return run(() -> ordersService.searchForAccount());
    }
}
