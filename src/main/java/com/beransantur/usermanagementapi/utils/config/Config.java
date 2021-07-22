package com.beransantur.usermanagementapi.utils.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
@Setter
@Getter
@ConfigurationProperties("mysqlconnection")
public class Config {

    @Value("url")
    private String url;

    @Value("username")
    private String username;

    @Value("password")
    private String password;

    @Bean
    public Sql2o sql2oConnection(){
        return new Sql2o(url, username, password);
    }
}
