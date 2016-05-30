package com.pxjoke.controllers;

import com.pxjoke.entities.ItemEntity;
import com.pxjoke.requests.items.CreateItemRequestArguments;
import com.pxjoke.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController extends AbstractController<ItemEntity> {

    @Autowired
    ItemsService itemsService;

    @RequestMapping
    public Result<List<ItemEntity>> search() {
        return run(() -> itemsService.search());
    }

    @RequestMapping(value = "/{id}")
    public Result<ItemEntity> get(@PathVariable Long id) {
        return run(() -> itemsService.get(id));
    }

    @RequestMapping(method = RequestMethod.POST)
    public Result<Long> create(@RequestBody final CreateItemRequestArguments itemRequestArguments) {
        return run(() -> itemsService.create(itemRequestArguments));
    }

}
