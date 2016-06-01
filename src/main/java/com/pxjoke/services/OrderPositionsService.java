package com.pxjoke.services;

import com.pxjoke.dao.OrderPositionsDAO;
import com.pxjoke.entities.OrderPositionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderPositionsService extends AbstractService<OrderPositionEntity> {

    @Autowired
    private OrderPositionsDAO orderPositionsDAO;

    public final List<OrderPositionEntity> search(final Long id){
        return orderPositionsDAO.search(id);
    }

    public final Boolean delete(final Long id) {
        return orderPositionsDAO.delete(id);
    }

    public final Long create(OrderPositionEntity orderPosition) {
        return orderPositionsDAO.create(orderPosition);
    }


}
