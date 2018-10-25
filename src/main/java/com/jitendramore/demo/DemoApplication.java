package com.jitendramore.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.lang.String;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.core.env.Environment;



//@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringBootApplication
@Configuration
@PropertySources({
		@PropertySource("classpath:application.properties"),
		@PropertySource("classpath:email.properties")
})
public class DemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DemoApplication.class, args);
		//SpringApplication.run(DemoApplication.class, args);
		ConfigurableApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
		DataBase db = (DataBase)ctx.getBean(DataBase.class);
		System.out.println("Name : " + db.getName());
		System.out.println("Password :" + db.getPassword());

		Contact co = (Contact)ctx.getBean(Contact.class);
		System.out.println("Email : " + co.getEmail());
		System.out.println("Mobile :" + co.getMobile());

	}

	/**
	 *
	 */
	@Autowired
	Environment env;

	@Value("${dbusername.name}")
	public String name;

	@Value("${dbpassword.password}")
	public String password;

	@Value("${contact.mobile}")
	public String mobile;

	@Value("${contact.email}")
	public String email;

	@Bean
	public DataBase getDetails()
	{
		DataBase db = new DataBase();
		db.setName(name);
		db.setPassword(password);
		return db;
	}

	@Bean
	public Contact getContact()
	{
		Contact co = new Contact();
		co.setEmail(email);
		co.setMobile(mobile);
		return co;
	}

	@Bean
	public  static PropertySourcesPlaceholderConfigurer property()
	{
		return new PropertySourcesPlaceholderConfigurer();
	}

}
