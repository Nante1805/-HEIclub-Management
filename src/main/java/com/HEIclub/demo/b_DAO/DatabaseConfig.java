package com.HEIclub.demo.b_DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Value;

@Configuration
public class DatabaseConfig {
    @Value("${DATABASE_URL}")
    private String dbUrl;

    @Value("${PSQL_USER_NAME}")
    private String dbUsername;

    @Value("${PSQL_PWD}")
    private String dbPassword;

    @Bean
    public Connection getDatabaseConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
    }

    @Bean
    public EtudiantDAO clientDAO(Connection connection) {
        return new EtudiantDAO(connection);
    }
}