package com.pxjoke.dao;

import com.pxjoke.entities.OrderPositionEntity;
import com.pxjoke.entities.UserEntity;
import com.pxjoke.mappers.OrderPositionMapper;
import com.pxjoke.mappers.UsersMapper;
import com.pxjoke.special.Arguments;
import com.pxjoke.tables.OrderPositionTable;
import com.pxjoke.tables.OrdersTable;
import com.pxjoke.tables.UsersTable;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class OrderPositionsDAO extends AbstractDAO<OrderPositionEntity> {
    private String searchQuery;
    private String createQuery;
    private String deleteQuery;
    private String searchForCartQuery;
    private String addToCartQuery;

    public OrderPositionsDAO() {
        super(new OrderPositionMapper());
    }

    public final List<OrderPositionEntity> search(final Long id){
        return search(searchQuery, new Arguments(OrderPositionTable.ORDER_ID, id));
    }

    public final List<OrderPositionEntity> searchForCart(final Long userID){
        return search(searchForCartQuery, new Arguments(UsersTable.USER_ID, userID));
    }

    public final Long addToCart(Long userID, Long itemID) {
        final Arguments arguments = new Arguments();
        arguments.add(OrdersTable.USER_ID,         userID);
        arguments.add(OrderPositionTable.ITEM_ID,  itemID);

        return insert(addToCartQuery, arguments);
    }

    public final Long create(Long orderID, OrderPositionEntity orderPosition) {
        final Arguments arguments = new Arguments();
        arguments.add(OrderPositionTable.ORDER_ID, orderID);
        arguments.add(OrderPositionTable.ITEM_ID,  orderPosition.itemID);
        arguments.add(OrderPositionTable.PRICE,    orderPosition.price);
        arguments.add(OrderPositionTable.AMOUNT,   orderPosition.amount);

        return insert(createQuery, arguments);
    }

    public final Boolean delete(final Long id) {
        return update(deleteQuery, new Arguments(OrderPositionTable.ORDER_POSITION_ID, id));
    }

    @Required
    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    @Required
    public void setCreateQuery(String createQuery) {
        this.createQuery = createQuery;
    }

    @Required
    public void setDeleteQuery(String deleteQuery) {
        this.deleteQuery = deleteQuery;
    }

    @Required
    public void setSearchForCartQuery(String searchForCartQuery) {
        this.searchForCartQuery = searchForCartQuery;
    }

    @Required
    public void setAddToCartQuery(String addToCartQuery) {
        this.addToCartQuery = addToCartQuery;
    }

}
