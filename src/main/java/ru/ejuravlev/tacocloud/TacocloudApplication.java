package ru.ejuravlev.tacocloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TacocloudApplication implements WebMvcConfigurer {

  public static void main(String[] args) {
    SpringApplication.run(TacocloudApplication.class, args);
  }

  @Override
  public void addViewControllers(@NonNull ViewControllerRegistry registry) {
	  registry.addViewController("/").setViewName("home");
  }

}
