package com.coderhouse.final_project.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class ApplicationProperties {

    //jwt
    @Value("${jwt.secret}")
    private String jwtSecret;
    @Value("${jwt.expiration}")
    private int expiration;

    //redis
    private String host;
    private Integer port;
    private String password;
    private Boolean ssl;
    private Integer timeOfLife;

}
