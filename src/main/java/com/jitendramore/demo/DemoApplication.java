package com.jitendramore.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;

@SpringBootApplication
@Configuration

public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		SpringApplication.run(DemoApplication.class, args);

	}


	@Value("${jitendramore.name}")
	public String name;
	@Value("${jitendramore.password}")
	public String password;

	@Bean
	public DataBase getDetails()
	{
		DataBase db = new DataBase();
		db.setName(name);
		db.setPassword(password);
		return db;
	}

	@Bean
	public  static PropertySourcesPlaceholderConfigurer property()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}

}
