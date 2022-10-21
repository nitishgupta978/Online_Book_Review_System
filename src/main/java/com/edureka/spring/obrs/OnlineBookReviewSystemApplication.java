package com.edureka.spring.obrs;

import com.edureka.spring.obrs.common.dto.StorageProperties;
import com.edureka.spring.obrs.common.service.StorageServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.io.File;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class OnlineBookReviewSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineBookReviewSystemApplication.class, args);
    }
}

