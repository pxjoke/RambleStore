package com.pxjoke.services;

import com.pxjoke.dao.ItemsDAO;
import com.pxjoke.entities.ItemEntity;
import com.pxjoke.requests.items.CreateItemRequestArguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemsService extends AbstractService<ItemEntity> {

    @Autowired
    private ItemsDAO itemsDAO;

    public final List<ItemEntity> search(){
        return itemsDAO.search();
    }

    public final ItemEntity get(Long id){
        return itemsDAO.get(id);
    }

    public final Long create(final CreateItemRequestArguments itemRequestArguments){
        return itemsDAO.create(itemRequestArguments);
    }

}
