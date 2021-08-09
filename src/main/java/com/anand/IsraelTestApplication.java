package com.anand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy
public class IsraelTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(IsraelTestApplication.class, args);
    }

}
