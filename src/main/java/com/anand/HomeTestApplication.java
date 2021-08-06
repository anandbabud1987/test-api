package com.anand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@EnableCaching
@Configuration
@EnableWebMvc
public class HomeTestApplication extends WebMvcConfigurerAdapter {
    @Override
	 public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**");
	    }
	 public static void main(String[] args) {
		SpringApplication.run(HomeTestApplication.class, args);
	}

}
