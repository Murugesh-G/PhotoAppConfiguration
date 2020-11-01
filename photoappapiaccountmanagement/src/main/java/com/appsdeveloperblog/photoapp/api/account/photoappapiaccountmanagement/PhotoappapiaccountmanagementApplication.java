package com.appsdeveloperblog.photoapp.api.account.photoappapiaccountmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan("com.appsdeveloperblog.photoapp.api.account")
public class PhotoappapiaccountmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotoappapiaccountmanagementApplication.class, args);
    }

}
