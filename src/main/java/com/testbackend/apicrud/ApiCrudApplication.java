package com.testbackend.apicrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiCrudApplication.class, args);
        System.out.println("Server Started Successfully On Port: 3001");
    }

}
