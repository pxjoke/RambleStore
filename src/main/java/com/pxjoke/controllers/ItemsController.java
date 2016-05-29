package com.pxjoke.controllers;

import com.pxjoke.entities.ItemEntity;
import com.pxjoke.services.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    ItemsService itemsService;

    @RequestMapping
    public List<ItemEntity> search(){
        return itemsService.seacrh();
    }

}
