package com.pxjoke.config;

import com.pxjoke.dao.ItemsDAO;
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
        itemsDAO.setDataSource(dataSource());
        return itemsDAO;
    }

    @Bean
    public UsersDAO usersDAO() throws SQLException {
        UsersDAO usersDAO = new UsersDAO();
        usersDAO.setSearchQuery("select * from users");
        usersDAO.setGetByIDQuery("select * from users where id = :USER_ID");
        usersDAO.setDataSource(dataSource());
        return usersDAO;
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
