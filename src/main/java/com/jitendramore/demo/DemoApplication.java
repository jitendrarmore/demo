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
@PropertySource("classpath:application.properties")
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		//SpringApplication.run(DemoApplication.class, args);
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, "classpath:application.properties");
		DataBase db = (DataBase)ctx.getBean(DataBase.class);
		System.out.println("Name : " + db.getName());
		System.out.println("Password :" + db.getPassword());

	}


	@Value("${dbusername.name}")
	public String name;
	@Value("${dbpassword.password}")
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
