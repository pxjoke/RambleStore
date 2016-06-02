package com.pxjoke.controllers;

import com.pxjoke.entities.ItemEntity;
import com.pxjoke.requests.items.CreateItemRequestArguments;
import com.pxjoke.services.ItemsService;
import com.pxjoke.services.OrderPositionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController extends AbstractController<ItemEntity> {

    @Autowired
    ItemsService itemsService;

    @Autowired
    OrderPositionsService orderPositionsService;

    @RequestMapping
    public Result<List<ItemEntity>> search() {
        return run(() -> itemsService.search());
    }

    @RequestMapping(value = "/{id}")
    public Result<ItemEntity> get(@PathVariable Long id) {
        return run(() -> itemsService.get(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result<Long> create(@RequestBody final ItemEntity item) {
        return run(() -> itemsService.create(item));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result<Boolean> delete(@PathVariable Long id){
        return run(() -> itemsService.delete(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result<Boolean> update(@PathVariable Long id, @RequestBody ItemEntity item){
        return run(() -> itemsService.update(id, item));
    }

    @RequestMapping(value = "/{id}/addToCart", method = RequestMethod.POST)
    public Result<Long> addToCart(@PathVariable Long id) {
        return run(() -> orderPositionsService.addToCart(id));
    }

}
