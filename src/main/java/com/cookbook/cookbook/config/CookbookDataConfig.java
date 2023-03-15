package com.cookbook.cookbook.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "datasource.cookbook")
public class CookbookDataConfig extends HikariConfig {

    @Bean
    @FlywayDataSource
    public DataSource cookbookDataSource(){
        return new HikariDataSource(this);
    }
}
