package com.pxjoke.controllers;

import com.pxjoke.entities.OrderEntity;
import com.pxjoke.entities.OrderPositionEntity;
import com.pxjoke.entities.UserEntity;
import com.pxjoke.services.OrderPositionsService;
import com.pxjoke.services.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrdersController extends AbstractController<OrderEntity>{

    @Autowired
    OrdersService ordersService;

    @Autowired
    OrderPositionsService orderPositionsService;

    @RequestMapping
    public Result<List<OrderEntity>> search(){
        return run(() -> ordersService.search());
    }

    @RequestMapping(value = "/{id}")
    public Result<OrderEntity> get(@PathVariable Long id){
        return run(() -> ordersService.get(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result<Long> create(@RequestBody OrderEntity order) {
        return run(()-> ordersService.create(order));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result<Boolean> delete(@PathVariable Long id){
        return run(() -> ordersService.delete(id));
    }

    @RequestMapping(value = "/{id}/positions")
    public Result<List<OrderPositionEntity>> search(@PathVariable Long id){
        return run(() -> orderPositionsService.search(id));
    }

    @RequestMapping(value = "/{id}/positions", method = RequestMethod.POST)
    public Result<Long> create(@PathVariable Long id, @RequestBody OrderPositionEntity orderPosition) {
        return run(()->orderPositionsService.create(id, orderPosition));
    }

}
