package com.cookbook.cookbook.Config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;
import java.util.Properties;


@Configuration
@EnableConfigurationProperties(Properties.class)
@ConfigurationProperties(prefix = "datasource.cookbook")
public class CookbookDataConfig extends HikariConfig {

    @Bean
    @FlywayDataSource
    public DataSource acqDataSource(){
        return new HikariDataSource(this);
    }
}
