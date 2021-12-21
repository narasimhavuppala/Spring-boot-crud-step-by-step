package com.university.crud.springbootcrudrest;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Crud APP", version = "1.0", description = "sample APP"))
public class SpringBootCrudRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCrudRestApplication.class, args);
    }
}
