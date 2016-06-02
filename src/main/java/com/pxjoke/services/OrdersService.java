package com.pxjoke.services;

import com.pxjoke.dao.OrdersDAO;
import com.pxjoke.entities.OrderEntity;
import com.pxjoke.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService extends AbstractService<OrderEntity> {

    @Autowired
    private OrdersDAO ordersDAO;

    public final List<OrderEntity> search(){
        return ordersDAO.search();
    }

    public final List<OrderEntity> searchForAccount(){
        final Long userID = new Long(1);
        return ordersDAO.searchForAccount(userID);
    }

    public final OrderEntity get(Long id){
        return ordersDAO.get(id);
    }

    public final OrderEntity getCart(){
        final Long userID = new Long(1);
        return ordersDAO.getCart(userID);
    }

    public final boolean closeCart(){
        final Long userID = new Long(1);
        return  ordersDAO.closeCart(userID) && ordersDAO.createCart(userID) > 0;
    }

    public final Boolean delete(Long id) {
        return ordersDAO.delete(id);
    }

    public final Long create(OrderEntity order) {
        return ordersDAO.create(order);
    }


}
