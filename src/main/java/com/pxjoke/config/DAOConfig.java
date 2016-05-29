package com.pxjoke.config;

import com.pxjoke.dao.ItemsDAO;
import oracle.jdbc.pool.OracleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
public class DAOConfig {

    @Bean
    public ItemsDAO itemsDAO() throws SQLException {
        ItemsDAO itemsDAO = new ItemsDAO();
        itemsDAO.setSearchQuery("select * from items");
        itemsDAO.setDataSource(dataSource());
        return itemsDAO;
    }

    @Bean
    DataSource dataSource() throws SQLException {
        OracleDataSource dataSource = new OracleDataSource();
        dataSource.setUser("ramble");
        dataSource.setPassword("!!Gradle89");
        dataSource.setURL("jdbc:oracle:thin:@127.0.0.1:1521:XE");
        dataSource.setImplicitCachingEnabled(true);
        dataSource.setFastConnectionFailoverEnabled(true);
        return dataSource;
    }
}
