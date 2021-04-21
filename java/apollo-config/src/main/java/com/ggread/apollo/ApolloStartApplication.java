package com.ggread.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableApolloConfig
@SpringBootApplication
public class ApolloStartApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApolloStartApplication.class, args);
    }
}
