package com.pxjoke.dao;

import com.pxjoke.entities.OrderEntity;
import com.pxjoke.entities.UserEntity;
import com.pxjoke.mappers.OrdersMapper;
import com.pxjoke.mappers.UsersMapper;
import com.pxjoke.special.Arguments;
import com.pxjoke.tables.OrdersTable;
import com.pxjoke.tables.UsersTable;
import org.springframework.beans.factory.annotation.Required;

import java.util.List;

public class OrdersDAO extends AbstractDAO<OrderEntity> {
    private String searchQuery;
    private String getByIDQuery;
    private String createQuery;
    private String deleteQuery;
    private String searchForAccountQuery;

    public OrdersDAO() {
        super(new OrdersMapper());
    }

    public final List<OrderEntity> search(){
        return search(searchQuery, null);
    }

    public final List<OrderEntity> searchForAccount(Long userID){
        return search(searchForAccountQuery, new Arguments(OrdersTable.USER_ID, userID));
    }

    public final OrderEntity get(Long id){
        return get(getByIDQuery, new Arguments(OrdersTable.ORDER_ID, id));
    }

    public final Long create(OrderEntity order) {
        final Arguments arguments = new Arguments();
        arguments.add(OrdersTable.USER_ID,    order.userID);
        arguments.add(OrdersTable.SALE_DATE,  order.saleDate);

        return insert(createQuery, arguments);
    }

    public final Boolean delete(final Long id) {
        return update(deleteQuery, new Arguments(OrdersTable.ORDER_ID, id));
    }

    @Required
    public void setSearchQuery(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    @Required
    public void setGetByIDQuery(String getByIDQuery) {
        this.getByIDQuery = getByIDQuery;
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
    public void setSearchForAccountQuery(String searchForAccountQuery) {
        this.searchForAccountQuery = searchForAccountQuery;
    }


}
