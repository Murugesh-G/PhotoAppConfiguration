package com.appsdeveloperblog.photoapp.api.users.photoappapiusers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.appsdeveloperblog.photoapp.api.users")
@EnableJpaRepositories("com.appsdeveloperblog.photoapp.api.users.data")
@EntityScan("com.appsdeveloperblog.photoapp.api.users.data")
public class PhotoappapiusersApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoappapiusersApplication.class, args);
    }


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
