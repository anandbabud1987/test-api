package com.anand.hometest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@SpringBootApplication
@ComponentScan("com.anand.*")
@EnableAutoConfiguration
@EntityScan("com.anand.*")
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
