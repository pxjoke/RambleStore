package com.pxjoke.config;

import com.pxjoke.dao.ItemsDAO;
import com.pxjoke.dao.OrderPositionsDAO;
import com.pxjoke.dao.OrdersDAO;
import com.pxjoke.dao.UsersDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DAOConfig {

    @Bean
    public ItemsDAO itemsDAO() throws SQLException {
        ItemsDAO itemsDAO = new ItemsDAO();
        itemsDAO.setSearchQuery("select * from items");
        itemsDAO.setGetByIDQuery("select * from items where id = :ITEM_ID");
        itemsDAO.setCreateQuery("INSERT INTO ITEMS (TITLE,\n" +
                "                   COMPANY,\n" +
                "                   DESCRIPTION,\n" +
                "                   GENRE,\n" +
                "                   IMG,\n" +
                "                   PRICE,\n" +
                "                   RELEASE_DATE)\n" +
                "    VALUES (:TITLE,\n" +
                "            :COMPANY,\n" +
                "            :DESCRIPTION,\n" +
                "            :GENRE,\n" +
                "            :IMG,\n" +
                "            :PRICE,\n" +
                "            :RELEASE_DATE)");
        itemsDAO.setUpdateQuery("UPDATE items SET " +
                "                TITLE        = :TITLE,\n" +
                "                COMPANY      = :COMPANY,\n" +
                "                DESCRIPTION  = :DESCRIPTION,\n" +
                "                GENRE        = :GENRE,\n" +
                "                IMG          = :IMG,\n" +
                "                PRICE        = :PRICE,\n" +
                "                RELEASE_DATE = :RELEASE_DATE\n" +
                "                WHERE ID = :ITEM_ID");
        itemsDAO.setDataSource(dataSource());
        itemsDAO.setDeleteQuery("DELETE FROM items where id = :ITEM_ID");
        return itemsDAO;
    }

    @Bean
    public UsersDAO usersDAO() throws SQLException {
        UsersDAO usersDAO = new UsersDAO();
        usersDAO.setSearchQuery("select * from users");
        usersDAO.setGetByIDQuery("select * from users where id = :USER_ID");
        usersDAO.setCreateQuery("INSERT INTO users (EMAIL, PASSWORD, ROLE) " +
                "VALUES (:EMAIL, :PASSWORD, 'user')");
        usersDAO.setDeleteQuery("DELETE FROM users where id = :USER_ID");
        usersDAO.setUpdateQuery("UPDATE users SET " +
                "PASSWORD = :PASSWORD, " +
                "ROLE = :ROLE " +
                "WHERE ID = :USER_ID");
        usersDAO.setLoginQuery("SELECT * FROM users where " +
                "EMAIL = :EMAIL AND PASSWORD = :PASSWORD");
        usersDAO.setDataSource(dataSource());
        return usersDAO;
    }

    @Bean
    public OrdersDAO ordersDAO() throws SQLException {
        OrdersDAO ordersDAO = new OrdersDAO();
        ordersDAO.setSearchQuery("select orders.*, " +
                "SUM(positions.price) sum, " +
                "COUNT(positions.id) count " +
                " from orders " +
                "JOIN order_position positions " +
                "ON positions.ORDER_ID = orders.id " +
                "WHERE status <> 'cart' " +
                "GROUP BY orders.id");
        ordersDAO.setGetByIDQuery("select orders.*, " +
                "SUM(positions.price) sum, " +
                "COUNT(positions.id) count " +
                "from orders " +
                "JOIN order_position positions" +
                " ON positions.ORDER_ID = orders.id " +
                " where orders.id = :ORDER_ID");
        ordersDAO.setGetCartQuery("select orders.*, " +
                "SUM(positions.price) sum, " +
                "COUNT(positions.id) count " +
                "from orders " +
                "JOIN order_position positions" +
                " ON positions.ORDER_ID = orders.id " +
                " where status = 'cart' and USER_ID = :USER_ID");
        ordersDAO.setCloseCartQuery("UPDATE orders SET status = 'paid' where status = 'cart' and USER_ID = :USER_ID");
        ordersDAO.setSearchForAccountQuery("select orders.*, " +
                "SUM(positions.price) sum, " +
                "COUNT(positions.id) count " +
                "from orders " +
                "JOIN order_position positions " +
                "ON positions.ORDER_ID = orders.id " +
                "where USER_ID = :USER_ID " +
                "AND orders.status <> 'cart' " +
                "GROUP BY orders.id");
        ordersDAO.setCreateQuery("INSERT INTO orders (USER_ID, SALE_DATE, STATUS) " +
                  "VALUES (:USER_ID, :SALE_DATE, 'cart')");
        ordersDAO.setCreateCartQuery("INSERT INTO orders (USER_ID, SALE_DATE, STATUS) " +
                "VALUES (:USER_ID, now(), 'cart')");
        ordersDAO.setDeleteQuery("DELETE FROM orders where id = :ORDER_ID");
        ordersDAO.setDataSource(dataSource());
        return ordersDAO;
    }

    @Bean
    public OrderPositionsDAO orderPositionsDAO() throws SQLException {
        OrderPositionsDAO orderPositionsDAO = new OrderPositionsDAO();
        orderPositionsDAO.setSearchQuery("select * from order_position " +
                "JOIN items ON ITEM_ID = items.id " +
                " where ORDER_ID = :ORDER_ID");
        orderPositionsDAO.setSearchForCartQuery("select * from order_position " +
                "JOIN items ON ITEM_ID = items.id " +
                "JOIN orders ON ORDER_ID = orders.id " +
                " where orders.USER_ID = :USER_ID and orders.status = 'cart'");
        orderPositionsDAO.setCreateQuery("INSERT INTO order_position (ORDER_ID, ITEM_ID, PRICE, AMOUNT) " +
                "VALUES (:ORDER_ID, :ITEM_ID, :PRICE, :AMOUNT)");
        orderPositionsDAO.setAddToCartQuery("INSERT INTO order_position (ORDER_ID, ITEM_ID, PRICE, AMOUNT) " +
                "VALUES ( " +
                "(select orders.id from orders where status = 'cart' and USER_ID = :USER_ID), " +
                " :ITEM_ID, " +
                "(select items.price from items where items.id = :ITEM_ID), " +
                "1 )");
        orderPositionsDAO.setDeleteQuery("DELETE FROM order_position where id = :ORDER_POSITION_ID");
        orderPositionsDAO.setDataSource(dataSource());
        return orderPositionsDAO;
    }

    @Bean(destroyMethod = "shutdown")
    public EmbeddedDatabase dataSource() {
        return new EmbeddedDatabaseBuilder().
                setType(EmbeddedDatabaseType.H2).
                addScript("db-schema.sql").
                addScript("db-data.sql").
                build();
    }
//    @Bean
//    DataSource dataSource() throws SQLException {
//        OracleDataSource dataSource = new OracleDataSource();
//        dataSource.setUser("ramble");
//        dataSource.setPassword("!!Gradle89");
//        dataSource.setURL("jdbc:oracle:thin:@127.0.0.1:1521:XE");
//        dataSource.setImplicitCachingEnabled(true);
//        dataSource.setFastConnectionFailoverEnabled(true);
//        return dataSource;
//    }
}
