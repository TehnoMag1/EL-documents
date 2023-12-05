package com.example.eldocuments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class ElDocumentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElDocumentsApplication.class, args);
    }

}
