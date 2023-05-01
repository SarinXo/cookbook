package com.cookbook.cookbook.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import javax.sql.DataSource;

@TestPropertySource(
        properties = {"spring.flyway.enabled=true", "spring.jpa.properties.eclipselink.ddl-generation=none"}
)
@ContextConfiguration(
        classes = {PostgreSQLContainerBase.DatabaseConfig.class}
)
@Testcontainers
public abstract class PostgreSQLContainerBase {

    protected static final PostgreSQLContainer<?> postgreDBContainer = new PostgreSQLContainer("postgres:12.6");

    protected PostgreSQLContainerBase(){}

    static {postgreDBContainer.start();}

    @TestConfiguration
    static class DatabaseConfig{
        DatabaseConfig(){
        }

        @Bean
        @FlywayDataSource
        public DataSource acqDataSource(){
            HikariDataSource hikariDataSource = new HikariDataSource();

            hikariDataSource.setJdbcUrl(PostgreSQLContainerBase.postgreDBContainer.getJdbcUrl());
            hikariDataSource.setUsername(PostgreSQLContainerBase.postgreDBContainer.getUsername());
            hikariDataSource.setPassword(PostgreSQLContainerBase.postgreDBContainer.getPassword());
            hikariDataSource.setDriverClassName("org.postgresql.Driver");

            return hikariDataSource;

        }
    }

}

