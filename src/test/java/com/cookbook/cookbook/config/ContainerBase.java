package com.cookbook.cookbook.config;


import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.jdbc.JdbcDatabaseDelegate;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = "spring.jpa.properties.eclipselink.application-location=.")
public class ContainerBase extends PostgreSQLContainerBase{

    static { JdbcDatabaseDelegate containerDelegate = new JdbcDatabaseDelegate(postgreDBContainer, "");}
}
