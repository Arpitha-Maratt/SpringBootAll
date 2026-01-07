package com.arpitha.task.util;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

public class DBConnectionSingleton {

    private static JdbcTemplate jdbcTemplate;

    private DBConnectionSingleton() {}

    public static JdbcTemplate getInstance() {
        if (jdbcTemplate == null) {
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/taskP");
            dataSource.setUsername("root");
            dataSource.setPassword("3306");
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        return jdbcTemplate;
    }
}
