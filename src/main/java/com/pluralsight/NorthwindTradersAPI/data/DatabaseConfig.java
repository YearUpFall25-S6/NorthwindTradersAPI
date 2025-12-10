package com.pluralsight.NorthwindTradersAPI.data;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    BasicDataSource basicDataSource;
    private static final Logger log = LoggerFactory.getLogger(DatabaseConfig.class);

   // Logger logger;

    @Bean
    public DataSource dataSource(){
        return basicDataSource;
    }

    public DatabaseConfig(
            @Value("${datasource.url}") String url,
            @Value("${datasource.username}") String username,
            @Value("${datasource.password}") String password){
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(url);
        basicDataSource.setUsername(username);
        basicDataSource.setPassword(password);


        log.info("From the DatabaseConfig Contructor:{} {}", url, username);

    }


}
